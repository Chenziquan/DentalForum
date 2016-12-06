package jqchen.dentalforum.http;

import java.util.Map;

import jqchen.dentalforum.data.bean.OrderListModel;
import jqchen.dentalforum.data.bean.UserInfoModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by jqchen on 2016/11/30.
 * Use to
 */
public interface UserInfo {

    @GET("user/getInfoUser.tg")
    Call<UserInfoModel> getUserInfo(@QueryMap Map<String, String> map);

    @POST("order/viewlistOrder.tg")
    Call<OrderListModel> getOrderList(@QueryMap Map<String, String> map);

    @POST("order/viewlistOrder.tg")
    Observable<OrderListModel> getOrderList2(@QueryMap Map<String,String> map);

}
