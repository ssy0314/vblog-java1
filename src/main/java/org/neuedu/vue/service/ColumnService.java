package org.neuedu.vue.service;

import org.neuedu.vue.mapper.ArticleMapper;
import org.neuedu.vue.mapper.ColumnMapper;
import org.neuedu.vue.model.Article;
import org.neuedu.vue.model.Column;
import org.neuedu.vue.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColumnService {
    @Autowired
    ColumnMapper columnMapper;
    public List<Column> getColumn() {
        return columnMapper.getColumn();
    }

    public RespBean addColumn(Column column) {
        int i = columnMapper.addColumn(column);
        if (i!=0){
            return RespBean.ok(200,"插入成功");
        }else{
            return RespBean.error(500,"插入失败");
        }
    }

    public RespBean delColumn(Column column) {

            int i = columnMapper.delColumn(column);
            if (i!=0){
                return RespBean.ok(200,"删除成功");
            }else{
                return RespBean.error(500,"删除失败");
            }
    }

    public RespBean putColumn(Column column) {
        int i = columnMapper.putColumn(column);
        if (i!=0){
            return RespBean.ok(200,"修改成功");
        }else{
            return RespBean.error(500,"修改失败");
        }
    }

    public RespBean delManyColumn(ArrayList<Integer> list) {

        int i = columnMapper.delManyColumn(list);
        if (i!=0){
            return RespBean.ok(200,"批量删除成功");
        }else{
            return RespBean.error(500,"批量删除失败");
        }
    }

    public List<Column> getColumnDate() {
        return columnMapper.getColumnDate();
    }
}
