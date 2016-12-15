package jqchen.dentalforum.data.bean;

import java.util.List;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class PostBean {
    private String them;
    private String title;
    private String content;
    private List<String> pictures;
    private String uimage;
    private String uname;
    private String ugroup;

    public String getUgroup() {
        return ugroup;
    }

    public void setUgroup(String ugroup) {
        this.ugroup = ugroup;
    }

    private String time;
    private String viewnum;
    private String commentnum;

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getViewnum() {
        return viewnum;
    }

    public void setViewnum(String viewnum) {
        this.viewnum = viewnum;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
    }

    public PostBean() {

    }
}
