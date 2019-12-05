package org.neuedu.vue.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.neuedu.vue.mapper.ArticleMapper;
import org.neuedu.vue.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public PageInfo getAllArticles(ArticlePageInfo articlePageInfo) {
        if(articlePageInfo.getStatus()!=-1){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            articlePageInfo.setUid(user.getId());
        }
        PageHelper.startPage(articlePageInfo.getPageNum(),articlePageInfo.getPageSize());
        List<Article> articles = articleMapper.getAllArticles(articlePageInfo);
        PageInfo pageInfo = new PageInfo(articles);
        return pageInfo;
    }
}
