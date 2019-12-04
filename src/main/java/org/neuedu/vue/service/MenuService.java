package org.neuedu.vue.service;

import org.neuedu.vue.mapper.MenuMapper;
import org.neuedu.vue.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }
}
