package jqchen.dentalforum.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jqchen on 2016/12/23.
 * Use to
 */
public class PostCommentBean implements Parcelable {
    /**
     * id : 1
     * postId : 1
     * postUserId : 1
     * userId : 1
     * userNickname : 骚猪
     * userHeadpic :
     * content : 这是第一条一级评论
     * createDate : 2016-12-17 19:44:37.0
     * toUserId : 0
     * toId : 0
     */

    private CommentBean comment;
    /**
     * id : 4
     * postId : 1
     * postUserId : 1
     * userId : 2
     * userNickname : 骚猪2
     * userHeadpic :
     * content : 这是第一条2级评论
     * createDate : 2016-12-18 15:49:35.0
     * toUserId : 1
     * toUserNickname : 骚猪
     * toUserpic :
     * toId : 1
     */

    private List<SecCommentBean> secComment;

    public CommentBean getComment() {
        return comment;
    }

    public void setComment(CommentBean comment) {
        this.comment = comment;
    }

    public List<SecCommentBean> getSecComment() {
        return secComment;
    }

    public void setSecComment(List<SecCommentBean> secComment) {
        this.secComment = secComment;
    }

    public static class CommentBean implements Parcelable {
        private int id;
        private int postId;
        private int postUserId;
        private int userId;
        private String ugroup;
        private String uimage;
        private String userNickname;
        private String userHeadpic;
        private String content;
        private String createDate;
        private int toUserId;
        private int toId;

        public String getUgroup() {
            return ugroup;
        }

        public void setUgroup(String ugroup) {
            this.ugroup = ugroup;
        }

        public String getUimage() {
            return uimage;
        }

        public void setUimage(String uimage) {
            this.uimage = uimage;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPostId() {
            return postId;
        }

        public void setPostId(int postId) {
            this.postId = postId;
        }

        public int getPostUserId() {
            return postUserId;
        }

        public void setPostUserId(int postUserId) {
            this.postUserId = postUserId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public String getUserHeadpic() {
            return userHeadpic;
        }

        public void setUserHeadpic(String userHeadpic) {
            this.userHeadpic = userHeadpic;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getToUserId() {
            return toUserId;
        }

        public void setToUserId(int toUserId) {
            this.toUserId = toUserId;
        }

        public int getToId() {
            return toId;
        }

        public void setToId(int toId) {
            this.toId = toId;
        }

        public CommentBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeInt(this.postId);
            dest.writeInt(this.postUserId);
            dest.writeInt(this.userId);
            dest.writeString(this.ugroup);
            dest.writeString(this.uimage);
            dest.writeString(this.userNickname);
            dest.writeString(this.userHeadpic);
            dest.writeString(this.content);
            dest.writeString(this.createDate);
            dest.writeInt(this.toUserId);
            dest.writeInt(this.toId);
        }

        protected CommentBean(Parcel in) {
            this.id = in.readInt();
            this.postId = in.readInt();
            this.postUserId = in.readInt();
            this.userId = in.readInt();
            this.ugroup = in.readString();
            this.uimage = in.readString();
            this.userNickname = in.readString();
            this.userHeadpic = in.readString();
            this.content = in.readString();
            this.createDate = in.readString();
            this.toUserId = in.readInt();
            this.toId = in.readInt();
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

    public static class SecCommentBean implements Parcelable {
        private int id;
        private int postId;
        private int postUserId;
        private int userId;
        private String userNickname;
        private String userHeadpic;
        private String content;
        private String createDate;
        private int toUserId;
        private String toUserNickname;
        private String toUserpic;
        private int toId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPostId() {
            return postId;
        }

        public void setPostId(int postId) {
            this.postId = postId;
        }

        public int getPostUserId() {
            return postUserId;
        }

        public void setPostUserId(int postUserId) {
            this.postUserId = postUserId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public String getUserHeadpic() {
            return userHeadpic;
        }

        public void setUserHeadpic(String userHeadpic) {
            this.userHeadpic = userHeadpic;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getToUserId() {
            return toUserId;
        }

        public void setToUserId(int toUserId) {
            this.toUserId = toUserId;
        }

        public String getToUserNickname() {
            return toUserNickname;
        }

        public void setToUserNickname(String toUserNickname) {
            this.toUserNickname = toUserNickname;
        }

        public String getToUserpic() {
            return toUserpic;
        }

        public void setToUserpic(String toUserpic) {
            this.toUserpic = toUserpic;
        }

        public int getToId() {
            return toId;
        }

        public void setToId(int toId) {
            this.toId = toId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeInt(this.postId);
            dest.writeInt(this.postUserId);
            dest.writeInt(this.userId);
            dest.writeString(this.userNickname);
            dest.writeString(this.userHeadpic);
            dest.writeString(this.content);
            dest.writeString(this.createDate);
            dest.writeInt(this.toUserId);
            dest.writeString(this.toUserNickname);
            dest.writeString(this.toUserpic);
            dest.writeInt(this.toId);
        }

        public SecCommentBean() {
        }

        protected SecCommentBean(Parcel in) {
            this.id = in.readInt();
            this.postId = in.readInt();
            this.postUserId = in.readInt();
            this.userId = in.readInt();
            this.userNickname = in.readString();
            this.userHeadpic = in.readString();
            this.content = in.readString();
            this.createDate = in.readString();
            this.toUserId = in.readInt();
            this.toUserNickname = in.readString();
            this.toUserpic = in.readString();
            this.toId = in.readInt();
        }

        public static final Creator<SecCommentBean> CREATOR = new Creator<SecCommentBean>() {
            @Override
            public SecCommentBean createFromParcel(Parcel source) {
                return new SecCommentBean(source);
            }

            @Override
            public SecCommentBean[] newArray(int size) {
                return new SecCommentBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.comment, flags);
        dest.writeList(this.secComment);
    }

    public PostCommentBean() {
    }

    protected PostCommentBean(Parcel in) {
        this.comment = in.readParcelable(CommentBean.class.getClassLoader());
        this.secComment = new ArrayList<SecCommentBean>();
        in.readList(this.secComment, SecCommentBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<PostCommentBean> CREATOR = new Parcelable.Creator<PostCommentBean>() {
        @Override
        public PostCommentBean createFromParcel(Parcel source) {
            return new PostCommentBean(source);
        }

        @Override
        public PostCommentBean[] newArray(int size) {
            return new PostCommentBean[size];
        }
    };
}
