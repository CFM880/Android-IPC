package com.cfm880.learnipc.datasource.entity;

import com.cfm880.learnipc.datasource.entity.item.News;

import java.util.List;

/**
 * Created by chengfangming on 2017/6/7.
 */

public class NewsList {


    /**
     * code : 0
     * message : ok
     * result : [{"news_title":"四个Webix实例：生成多种类型的JavaScript列表","news_image_url":"http://cdn4.infoqstatic.com/statics_s1_20170606-0324u2/resource/articles/javascript-lists-with-webix/zh/smallimage/logo2.jpeg","news_update_time":"2017年4月28日","news_url":"http://www.infoq.com/cn/articles/javascript-lists-with-webix?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=articles_link&utm_content=link_text"},{"news_title":"Transcrypt：剖析Python转JavaScript编译器","news_image_url":"http://cdn4.infoqstatic.com/statics_s1_20170606-0324u2/resource/articles/transcrypt-python-javascript-compiler/zh/smallimage/GettyImages-499691816-copy.jpeg","news_update_time":"2017年4月25日","news_url":"http://www.infoq.com/cn/articles/transcrypt-python-javascript-compiler?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=articles_link&utm_content=link_text"},{"news_title":"JavaScript 启动性能瓶颈分析与解决方案","news_image_url":"http://www.infoq.com/cn/articles/javascript-start-up-performance?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=articles_link&utm_content=link_image","news_update_time":"2017年4月1日","news_url":"http://www.infoq.com/cn/articles/javascript-start-up-performance?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=articles_link&utm_content=link_text"},{"news_title":"浏览器端 JavaScript 异常监控 For Dummies","news_image_url":"http://www.infoq.com/cn/presentations/javascript-exception-monitoring-for-dummies-in-browser-side?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=presentations_link&utm_content=link_image","news_update_time":"2017年1月18日","news_url":"http://www.infoq.com/cn/presentations/javascript-exception-monitoring-for-dummies-in-browser-side?utm_campaign=rightbar_v2&utm_source=infoq&utm_medium=presentations_link&utm_content=link_text"}]
     */

    private int code;
    private String message;
    private List<News> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<News> getResult() {
        return result;
    }

    public void setResult(List<News> result) {
        this.result = result;
    }

}
