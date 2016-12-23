package jqchen.dentalforum.data.bean;

import java.util.List;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class PostBean {

    /**
     * id : 1
     * authorId : 1
     * name : 牙科帖子哦
     * moduleName : 灌水区
     * content : 这是帖子内容呀呀呀呀
     * createTime : 2016-12-16 20:30:38.0
     * photoPath : ssssssss
     */

    private int id;
    private int authorId;
    private String uimage;
    private String uname;
    private String name;
    private String ugroup;
    private String moduleName;
    private String content;
    private String createTime;
    private String photoPath;
    private List<String> pictures;
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

    public List<String> getPictures() {
        return pictures;
    }

    public String getUgroup() {
        return ugroup;
    }

    public void setUgroup(String ugroup) {
        this.ugroup = ugroup;
    }

    public String getUname() {

        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
