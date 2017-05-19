package com.nishubin.work.model;

import java.io.Serializable;

/**
 * @author 
 */
public class DedeArchives implements Serializable {
    private Long id;

    /**
     * 文章栏目ID
     */
    private Integer typeid;

    /**
     * 文章排序字段
     */
    private Long sortrank;

    /**
     * 文章类型（'s'：'滚动'，'h'：'头条'，'f'：'幻灯'，'c'：'推荐'，'p'：'图片'，'j'：'跳转'，'a'：'特荐'，'b'：'加粗'）
     */
    private String flag;

    /**
     * 点击次数
     */
    private Long click;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String writer;

    /**
     * 来源
     */
    private String source;

    /**
     * 略缩图
     */
    private String litpic;

    /**
     * SEO字段
     */
    private String keywords;

    /**
     * 文章内容
     */
    private String description;

    /**
     * 文件
     */
    private String filename;

    /**
     * 权重
     */
    private Integer weight;
    
    /**
     * 访问路径
     */
    private String url;
    /**
     * 内容详情
     */
    private String body;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Long getSortrank() {
        return sortrank;
    }

    public void setSortrank(Long sortrank) {
        this.sortrank = sortrank;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLitpic() {
        return litpic;
    }

    public void setLitpic(String litpic) {
        this.litpic = litpic;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
    
}