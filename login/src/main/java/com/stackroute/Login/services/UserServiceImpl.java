package com.stackroute.Login.services;

import com.stackroute.Login.model.User;
import com.stackroute.Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
            return  userRepository.save(user);
        }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User findByUserIdAndPassword(String userId, String password)  {
        return userRepository.findByUserIdAndPassword(userId,password);

    }
}
