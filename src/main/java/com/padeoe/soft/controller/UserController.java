package com.padeoe.soft.controller;

import com.padeoe.soft.dao.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.padeoe.soft.controller
 *
 * @author troy_diao on 2016/11/7
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{id}")
    public User view(@PathVariable("id") Long id){
        User user = new User();
        user.setId(id);
        user.setAccount("padeoe");
        return user;
    }
}



