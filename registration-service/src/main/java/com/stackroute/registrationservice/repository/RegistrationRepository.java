package com.stackroute.registrationservice.repository;

import com.stackroute.registrationservice.domain.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration,String>
{

}
