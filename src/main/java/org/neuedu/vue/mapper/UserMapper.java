package org.neuedu.vue.mapper;

import org.neuedu.vue.model.Role;
import org.neuedu.vue.model.User;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getRoleById(Integer id);

    List<User> getUsers();

    int delUser(User user);

    int putUser(User user);

    List<User> searchUsers(String name);
}
