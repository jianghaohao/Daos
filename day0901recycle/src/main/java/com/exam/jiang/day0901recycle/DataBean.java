package com.exam.jiang.day0901recycle;

/**
 * Created by zhanghaihua on 2016/9/1.
 */
public class DataBean {
    public String incon;
    public String content;
    public DataBean(String incon, String content) {
        super();
        this.incon = incon;
        this.content = content;
    }
    public DataBean(String content) {
        super();
        this.content = content;
    }
}
