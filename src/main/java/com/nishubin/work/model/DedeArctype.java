package com.nishubin.work.model;

import java.io.Serializable;

/**
 * @author 
 */
public class DedeArctype implements Serializable {
    private Integer id;

    /**
     * 父栏位ID默认0
     */
    private Integer topid;

    /**
     * 排序字段越小越靠前
     */
    private Short sortrank;

    /**
     * 栏位名称
     */
    private String typename;

    /**
     * 栏位目录
     */
    private String typedir;

    /**
     * 是否完整 0不完整1完整
     */
    private String ispart;

    /**
     * SEO标题
     */
    private String seotitle;

    /**
     * 是否隐藏0不隐藏1隐藏
     */
    private String ishidden;

    /**
     * 栏目内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopid() {
        return topid;
    }

    public void setTopid(Integer topid) {
        this.topid = topid;
    }

    public Short getSortrank() {
        return sortrank;
    }

    public void setSortrank(Short sortrank) {
        this.sortrank = sortrank;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypedir() {
        return typedir;
    }

    public void setTypedir(String typedir) {
        this.typedir = typedir;
    }

    public String getIspart() {
        return ispart;
    }

    public void setIspart(String ispart) {
        this.ispart = ispart;
    }

    public String getSeotitle() {
        return seotitle;
    }

    public void setSeotitle(String seotitle) {
        this.seotitle = seotitle;
    }

    public String getIshidden() {
        return ishidden;
    }

    public void setIshidden(String ishidden) {
        this.ishidden = ishidden;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}