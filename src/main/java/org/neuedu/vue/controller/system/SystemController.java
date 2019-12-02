package org.neuedu.vue.controller.system;

import org.neuedu.vue.model.Column;
import org.neuedu.vue.service.ArticleService;
import org.neuedu.vue.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    ColumnService columnService;
    @GetMapping("/getColumn")
    public List<Column> getColumn(){
        return columnService.getColumn();
    }
}
