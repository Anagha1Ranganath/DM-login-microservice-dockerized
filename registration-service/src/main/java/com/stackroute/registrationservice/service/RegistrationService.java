package com.stackroute.registrationservice.service;

import com.stackroute.registrationservice.domain.Registration;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface RegistrationService
{
    public Registration saveUser(Registration registration) throws UserAlreadyExistsException, UserNotFoundException;
    public List<Registration> getAllUser();
    public boolean deleteUser(String id) throws UserNotFoundException;
    public Registration updateUser(String pass, String mail, String id) throws UserNotFoundException;
}
