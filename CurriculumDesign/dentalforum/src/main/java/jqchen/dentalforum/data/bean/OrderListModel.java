package jqchen.dentalforum.data.bean;

import java.util.List;

/**
 * Created by jqchen on 2016/8/22.
 * Use to
 */
public class OrderListModel {

    /**
     * success : true
     * status : 1
     * info : [{"u_id":1,"orders_id":"147617227320734","orders_price":659,"shops_num":1,"address_id":17,"one_shop_info":null,"coupon_use":0,"numerical_use":0,"pay_way":0,"trans_code":"","trans_com":"","trans_fee":0.1,"trans_time":"","add_time":"2016-10-11 15:51:13.0","order_status":6,"shopBack":{"back_id":null,"orders_id":null,"back_info":"不想要了","back_com":"","back_code":"132456789","back_status":1,"shop_id":2,"shop_pic":"","back_type":2,"back_note":"不要了"},"shops":null,"address":null,"order_notes":null,"last_remind_time":null,"last_check_time":null,"last_comment_time":null,"package_num":0,"shopsList":[{"order_id":"147617227320734","shop_id":2,"shop_num":1,"shop_buy_price":659,"shop_price":659,"shop_parameter":221,"send_status":0,"shop_name":"NB 574","shop_pic":"testshops3.jpg","shop_type":null,"type_parent":null,"type_grandparents":null,"shop_car_id":null,"parameter_name":"绿色","size_name":"42","shopBack":{"back_id":0,"orders_id":"","back_info":"","back_com":"","back_code":"","back_status":0,"shop_id":null,"shop_pic":"","back_type":0,"back_note":null},"back_info":"","comment_star":0,"check":false}]}]
     * note : null
     */

    private boolean success;
    private int status;
    private Object note;
    /**
     * u_id : 1
     * orders_id : 147617227320734
     * orders_price : 659.0
     * shops_num : 1
     * address_id : 17
     * one_shop_info : null
     * coupon_use : 0
     * numerical_use : 0
     * pay_way : 0
     * trans_code :
     * trans_com :
     * trans_fee : 0.1
     * trans_time :
     * add_time : 2016-10-11 15:51:13.0
     * order_status : 6
     * shopBack : {"back_id":null,"orders_id":null,"back_info":"不想要了","back_com":"","back_code":"132456789","back_status":1,"shop_id":2,"shop_pic":"","back_type":2,"back_note":"不要了"}
     * shops : null
     * address : null
     * order_notes : null
     * last_remind_time : null
     * last_check_time : null
     * last_comment_time : null
     * package_num : 0
     * shopsList : [{"order_id":"147617227320734","shop_id":2,"shop_num":1,"shop_buy_price":659,"shop_price":659,"shop_parameter":221,"send_status":0,"shop_name":"NB 574","shop_pic":"testshops3.jpg","shop_type":null,"type_parent":null,"type_grandparents":null,"shop_car_id":null,"parameter_name":"绿色","size_name":"42","shopBack":{"back_id":0,"orders_id":"","back_info":"","back_com":"","back_code":"","back_status":0,"shop_id":null,"shop_pic":"","back_type":0,"back_note":null},"back_info":"","comment_star":0,"check":false}]
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
        private int u_id;
        private String orders_id;
        private double orders_price;
        private int shops_num;
        private int address_id;
        private Object one_shop_info;
        private int coupon_use;
        private int numerical_use;
        private int pay_way;
        private String trans_code;
        private String trans_com;
        private double trans_fee;
        private String trans_time;
        private String add_time;
        private int order_status;
        /**
         * back_id : null
         * orders_id : null
         * back_info : 不想要了
         * back_com :
         * back_code : 132456789
         * back_status : 1
         * shop_id : 2
         * shop_pic :
         * back_type : 2
         * back_note : 不要了
         */

        private ShopBackBean shopBack;
        private Object shops;
        private Object address;
        private Object order_notes;
        private String last_remind_time;
        private String last_check_time;
        private String last_comment_time;

        public int getRemind_send() {
            return remind_send;
        }

        public void setRemind_send(int remind_send) {
            this.remind_send = remind_send;
        }

        private int remind_send;
        private int package_num;
        /**
         * order_id : 147617227320734
         * shop_id : 2
         * shop_num : 1
         * shop_buy_price : 659.0
         * shop_price : 659.0
         * shop_parameter : 221
         * send_status : 0
         * shop_name : NB 574
         * shop_pic : testshops3.jpg
         * shop_type : null
         * type_parent : null
         * type_grandparents : null
         * shop_car_id : null
         * parameter_name : 绿色
         * size_name : 42
         * shopBack : {"back_id":0,"orders_id":"","back_info":"","back_com":"","back_code":"","back_status":0,"shop_id":null,"shop_pic":"","back_type":0,"back_note":null}
         * back_info :
         * comment_star : 0
         * check : false
         */

