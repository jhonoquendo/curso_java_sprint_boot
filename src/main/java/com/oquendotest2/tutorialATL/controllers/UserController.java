package com.oquendotest2.tutorialATL.controllers;

import com.oquendotest2.tutorialATL.dao.UserDao;
import com.oquendotest2.tutorialATL.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="api/users")
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userDao.deleteUser(id);
    }

    @RequestMapping(value="api/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userDao.createUser(user);
    }
}
