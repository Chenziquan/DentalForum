package jqchen.dentalforum.data.bean;

import java.util.List;

/**
 * Created by jqchen on 2016/9/9.
 * Use to
 */
public class ADListModel {

    /**
     * success : true
     * status : 1
     * info : [{"ad_id":41,"ad_name":"热点1","ad_pic":"","ad_type":16,"ad_obj_type":3,"ad_obj_id":1,"ad_order":0,"shop_name":null,"type_name":null,"ad_click":0,"link_url":"","obj":null,"ad_count":{"commentNum":5,"likeNum":5,"viewNum":8}},{"ad_id":42,"ad_name":"热点2","ad_pic":"","ad_type":16,"ad_obj_type":3,"ad_obj_id":11,"ad_order":0,"shop_name":null,"type_name":null,"ad_click":0,"link_url":"http://www.baidu.com","obj":null,"ad_count":{"commentNum":0,"likeNum":0,"viewNum":0}},{"ad_id":43,"ad_name":"热点3","ad_pic":"","ad_type":16,"ad_obj_type":3,"ad_obj_id":12,"ad_order":0,"shop_name":null,"type_name":null,"ad_click":0,"link_url":"http://www.baidu.com","obj":null,"ad_count":{"commentNum":0,"likeNum":0,"viewNum":0}}]
     * note : null
     */

    private boolean success;
    private int status;
    private Object note;
    /**
     * ad_id : 41
     * ad_name : 热点1
     * ad_pic :
     * ad_type : 16
     * ad_obj_type : 3
     * ad_obj_id : 1
     * ad_order : 0
     * shop_name : null
     * type_name : null
     * ad_click : 0
     * link_url :
     * obj : null
     * ad_count : {"commentNum":5,"likeNum":5,"viewNum":8}
     */

    private List<InfoBean> info;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        private int ad_id;
        private String ad_name;
        private String ad_pic;
        private int ad_type;
        private int ad_obj_type;
        private int ad_obj_id;
        private int ad_order;
        private Object shop_name;
        private String type_name;
        private int ad_click;
        private String link_url;
        private Object obj;
        /**
         * commentNum : 5
         * likeNum : 5
         * viewNum : 8
         */

        private AdCountBean ad_count;

        public int getAd_id() {
            return ad_id;
        }

        public void setAd_id(int ad_id) {
            this.ad_id = ad_id;
        }

        public String getAd_name() {
            return ad_name;
        }

        public void setAd_name(String ad_name) {
            this.ad_name = ad_name;
        }

        public String getAd_pic() {
            return ad_pic;
        }

        public void setAd_pic(String ad_pic) {
            this.ad_pic = ad_pic;
        }

        public int getAd_type() {
            return ad_type;
        }

        public void setAd_type(int ad_type) {
            this.ad_type = ad_type;
        }

        public int getAd_obj_type() {
            return ad_obj_type;
        }

        public void setAd_obj_type(int ad_obj_type) {
            this.ad_obj_type = ad_obj_type;
        }

        public int getAd_obj_id() {
            return ad_obj_id;
        }

        public void setAd_obj_id(int ad_obj_id) {
            this.ad_obj_id = ad_obj_id;
        }

        public int getAd_order() {
            return ad_order;
        }

        public void setAd_order(int ad_order) {
            this.ad_order = ad_order;
        }

        public Object getShop_name() {
            return shop_name;
        }

        public void setShop_name(Object shop_name) {
            this.shop_name = shop_name;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public int getAd_click() {
            return ad_click;
        }

        public void setAd_click(int ad_click) {
            this.ad_click = ad_click;
        }

        public String getLink_url() {
            return link_url;
        }

        public void setLink_url(String link_url) {
            this.link_url = link_url;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public AdCountBean getAd_count() {
            return ad_count;
        }

        public void setAd_count(AdCountBean ad_count) {
            this.ad_count = ad_count;
        }

        public static class AdCountBean {
            private int commentNum;
            private int likeNum;
            private int viewNum;

            public int getCommentNum() {
                return commentNum;
            }

            public void setCommentNum(int commentNum) {
                this.commentNum = commentNum;
            }

            public int getLikeNum() {
                return likeNum;
            }

            public void setLikeNum(int likeNum) {
                this.likeNum = likeNum;
            }

            public int getViewNum() {
                return viewNum;
            }

            public void setViewNum(int viewNum) {
                this.viewNum = viewNum;
            }
        }
    }
}
