package org.jooq.example;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created with IntelliJ IDEA.
 * User:ChengLiang
 * Date:2016/9/29
 * Time:15:03
 */
@lombok.Data
public class ViaBookmark {
    @JSONField(ordinal = 1)
    String title;
    @JSONField(ordinal = 2)
    String url;
    @JSONField(ordinal = 3)
    String folder = "";
    @JSONField(ordinal = 4)
    int order = 0;

    public ViaBookmark(String title, String url,int order) {
        this.title=title;
        this.url=url;
        this.order=order;
    }
}
