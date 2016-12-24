package jqchen.dentalforum.data.source.remote;

import java.util.List;

import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.UserCollectionDataSource;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.ForumService;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class RemoteUserCollectionDataSource implements UserCollectionDataSource {
    @Override
    public void getUserCollection(int page, int size, final UserCollectionCallBack collectionCallBack) {
        if (page > 1) {
            collectionCallBack.onLoadFinish();
            return;
        }
        ForumRetrofit.getRetrofit()
                .create(ForumService.class)
                .getUserCollection(Preference.getInstance().getUserId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PostBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<PostBean> postBeen) {
                        collectionCallBack.onLoadUserCollection(postBeen);
                    }
                });
    }
}
