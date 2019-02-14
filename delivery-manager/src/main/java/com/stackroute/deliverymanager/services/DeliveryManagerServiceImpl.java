package com.stackroute.deliverymanager.services;

import com.stackroute.deliverymanager.exception.UserNotFoundException;
import com.stackroute.deliverymanager.model.DeliveryManager;
import com.stackroute.deliverymanager.repository.DeliveryManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManagerServiceImpl implements DeliveryManagerService {

    private DeliveryManagerRepository deliveryManagerRepository;

    @Autowired
    public DeliveryManagerServiceImpl(DeliveryManagerRepository deliveryManagerRepository) {
        super();
        this.deliveryManagerRepository = deliveryManagerRepository;
    }

    @Override
    public DeliveryManager saveManager(DeliveryManager deliveryManager){return deliveryManagerRepository.save(deliveryManager);}

    @Override
    public List<DeliveryManager> getAllManagers(){return deliveryManagerRepository.findAll();}

    @Override
    public DeliveryManager findByManagerIdAndPassword(String managerId, String password) {
        return deliveryManagerRepository.findByManagerIdAndPassword(managerId,password);
    }

}
