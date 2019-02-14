package com.stackroute.registrationservice.feedcomponent;

import com.stackroute.registrationservice.domain.Registration;
import com.stackroute.registrationservice.exceptions.UserAlreadyExistsException;
import com.stackroute.registrationservice.exceptions.UserNotFoundException;
import com.stackroute.registrationservice.service.RegistrationService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
//import sun.tools.java.Environment;

@Component
@Data
@Primary
public class SeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    Environment environment;
    @Autowired
    RegistrationService registrationService;
    Registration feedRegistartionData = new Registration();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        feedRegistartionData.setName(environment.getProperty("registration.1.name"));
        feedRegistartionData.setUserId(environment.getProperty("registration.1.userId"));
        feedRegistartionData.setPassword(environment.getProperty("registration.1.password"));
        feedRegistartionData.setEmailId(environment.getProperty("registration.1.emailId"));
        try
        {
            registrationService.saveUser(feedRegistartionData);
        }
        catch (UserAlreadyExistsException ex)
        {
            ex.printStackTrace();
        }
        catch (UserNotFoundException ex1)
        {
            ex1.printStackTrace();
        }

        feedRegistartionData.setName(environment.getProperty("registration.2.name"));
        feedRegistartionData.setUserId(environment.getProperty("registration.2.userId"));
        feedRegistartionData.setPassword(environment.getProperty("registration.2.password"));
        feedRegistartionData.setEmailId(environment.getProperty("registration.2.emailId"));
        try
        {
            registrationService.saveUser(feedRegistartionData);
        }
        catch (UserAlreadyExistsException ex)
        {
            ex.printStackTrace();
        }
        catch (UserNotFoundException ex1)
        {
            ex1.printStackTrace();
        }

        feedRegistartionData.setName(environment.getProperty("registration.3.name"));
        feedRegistartionData.setUserId(environment.getProperty("registration.3.userId"));
        feedRegistartionData.setPassword(environment.getProperty("registration.3.password"));
        feedRegistartionData.setEmailId(environment.getProperty("registration.3.emailId"));
        try
        {
            registrationService.saveUser(feedRegistartionData);
        }
        catch (UserAlreadyExistsException ex)
        {
            ex.printStackTrace();
        }
        catch (UserNotFoundException ex1)
        {
            ex1.printStackTrace();
        }
    }
}
