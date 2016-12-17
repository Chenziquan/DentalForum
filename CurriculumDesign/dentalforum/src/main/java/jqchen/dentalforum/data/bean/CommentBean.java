package jqchen.dentalforum.data.bean;

import java.util.List;

/**
 * Created by jqchen on 2016/12/17.
 * Use to
 */
public class CommentBean {
    private String uId;
    private String uImage;
    private String uName;
    private String uGroup;
    private String content;
    private String time;
    private List<ReplyBean> replyBeen;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuImage() {
        return uImage;
    }

    public void setuImage(String uImage) {
        this.uImage = uImage;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuGroup() {
        return uGroup;
    }

    public void setuGroup(String uGroup) {
        this.uGroup = uGroup;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ReplyBean> getReplyBeen() {
        return replyBeen;
    }

    public void setReplyBeen(List<ReplyBean> replyBeen) {
        this.replyBeen = replyBeen;
    }

    public class ReplyBean{
        private String uId;
        private String uName;
        private String pId;
        private String pName;
        private String content;
        private String time;

        public String getuId() {
            return uId;
        }

        public void setuId(String uId) {
            this.uId = uId;
        }

        public String getuName() {
            return uName;
        }

        public void setuName(String uName) {
            this.uName = uName;
        }

        public String getpId() {
            return pId;
        }

        public void setpId(String pId) {
            this.pId = pId;
        }

        public String getpName() {
            return pName;
        }

        public void setpName(String pName) {
            this.pName = pName;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
