package org.neuedu.vue.mapper;


import org.apache.ibatis.annotations.Param;
import org.neuedu.vue.model.Article;
import org.neuedu.vue.model.ArticlePageInfo;

import java.util.ArrayList;
import java.util.List;

public interface ArticleMapper {

    List<Article> getAllArticles(ArticlePageInfo articlePageInfo);

    int putArticle(Article article);

    int delArticle(Article article);

    int delManyArticle(@Param("ids") ArrayList<Integer> list);
}
