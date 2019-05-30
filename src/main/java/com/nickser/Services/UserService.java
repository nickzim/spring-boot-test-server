package com.nickser.Services;

import com.nickser.Model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByLogin(String login);

    User create(User user);

    User update(String login, User user);

    void remove(String login);
}
