package org.neuedu.vue.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.neuedu.vue.mapper.ArticleMapper;
import org.neuedu.vue.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public RespBean putArticle(Article article) {
        int i = 0;
        if(article.getStatus()==3){
             i = articleMapper.putArticle(article);
            if (i!=0){
                return RespBean.ok(200,"删除成功");
            }else{
                return RespBean.error(500,"删除失败");
            }
        }else if (article.getStatus()==1){
            i = articleMapper.putArticle(article);
            if (i!=0){
            return RespBean.ok(200,"还原成功");
        }else{
            return RespBean.error(500,"还原失败");
        }}
        else{
            article.setStatus(null);
            i = articleMapper.putArticle(article);
            if (i!=0){
                return RespBean.ok(200,"修改成功");
            }else{
                return RespBean.error(500,"修改失败");
            }
        }

    }

    public RespBean delArticle(Article article) {
        int i = articleMapper.delArticle(article);
        if (i!=0){
            return RespBean.ok(200,"删除成功");
        }else{
            return RespBean.error(500,"删除失败");
        }
    }

    public RespBean delManyArticle(ArrayList<Integer> list) {
        int i = articleMapper.delManyArticle(list);
        if (i!=0){
            return RespBean.ok(200,"批量删除成功");
        }else{
            return RespBean.error(500,"批量删除失败");
        }
    }
    public RespBean updateManyArticle(ArrayList<Integer> list) {
        int i = articleMapper.updateManyArticle(list);
        if (i!=0){
            return RespBean.ok(200,"批量删除成功");
        }else{
            return RespBean.error(500,"批量删除失败");
        }
    }

    public RespBean addArticle(Article article) {
        int i = articleMapper.addArticle(article);
        if(article.getStatus()==1){ if (i!=0){
            return RespBean.ok(200,"发布文章成功");
        }else{
            return RespBean.error(500,"发布文章失败");
        }}else{ if (i!=0){
            return RespBean.ok(200,"文章已保存至草稿箱");
        }else{
            return RespBean.error(500,"保存文章失败");
        }}

    }

    public Article searchArticleById(Article article) {
        return articleMapper.searchArticleById(article);
    }

    public Article getArticleDetail(Article article) {
        int i = articleMapper.updateViews(article);
        return articleMapper.getArticleDetail(article);
    }
}
