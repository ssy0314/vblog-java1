package org.neuedu.vue.mapper;


import org.neuedu.vue.model.Article;
import org.neuedu.vue.model.ArticlePageInfo;

import java.util.List;

public interface ArticleMapper {

    List<Article> getAllArticles(ArticlePageInfo articlePageInfo);
}
