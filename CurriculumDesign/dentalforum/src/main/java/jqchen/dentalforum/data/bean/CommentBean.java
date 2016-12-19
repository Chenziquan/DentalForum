package jqchen.dentalforum.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by jqchen on 2016/12/17.
 * Use to
 */
public class CommentBean implements Parcelable {
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

    public static class ReplyBean implements Parcelable {
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


        public ReplyBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.uId);
            dest.writeString(this.uName);
            dest.writeString(this.pId);
            dest.writeString(this.pName);
            dest.writeString(this.content);
            dest.writeString(this.time);
        }

        protected ReplyBean(Parcel in) {
            this.uId = in.readString();
            this.uName = in.readString();
            this.pId = in.readString();
            this.pName = in.readString();
            this.content = in.readString();
            this.time = in.readString();
        }

        public static final Creator<ReplyBean> CREATOR = new Creator<ReplyBean>() {
            @Override
            public ReplyBean createFromParcel(Parcel source) {
                return new ReplyBean(source);
            }

            @Override
            public ReplyBean[] newArray(int size) {
                return new ReplyBean[size];
            }
        };
    }

    public CommentBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uId);
        dest.writeString(this.uImage);
        dest.writeString(this.uName);
        dest.writeString(this.uGroup);
        dest.writeString(this.content);
        dest.writeString(this.time);
        dest.writeTypedList(this.replyBeen);
    }

    protected CommentBean(Parcel in) {
        this.uId = in.readString();
        this.uImage = in.readString();
        this.uName = in.readString();
        this.uGroup = in.readString();
        this.content = in.readString();
        this.time = in.readString();
        this.replyBeen = in.createTypedArrayList(ReplyBean.CREATOR);
    }

    public static final Creator<CommentBean> CREATOR = new Creator<CommentBean>() {
        @Override
        public CommentBean createFromParcel(Parcel source) {
            return new CommentBean(source);
        }

        @Override
        public CommentBean[] newArray(int size) {
            return new CommentBean[size];
        }
    };
}
