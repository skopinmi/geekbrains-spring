package com.geekbrains.spring.lesson8.populators;

import com.geekbrains.spring.lesson8.data.UserData;
import com.geekbrains.spring.lesson8.entities.User;
import org.springframework.stereotype.Service;
@Service
public class UserPopulator implements Populator<User, UserData> {

    @Override
    public UserData populate(User user, UserData userData) {
        if(user == null || userData == null)
            return null;
        userData.setName(user.getName());
        userData.setUsername(user.getUsername());
//        userData.setRoles(user.getRoles());
        userData.setPhone(user.getPhone());
        return userData;
    }

    @Override
    public UserData populate(User user) {

        return populate(user, new UserData());
    }


}
