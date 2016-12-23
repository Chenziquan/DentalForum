package jqchen.dentalforum.data.source.remote;

import java.util.List;

import jqchen.dentalforum.data.bean.RecommendBean;
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
    public void getRecommend(int page, int size, final LoadRecommendCallback callback) {
        if (page > 1) {
            callback.onRecommendFinish();
            return;
        }
        ForumRetrofit.getRetrofit()
                .create(ForumService.class)
                .getRecommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RecommendBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(List<RecommendBean> recommendBeen) {
                        recommendBeen.get(0).setPicture("http://image101.360doc.com/DownloadImg/2016/11/0218/83610116_3.jpg");
                        callback.onRecommendLoad(recommendBeen);
                    }
                });
    }

    @Override
    public void getBanner(LoadBannerCallBack callback) {

    }

}
