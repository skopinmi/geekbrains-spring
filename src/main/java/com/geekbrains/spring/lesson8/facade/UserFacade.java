package com.geekbrains.spring.lesson8.facade;

import com.geekbrains.spring.lesson8.data.UserData;
import com.geekbrains.spring.lesson8.entities.User;
import com.geekbrains.spring.lesson8.populators.UserPopulator;
import com.geekbrains.spring.lesson8.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFacade {
    private UserService userService;
    private UserPopulator userPopulator;

    public UserFacade(UserService userService, UserPopulator userPopulator) {
        this.userService = userService;
        this.userPopulator = userPopulator;
    }

    public List <UserData> getAllUserData(){
        return userPopulator.convertAll(userService.getAllUser());
    }

//    public List<User> getAllUser() {
//        return userRepository.findAll();
//    }

}
