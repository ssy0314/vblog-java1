package org.neuedu.vue.mapper;

import org.apache.ibatis.annotations.Param;
import org.neuedu.vue.model.Article;
import org.neuedu.vue.model.Column;

import java.util.ArrayList;
import java.util.List;

public interface ColumnMapper {
    List<Column> getColumn();

    int addColumn(Column column);

    int delColumn(Column column);

    int putColumn(Column column);

    int delManyColumn(@Param("ids") ArrayList<Integer> list);
}
