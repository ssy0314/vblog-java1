package org.neuedu.vue.controller;


import org.neuedu.vue.model.Column;
import org.neuedu.vue.model.RespBean;
import org.neuedu.vue.model.User;
import org.neuedu.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userDom")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @DeleteMapping("/delUser")
    public RespBean delUser(@RequestBody User user){
        return userService.delUser(user);
    }
    @PutMapping("/putUser")
    public RespBean putUser(@RequestBody User user){
        return userService.putUser(user);
    }

    @GetMapping("/searchUsers")
    public List<User> searchUsers(@RequestParam(value = "name",defaultValue = "") String name){
        return userService.searchUsers(name);
    }




}
