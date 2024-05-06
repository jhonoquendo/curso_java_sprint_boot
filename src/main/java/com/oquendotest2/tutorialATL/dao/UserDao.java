package com.oquendotest2.tutorialATL.dao;

import com.oquendotest2.tutorialATL.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void deleteUser(Long id);

    void createUser(User user);
    User verifyEmailAndPassword(User user);
}
