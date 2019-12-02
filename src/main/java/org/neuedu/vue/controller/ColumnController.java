package org.neuedu.vue.controller;

import org.neuedu.vue.model.Article;
import org.neuedu.vue.model.Column;
import org.neuedu.vue.model.RespBean;
import org.neuedu.vue.service.ArticleService;
import org.neuedu.vue.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/column")
public class ColumnController {
        @Autowired
        ColumnService columnService;
        @PostMapping("/addColumn")
        public RespBean addColumn(@RequestBody Column column){
            return columnService.addColumn(column);
        }
    @DeleteMapping("/delColumn")
    public RespBean delColumn(@RequestBody Column column){
        return columnService.delColumn(column);
    }
    @PutMapping("/putColumn")
    public RespBean putColumn(@RequestBody Column column){
        return columnService.putColumn(column);
    }
    @PostMapping("/delManyColumn")
    public RespBean delManyColumn(@RequestParam("ids") ArrayList<Integer> list){
        for (Integer integer : list) {
            System.out.println(integer);
        }
        return columnService.delManyColumn(list);
    }
    }


