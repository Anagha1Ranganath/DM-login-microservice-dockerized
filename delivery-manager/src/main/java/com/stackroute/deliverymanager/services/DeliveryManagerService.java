package com.stackroute.deliverymanager.services;

import com.stackroute.deliverymanager.exception.UserNotFoundException;
import com.stackroute.deliverymanager.model.DeliveryManager;

import java.util.List;

public interface DeliveryManagerService {
    public DeliveryManager saveManager(DeliveryManager deliveryManager);
    public List<DeliveryManager> getAllManagers();
    public DeliveryManager findByManagerIdAndPassword(String managerId, String password);
}