        private List<ShopsListBean> shopsList;

        public int getU_id() {
            return u_id;
        }

        public void setU_id(int u_id) {
            this.u_id = u_id;
        }

        public String getOrders_id() {
            return orders_id;
        }

        public void setOrders_id(String orders_id) {
            this.orders_id = orders_id;
        }

        public double getOrders_price() {
            return orders_price;
        }

        public void setOrders_price(double orders_price) {
            this.orders_price = orders_price;
        }

        public int getShops_num() {
            return shops_num;
        }

        public void setShops_num(int shops_num) {
            this.shops_num = shops_num;
        }

        public int getAddress_id() {
            return address_id;
        }

        public void setAddress_id(int address_id) {
            this.address_id = address_id;
        }

        public Object getOne_shop_info() {
            return one_shop_info;
        }

        public void setOne_shop_info(Object one_shop_info) {
            this.one_shop_info = one_shop_info;
        }

        public int getCoupon_use() {
            return coupon_use;
        }

        public void setCoupon_use(int coupon_use) {
            this.coupon_use = coupon_use;
        }

        public int getNumerical_use() {
            return numerical_use;
        }

        public void setNumerical_use(int numerical_use) {
            this.numerical_use = numerical_use;
        }

        public int getPay_way() {
            return pay_way;
        }

        public void setPay_way(int pay_way) {
            this.pay_way = pay_way;
        }

        public String getTrans_code() {
            return trans_code;
        }

        public void setTrans_code(String trans_code) {
            this.trans_code = trans_code;
        }

        public String getTrans_com() {
            return trans_com;
        }

        public void setTrans_com(String trans_com) {
            this.trans_com = trans_com;
        }

        public double getTrans_fee() {
            return trans_fee;
        }

        public void setTrans_fee(double trans_fee) {
            this.trans_fee = trans_fee;
        }

        public String getTrans_time() {
            return trans_time;
        }

