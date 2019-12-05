package org.neuedu.vue.controller;


import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.neuedu.vue.model.Article;
import org.neuedu.vue.model.ArticlePageInfo;
import org.neuedu.vue.model.RespBean;
import org.neuedu.vue.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/getAllArticles")
    public PageInfo getAllArticles(ArticlePageInfo articlePageInfo){
        return articleService.getAllArticles(articlePageInfo);
    }
    @PutMapping("/putArticle")
    public RespBean putArticle(@RequestBody Article article){
        return articleService.putArticle(article);
    }
    @DeleteMapping("/delArticle")
    public RespBean delArticle(@RequestBody Article article){
        return articleService.putArticle(article);
    }
    @PostMapping("/delManyArticle")
    public RespBean delManyArticle(@Param("ids") ArrayList<Integer>){
        return articleService.delManyArticle(article);
    }


}
