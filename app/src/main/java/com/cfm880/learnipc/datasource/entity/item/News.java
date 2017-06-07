package com.cfm880.learnipc.datasource.entity.item;

/**
 * Created by chengfangming on 2017/6/7.
 */

public class News {
    /**
     * news_title : 四个Webix实例：生成多种类型的JavaScript列表
     * news_image_url : http://cdn4.infoqstatic.com/statics_s1_20170606-0324u2/resource/articles/javascript-lists-with-webix/zh/smallimage/logo2.jpeg
     * news_update_time : 2017年4月28日
     * news_url : http://www.infoq.com/cn/articles/javascript-lists-with-webix?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=articles_link&utm_content=link_text
     */

    private String news_title;
    private String news_image_url;
    private String news_update_time;
    private String news_url;

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_image_url() {
        return news_image_url;
    }

    public void setNews_image_url(String news_image_url) {
        this.news_image_url = news_image_url;
    }

    public String getNews_update_time() {
        return news_update_time;
    }

    public void setNews_update_time(String news_update_time) {
        this.news_update_time = news_update_time;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }
}
