package com.oquendotest2.tutorialATL.controllers;

import com.oquendotest2.tutorialATL.dao.UserDao;
import com.oquendotest2.tutorialATL.models.User;
import com.oquendotest2.tutorialATL.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/users")
    public List<User> getUsers(@RequestHeader(value = "Authorization") String token){
        if(validateToken(token)){
            return null;
        }

        return userDao.getUsers();
    }

    private boolean validateToken(String token){
        String userId = jwtUtil.getKey(token);

        return userId == null;
    }

    private String hashPassword(String password){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1,1024,1,password);
    }

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value = "Authorization") String token,@PathVariable Long id){

        if(validateToken(token)){
            return;
        }

        userDao.deleteUser(id);
    }

    @RequestMapping(value="api/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user){

        user.setPassword(hashPassword(user.getPassword()));
        userDao.createUser(user);

    }
}
