package com.demo.controller;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getuser/{phone}")
    public User getUser(@PathVariable("phone")String phone) {
        User user = userMapper.findUserByPhone(phone);
        return user;
    }
    @GetMapping("getAllUser")
    public List<User> getAllUser(){
        List<User> users = userMapper.findAllUser();
        return users;
    }
    @PostMapping("insert")
    @Transactional
    public void insertUser(@RequestBody User user){
        userMapper.insert(user.getName(),user.getPassword(),user.getPhone());
    }
}
