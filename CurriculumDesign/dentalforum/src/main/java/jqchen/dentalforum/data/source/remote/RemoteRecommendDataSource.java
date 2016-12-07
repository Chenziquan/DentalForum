package jqchen.dentalforum.data.source.remote;

import java.util.HashMap;
import java.util.Map;

import jqchen.dentalforum.data.bean.ADListModel;
import jqchen.dentalforum.data.source.RecommendDataSource;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.ForumService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jqchen on 2016/12/2.
 * Use to
 */
public class RemoteRecommendDataSource implements RecommendDataSource {
    @Override
    public void getRecommend(int page, int size, LoadRecommendCallback callback) {

    }

    @Override
    public void getRecommend(LoadRecommendCallback callback) {

    }

    @Override
    public void getBanner(final LoadRecommendCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("adInfo.ad_type", "7");
        ForumRetrofit.getRetrofit()
                .create(ForumService.class)
                .getRecommendBanner(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ADListModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(ADListModel adListModel) {
                        callback.onBannerLoad(adListModel.getInfo());
                    }
                });
    }
}
