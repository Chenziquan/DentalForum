package jqchen.dentalforum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import jqchen.dentalforum.data.bean.OrderListModel;
import jqchen.dentalforum.data.bean.UserInfoModel;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.UserInfo;
import jqchen.dentalforum.util.GlideUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.glide_test)
    ImageView glideTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        testGetUserInfo();
//        testOrderList();
//        test();
        glidetest();
    }

    private void glidetest() {
        String url = "http://pic11.nipic.com/20101214/213291_155243023914_2.jpg";
        GlideUtil.getInstance().loadImage(this, glideTest, url, true);
    }

    private void test() {
        Map<String, String> map = new HashMap<>();
        map.put("order.u_id", "14");
        map.put("currentpage", "1");
        map.put("pagesize", "4");
        ForumRetrofit.getRetrofit()
                .create(UserInfo.class)
                .getOrderList2(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderListModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(OrderListModel orderListModel) {
                        Log.e("rxjava", orderListModel.getInfo().size() + "");
                    }
                });
    }

    private void testOrderList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://114.55.64.30:8080/migocoo/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        UserInfo userInfo = retrofit.create(UserInfo.class);
        Map<String, String> map = new HashMap<>();
        map.put("order.u_id", "14");
        map.put("currentpage", "1");
        map.put("pagesize", "4");
        Call<OrderListModel> call = userInfo.getOrderList(map);
        call.enqueue(new Callback<OrderListModel>() {
            @Override
            public void onResponse(Call<OrderListModel> call, Response<OrderListModel> response) {
                Log.e("order", response.body().getInfo().size() + "");
            }

            @Override
            public void onFailure(Call<OrderListModel> call, Throwable t) {

            }
        });
    }

    private void testGetUserInfo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://114.55.64.30:8080/migocoo/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        UserInfo userInfo = retrofit.create(UserInfo.class);
        Map<String, String> map = new HashMap<>();
        map.put("user.u_id", "14");
        Call<UserInfoModel> call = userInfo.getUserInfo(map);
        call.enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                Log.e("info", response.body().getInfo().getWb_nickname());
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {

            }
        });
    }
}
