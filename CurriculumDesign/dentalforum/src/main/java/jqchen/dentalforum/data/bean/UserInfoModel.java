package jqchen.dentalforum.data.bean;

/**
 * Created by jqchen on 2016/11/30.
 * Use to
 */
public class UserInfoModel {
    /**
     * success : true
     * status : 1
     * info : {"u_id":14,"u_name":"陈军权","u_pwd":null,"u_tel":"15638897507","u_sex":1,"u_pay_pwd":null,"u_numerical":0,"u_scode":null,"u_scode_last_time":null,"u_status":1,"u_img":"20161126153846331.png","u_admin":0,"qq_code":"F8626DEE8E33193E582E25F2DD87F061","qq_img":"201611251014017591100.png","qq_nickname":"愈爱愈明白","wx_code":"oY0XvwunhEQKhrZFizinkgVTPow4","wx_img":"2016112510312687210.png","wx_nickname":"Dijkstra","wb_code":"5365019373","wb_img":"201611250910276871.jpg","wb_nickname":"陈军权无所谓","channelId":null}
     * note : null
     */

    private boolean success;
    private int status;
    /**
     * u_id : 14
     * u_name : 陈军权
     * u_pwd : null
     * u_tel : 15638897507
     * u_sex : 1
     * u_pay_pwd : null
     * u_numerical : 0
     * u_scode : null
     * u_scode_last_time : null
     * u_status : 1
     * u_img : 20161126153846331.png
     * u_admin : 0
     * qq_code : F8626DEE8E33193E582E25F2DD87F061
     * qq_img : 201611251014017591100.png
     * qq_nickname : 愈爱愈明白
     * wx_code : oY0XvwunhEQKhrZFizinkgVTPow4
     * wx_img : 2016112510312687210.png
     * wx_nickname : Dijkstra
     * wb_code : 5365019373
     * wb_img : 201611250910276871.jpg
     * wb_nickname : 陈军权无所谓
     * channelId : null
     */

    private InfoBean info;
    private Object note;

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

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public Object getNote() {
        return note;
    }

    public void setNote(Object note) {
        this.note = note;
    }

    public static class InfoBean {
        private int u_id;
        private String u_name;
        private Object u_pwd;
        private String u_tel;
        private int u_sex;
        private Object u_pay_pwd;
        private int u_numerical;
        private Object u_scode;
        private Object u_scode_last_time;
        private int u_status;
        private String u_img;
        private int u_admin;
        private String qq_code;
        private String qq_img;
        private String qq_nickname;
        private String wx_code;
        private String wx_img;
        private String wx_nickname;
        private String wb_code;
        private String wb_img;
        private String wb_nickname;
        private Object channelId;

        public int getU_id() {
            return u_id;
        }

        public void setU_id(int u_id) {
            this.u_id = u_id;
        }

        public String getU_name() {
            return u_name;
        }

        public void setU_name(String u_name) {
            this.u_name = u_name;
        }

        public Object getU_pwd() {
            return u_pwd;
        }

        public void setU_pwd(Object u_pwd) {
            this.u_pwd = u_pwd;
        }

        public String getU_tel() {
            return u_tel;
        }

        public void setU_tel(String u_tel) {
            this.u_tel = u_tel;
        }

        public int getU_sex() {
            return u_sex;
        }

        public void setU_sex(int u_sex) {
            this.u_sex = u_sex;
        }

        public Object getU_pay_pwd() {
            return u_pay_pwd;
        }

        public void setU_pay_pwd(Object u_pay_pwd) {
            this.u_pay_pwd = u_pay_pwd;
        }

        public int getU_numerical() {
            return u_numerical;
        }

        public void setU_numerical(int u_numerical) {
            this.u_numerical = u_numerical;
        }

        public Object getU_scode() {
            return u_scode;
        }

        public void setU_scode(Object u_scode) {
            this.u_scode = u_scode;
        }

        public Object getU_scode_last_time() {
            return u_scode_last_time;
        }

        public void setU_scode_last_time(Object u_scode_last_time) {
            this.u_scode_last_time = u_scode_last_time;
        }

        public int getU_status() {
            return u_status;
        }

        public void setU_status(int u_status) {
            this.u_status = u_status;
        }

        public String getU_img() {
            return u_img;
        }

        public void setU_img(String u_img) {
            this.u_img = u_img;
        }

        public int getU_admin() {
            return u_admin;
        }

        public void setU_admin(int u_admin) {
            this.u_admin = u_admin;
        }

        public String getQq_code() {
            return qq_code;
        }

        public void setQq_code(String qq_code) {
            this.qq_code = qq_code;
        }

        public String getQq_img() {
            return qq_img;
        }

        public void setQq_img(String qq_img) {
            this.qq_img = qq_img;
        }

        public String getQq_nickname() {
            return qq_nickname;
        }

        public void setQq_nickname(String qq_nickname) {
            this.qq_nickname = qq_nickname;
        }

        public String getWx_code() {
            return wx_code;
        }

        public void setWx_code(String wx_code) {
            this.wx_code = wx_code;
        }

        public String getWx_img() {
            return wx_img;
        }

        public void setWx_img(String wx_img) {
            this.wx_img = wx_img;
        }

        public String getWx_nickname() {
            return wx_nickname;
        }

        public void setWx_nickname(String wx_nickname) {
            this.wx_nickname = wx_nickname;
        }

        public String getWb_code() {
            return wb_code;
        }

        public void setWb_code(String wb_code) {
            this.wb_code = wb_code;
        }

        public String getWb_img() {
            return wb_img;
        }

        public void setWb_img(String wb_img) {
            this.wb_img = wb_img;
        }

        public String getWb_nickname() {
            return wb_nickname;
        }

        public void setWb_nickname(String wb_nickname) {
            this.wb_nickname = wb_nickname;
        }

        public Object getChannelId() {
            return channelId;
        }

        public void setChannelId(Object channelId) {
            this.channelId = channelId;
        }
    }
}
