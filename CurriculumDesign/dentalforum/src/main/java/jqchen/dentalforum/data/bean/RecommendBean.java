package jqchen.dentalforum.data.bean;

/**
 * Created by jqchen on 2016/12/23.
 * Use to
 */
public class RecommendBean {
    /**
     * id : 1
     * name : 关于牙科
     * authorName : 大师
     * createDate : 2016-12-11 22:29:04.0
     * intro : 这是简介
     * content : 正式文本啊啊啊啊啊啊
     */

    private int id;
    private String name;
    private String authorName;
    private String createDate;
    private String intro;
    private String content;
    private String picture;
    private String viewnum;
    private String commentnum;

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
    }

    public String getViewnum() {
        return viewnum;
    }

    public void setViewnum(String viewnum) {
        this.viewnum = viewnum;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
