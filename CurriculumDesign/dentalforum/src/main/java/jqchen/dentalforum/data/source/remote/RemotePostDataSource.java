package jqchen.dentalforum.data.source.remote;

import java.util.List;

import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.source.PostDataSource;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.ForumService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class RemotePostDataSource implements PostDataSource {

    @Override
    public void getPost(int page, int size, final PostCallBack callBack) {
        if (page > 1) {
            callBack.onLoadFinish();
            return;
        }
        ForumRetrofit.getRetrofit().create(ForumService.class)
                .getHomePosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PostBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(List<PostBean> postBeen) {
                        callBack.onLoadPost(postBeen);
                    }
                });
    }

    @Override
    public void getHeader(PostCallBack callBack) {

    }
}