        public void setTrans_time(String trans_time) {
            this.trans_time = trans_time;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public ShopBackBean getShopBack() {
            return shopBack;
        }

        public void setShopBack(ShopBackBean shopBack) {
            this.shopBack = shopBack;
        }

        public Object getShops() {
            return shops;
        }

        public void setShops(Object shops) {
            this.shops = shops;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getOrder_notes() {
            return order_notes;
        }

        public void setOrder_notes(Object order_notes) {
            this.order_notes = order_notes;
        }

        public String getLast_remind_time() {
            return last_remind_time;
        }

        public void setLast_remind_time(String last_remind_time) {
            this.last_remind_time = last_remind_time;
        }

        public String getLast_check_time() {
            return last_check_time;
        }

        public void setLast_check_time(String last_check_time) {
            this.last_check_time = last_check_time;
        }

        public String getLast_comment_time() {
            return last_comment_time;
        }

        public void setLast_comment_time(String last_comment_time) {
            this.last_comment_time = last_comment_time;
        }

        public int getPackage_num() {
            return package_num;
        }

        public void setPackage_num(int package_num) {
            this.package_num = package_num;
        }

        public List<ShopsListBean> getShopsList() {
            return shopsList;
        }

        public void setShopsList(List<ShopsListBean> shopsList) {
            this.shopsList = shopsList;
        }

        public static class ShopBackBean {
            private int back_id;
            private Object orders_id;
            private String back_info;
            private String back_com;
            private String back_code;
            private int back_status;
            private int shop_id;
            private String shop_pic;
            private int back_type;
            private String back_note;

            public int getBack_id() {
                return back_id;
            }

            public void setBack_id(int back_id) {
                this.back_id = back_id;
            }

            public Object getOrders_id() {
                return orders_id;
            }

            public void setOrders_id(Object orders_id) {
                this.orders_id = orders_id;
            }

            public String getBack_info() {
                return back_info;
            }

            public void setBack_info(String back_info) {
                this.back_info = back_info;
            }

            public String getBack_com() {
                return back_com;
            }

            public void setBack_com(String back_com) {
                this.back_com = back_com;
            }

            public String getBack_code() {
                return back_code;
            }

            public void setBack_code(String back_code) {
                this.back_code = back_code;
            }

            public int getBack_status() {
                return back_status;
            }

            public void setBack_status(int back_status) {
                this.back_status = back_status;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public String getShop_pic() {
                return shop_pic;
            }

            public void setShop_pic(String shop_pic) {
                this.shop_pic = shop_pic;
            }

            public int getBack_type() {
                return back_type;
            }

            public void setBack_type(int back_type) {
                this.back_type = back_type;
            }

            public String getBack_note() {
                return back_note;
            }

            public void setBack_note(String back_note) {
                this.back_note = back_note;
            }
        }

        public static class ShopsListBean {
            private String order_id;
            private int shop_id;
            private int shop_num;
            private double shop_buy_price;
            private double shop_price;
            private int shop_parameter;
            private int send_status;
            private String shop_name;
            private String shop_pic;
            private Object shop_type;
            private Object type_parent;
            private Object type_grandparents;
            private Object shop_car_id;
            private String parameter_name;
            private String size_name;
            /**
             * back_id : 0
             * orders_id :
             * back_info :
             * back_com :
             * back_code :
             * back_status : 0
             * shop_id : null
             * shop_pic :
             * back_type : 0
             * back_note : null
             */

            private ShopBackBean shopBack;
            private String back_info;
            private int comment_star;
            private boolean check;

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public int getShop_id() {
                return shop_id;
            }

            public void setShop_id(int shop_id) {
                this.shop_id = shop_id;
            }

            public int getShop_num() {
                return shop_num;
            }

            public void setShop_num(int shop_num) {
                this.shop_num = shop_num;
            }

            public double getShop_buy_price() {
                return shop_buy_price;
            }

            public void setShop_buy_price(double shop_buy_price) {
                this.shop_buy_price = shop_buy_price;
            }

            public double getShop_price() {
                return shop_price;
            }

            public void setShop_price(double shop_price) {
                this.shop_price = shop_price;
            }

            public int getShop_parameter() {
                return shop_parameter;
            }

            public void setShop_parameter(int shop_parameter) {
                this.shop_parameter = shop_parameter;
            }

            public int getSend_status() {
                return send_status;
            }

            public void setSend_status(int send_status) {
                this.send_status = send_status;
            }

            public String getShop_name() {
                return shop_name;
            }

            public void setShop_name(String shop_name) {
                this.shop_name = shop_name;
            }

            public String getShop_pic() {
                return shop_pic;
            }

            public void setShop_pic(String shop_pic) {
                this.shop_pic = shop_pic;
            }

            public Object getShop_type() {
                return shop_type;
            }

            public void setShop_type(Object shop_type) {
                this.shop_type = shop_type;
            }

            public Object getType_parent() {
                return type_parent;
            }

            public void setType_parent(Object type_parent) {
                this.type_parent = type_parent;
            }

            public Object getType_grandparents() {
                return type_grandparents;
            }

            public void setType_grandparents(Object type_grandparents) {
                this.type_grandparents = type_grandparents;
            }

            public Object getShop_car_id() {
                return shop_car_id;
            }

            public void setShop_car_id(Object shop_car_id) {
                this.shop_car_id = shop_car_id;
            }

            public String getParameter_name() {
                return parameter_name;
            }

            public void setParameter_name(String parameter_name) {
                this.parameter_name = parameter_name;
            }

            public String getSize_name() {
                return size_name;
            }

            public void setSize_name(String size_name) {
                this.size_name = size_name;
            }

            public ShopBackBean getShopBack() {
                return shopBack;
            }

            public void setShopBack(ShopBackBean shopBack) {
                this.shopBack = shopBack;
            }

            public String getBack_info() {
                return back_info;
            }

            public void setBack_info(String back_info) {
                this.back_info = back_info;
            }

            public int getComment_star() {
                return comment_star;
            }

            public void setComment_star(int comment_star) {
                this.comment_star = comment_star;
            }

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public static class ShopBackBean {
                private int back_id;
                private String orders_id;
                private String back_info;
                private String back_com;
                private String back_code;
                private int back_status;
                private Object shop_id;
                private String shop_pic;
                private int back_type;
                private Object back_note;

                public int getBack_id() {
                    return back_id;
                }

                public void setBack_id(int back_id) {
                    this.back_id = back_id;
                }

                public String getOrders_id() {
                    return orders_id;
                }

                public void setOrders_id(String orders_id) {
                    this.orders_id = orders_id;
                }

                public String getBack_info() {
                    return back_info;
                }

                public void setBack_info(String back_info) {
                    this.back_info = back_info;
                }

                public String getBack_com() {
                    return back_com;
                }

                public void setBack_com(String back_com) {
                    this.back_com = back_com;
                }

                public String getBack_code() {
                    return back_code;
                }

                public void setBack_code(String back_code) {
                    this.back_code = back_code;
                }

                public int getBack_status() {
                    return back_status;
                }

                public void setBack_status(int back_status) {
                    this.back_status = back_status;
                }

                public Object getShop_id() {
                    return shop_id;
                }

                public void setShop_id(Object shop_id) {
                    this.shop_id = shop_id;
                }

                public String getShop_pic() {
                    return shop_pic;
                }

                public void setShop_pic(String shop_pic) {
                    this.shop_pic = shop_pic;
                }

                public int getBack_type() {
                    return back_type;
                }

                public void setBack_type(int back_type) {
                    this.back_type = back_type;
                }

                public Object getBack_note() {
                    return back_note;
                }

                public void setBack_note(Object back_note) {
                    this.back_note = back_note;
                }
            }
        }
    }
}
