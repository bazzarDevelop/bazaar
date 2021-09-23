package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.model.Student;
import com.qyfou.bazaar.model.User;
import com.qyfou.bazaar.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBase userBase;

    @Autowired
    private StudentBase studentBase;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/addStudent")
    public Object addUser(@RequestBody User user, Student student) {
        userBase.save(user);
        Long userId = userServiceImpl.selectIdByOpenId(user.getOpenId());
        student.setUserId(userId);
        studentBase.save(student);
        return "OK";
    }

    @GetMapping("/baseInformation")
    public Object getUser(Long id) {
        return userBase.findById(id).orElse(null);
    }
}
