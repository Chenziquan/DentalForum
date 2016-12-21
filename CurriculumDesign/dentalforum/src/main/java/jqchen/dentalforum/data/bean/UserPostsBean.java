package jqchen.dentalforum.data.bean;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public class UserPostsBean {
    private String postId;
    private String title;
    private String time;
    private String them;

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserPostsBean() {

    }
}
