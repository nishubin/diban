package com.nishubin.work.model;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
public class DedeAddonarticle implements Serializable {
    private Integer aid;

    /**
     * 栏目ID
     */
    private Integer typeid;

    /**
     * 跳转url
     */
    private String redirecturl;

    /**
     * 栏目内容
     */
    private String body;

    private static final long serialVersionUID = 1L;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getRedirecturl() {
        return redirecturl;
    }

    public void setRedirecturl(String redirecturl) {
        this.redirecturl = redirecturl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}