package com.nickser.Services;

import com.nickser.Model.User;
import com.nickser.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(String login, User user) {
        userRepository.delete(userRepository.findByLogin(login));
        return userRepository.save(user);
    }

    @Override
    public void remove(String login) {
        userRepository.delete(userRepository.findByLogin(login));
    }
}
