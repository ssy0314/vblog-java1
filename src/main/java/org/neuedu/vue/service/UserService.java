package org.neuedu.vue.service;

import org.neuedu.vue.mapper.UserMapper;
import org.neuedu.vue.model.RespBean;
import org.neuedu.vue.model.Role;
import org.neuedu.vue.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userMapper.loadUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("该用户不存在");
        }
        List<Role> roles =userMapper.getRoleById(user.getId());
        user.setRoles(roles);
        return user;
    }

    public List<User> getUsers() {
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            List<Role> roles =userMapper.getRoleById(user.getId());
            user.setPassword(null);
            user.setRoles(roles);
        }
        return users;
    }

    public RespBean delUser(User user) {
        int i = userMapper.delUser(user);
        if (i!=0){
            return RespBean.ok(200,"删除成功");
        }else{
            return RespBean.error(500,"删除失败");
        }
    }

    public RespBean putUser(User user) {
        int i = userMapper.putUser(user);
        if (i!=0){
            return RespBean.ok(200,"修改成功");
        }else{
            return RespBean.error(500,"修改失败");
        }
    }

    public List<User> searchUsers(String name) {
        List<User> users = userMapper.searchUsers(name);
        for (User user : users) {
            List<Role> roles =userMapper.getRoleById(user.getId());
            user.setPassword(null);
            user.setRoles(roles);
        }
        return users;
    }
}
