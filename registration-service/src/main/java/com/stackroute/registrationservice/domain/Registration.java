package com.stackroute.registrationservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Registrations")
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Registration
{
    private String name;
    private String userId;
    private String password;
    private String emailId;

    public Registration(String name, String userId, String password, String emailId) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.emailId = emailId;
    }
}
