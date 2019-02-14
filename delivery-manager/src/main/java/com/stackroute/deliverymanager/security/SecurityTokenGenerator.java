package com.stackroute.deliverymanager.security;

import com.stackroute.deliverymanager.model.DeliveryManager;

import java.util.Map;

@FunctionalInterface
public interface SecurityTokenGenerator {
    Map<String, String> generateToken(DeliveryManager deliveryManager);
}
