package org.neuedu.vue.controller;

import org.neuedu.vue.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/user/hello")
    public String helloUser(){
        return "hello user";
    }
    @GetMapping("/admin/hello")
    public String helloAdmin(){
        return "hello admin";
    }
    @GetMapping("/dba/hello")
    public String helloDba(){
        return "hello dba";
    }
    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error(500,"用户未登录请先登录");
    }
}
