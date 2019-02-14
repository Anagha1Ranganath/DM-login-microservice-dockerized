package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.Registration;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService
{
    private RegistrationRepository registrationRepository;
    private Registration registration;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository)
    {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public Registration saveUser(Registration registration) throws UserAlreadyExistsException, UserNotFoundException {
        Optional optional = registrationRepository.findById(registration.getUserId());
        if((optional.isPresent()))
        {
            throw new UserAlreadyExistsException();
        }
        return registrationRepository.insert(registration);
    }

    @Override
    public List<Registration> getAllUser()
    {
        return registrationRepository.findAll();
    }

    @Override
    public boolean deleteUser(String id) throws UserNotFoundException {
        boolean status = false;
        Optional optional = registrationRepository.findById(id);
        if(optional.isPresent())
        {
            registrationRepository.deleteById(id);
            status=true;
        }
        else
        {
            throw new UserNotFoundException();
        }
        return status;
    }

    @Override
    public Registration updateUser(String pass,String mail, String id) throws UserNotFoundException {
        Optional optional = registrationRepository.findById(id);
        if(optional.isPresent())
        {
            registration=registrationRepository.findById(id).get();
            registration.setPassword(pass);
            registration.setEmailId(mail);
            registrationRepository.save(registration);
        }
        else
        {
            throw new UserNotFoundException();
        }
        return registration;
    }
}
