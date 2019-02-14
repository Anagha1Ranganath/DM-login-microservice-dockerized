package com.stackroute.registrationservice.controller;

import com.stackroute.registrationservice.domain.Registration;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/userregistrationservice/")
public class RegistrationController {

    private ResponseEntity responseEntity;
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("registration")
    public ResponseEntity<?> saveUser(@RequestBody Registration registration) throws UserAlreadyExistsException
    {
        try
        {
           registrationService.saveUser(registration);
           responseEntity=new ResponseEntity(registration, HttpStatus.CREATED);
        }
        catch (UserAlreadyExistsException ex1)
        {
            throw new UserAlreadyExistsException();
        }
        catch (Exception ex2)
        {
            responseEntity=new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("registration/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) throws UserNotFoundException
    {
        try
        {
            registrationService.deleteUser(id);
            responseEntity=new ResponseEntity("Successfully deleted",HttpStatus.OK);
        }
        catch (UserNotFoundException ex2)
        {
            throw new UserNotFoundException();
        }
        catch (Exception exc)
        {
            responseEntity=new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("registration/{id}")
    public ResponseEntity<?> updateUser(@RequestBody Registration registration,@PathVariable("id") String id) throws UserNotFoundException
    {
        try{
            Registration updatedTrack = registrationService.updateUser(registration.getPassword(),registration.getEmailId(),id);
            responseEntity = new ResponseEntity(registration , HttpStatus.OK);
        } catch (UserNotFoundException e) {

            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity("Error !! Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("registration")
    public ResponseEntity<?> getAllUser()
    {
        try
        {
            responseEntity=new ResponseEntity(registrationService.getAllUser(),HttpStatus.OK);
        }
        catch (Exception ex)
        {
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
