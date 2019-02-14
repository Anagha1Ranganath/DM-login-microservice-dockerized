package com.stackroute.deliverymanager.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryManager
{
    public String getManagerId() {
        return managerId;
    }
//
//    public DeliveryManager(String managerId, String password) {
//        this.managerId = managerId;
//        this.password = password;
//    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    private String managerId;
    private String password;

}
