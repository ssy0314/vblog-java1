package org.neuedu.vue.model;

public class RespBean {
    private Integer statue;
    private String msg;
    private Object obj;

    public static RespBean ok(Integer status,String msg,Object obj){
        return new RespBean(status,msg,obj);
    }
    public static RespBean ok(Integer status,String msg){
        return new RespBean(status,msg,null);
    }
    public static RespBean error(Integer status,String msg,Object obj){
        return new RespBean(status,msg,obj);
    }
    public static RespBean error(Integer status,String msg){
        return new RespBean(status,msg,null);
    }

    private RespBean(Integer statue, String msg, Object obj) {
        this.statue = statue;
        this.msg = msg;
        this.obj = obj;
    }

    private RespBean() {
    }

    public Integer getStatue() {
        return statue;
    }

    public void setStatue(Integer statue) {
        this.statue = statue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
