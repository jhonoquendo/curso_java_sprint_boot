package com.oquendotest2.tutorialATL.controllers;
import com.oquendotest2.tutorialATL.dao.UserDao;
import com.oquendotest2.tutorialATL.models.Auth;
import com.oquendotest2.tutorialATL.models.User;
import com.oquendotest2.tutorialATL.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public Auth login(@RequestBody User user){

        User userLogged = userDao.verifyEmailAndPassword(user);

        String token = jwtUtil.create(String.valueOf(userLogged.getId()), userLogged.getEmail());
        return new Auth(token);
    }
}
