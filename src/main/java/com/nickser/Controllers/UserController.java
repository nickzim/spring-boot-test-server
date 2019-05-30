package com.nickser.Controllers;

import com.nickser.Model.User;
import com.nickser.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User login(@RequestBody String login){
        return userService.getByLogin(login);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User updateUser(@PathVariable String login, @RequestBody User user){
        return userService.update(login, user);
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable String login){
        userService.remove(login);
    }
}
