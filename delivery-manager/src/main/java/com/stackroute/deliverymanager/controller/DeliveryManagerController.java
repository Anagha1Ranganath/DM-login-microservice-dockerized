package com.stackroute.deliverymanager.controller;


import com.stackroute.deliverymanager.exception.UserIdAndPasswordMismatchException;
import com.stackroute.deliverymanager.exception.UserNameOrPasswordEmpty;
import com.stackroute.deliverymanager.exception.UserNotFoundException;
import com.stackroute.deliverymanager.model.DeliveryManager;
import com.stackroute.deliverymanager.security.SecurityTokenGenerator;
import com.stackroute.deliverymanager.services.DeliveryManagerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("api/")
public class DeliveryManagerController {

    @Autowired
    private DeliveryManagerService deliveryManagerService;

    @Autowired
    public DeliveryManagerController(DeliveryManagerService deliveryManagerService) {
        this.deliveryManagerService = deliveryManagerService;
    }

    @PostMapping("deliveryManager")
    public ResponseEntity login(@RequestBody DeliveryManager loginDetails) {
        try {

            String managerId = loginDetails.getManagerId();
            String password = loginDetails.getPassword();

            if (managerId == null || password == null) {
                throw new UserNameOrPasswordEmpty("Userid and Password cannot be empty");
            }

            DeliveryManager deliveryManager = deliveryManagerService.findByManagerIdAndPassword(managerId, password);

            if (deliveryManager == null) {
                throw new UserNotFoundException("User with given Id does not exists");
            }

            String fetchedPassword = deliveryManager.getPassword();
            if (!password.equals(fetchedPassword)) {
                throw new UserIdAndPasswordMismatchException("Invalid login credential, Please check username and password ");
            }

            // generating token
            SecurityTokenGenerator securityTokenGenerator = (DeliveryManager userDetails) -> {

                String jwtToken = "";
                jwtToken = Jwts.builder().setId(deliveryManager.getManagerId()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

                Map<String, String> map1 = new HashMap<>();
                map1.put("token", jwtToken);
                map1.put("message", "User successfully logged in");
                return map1;
            };

            Map<String, String> map = securityTokenGenerator.generateToken(deliveryManager);

            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (UserNameOrPasswordEmpty | UserNotFoundException | UserIdAndPasswordMismatchException exception) {

            return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
        }
    }


    @GetMapping("deliveryManager")
    public ResponseEntity<?> getAllManagers()
    {
        return new ResponseEntity<List<DeliveryManager>>(deliveryManagerService.getAllManagers(),HttpStatus.OK);
    }

    @PostMapping("deliveryManagers")
    public ResponseEntity<?> saveEvent(@RequestBody DeliveryManager deliveryManager)
    {
        return new ResponseEntity<>(deliveryManager, HttpStatus.CREATED);
    }
}
