package jqchen.dentalforum.data.source.remote;

import android.support.v4.util.ArrayMap;

import java.util.List;
import java.util.Map;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.BaseReturnBean;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.bean.PostCommentBean;
import jqchen.dentalforum.data.preference.Preference;
import jqchen.dentalforum.data.source.PostDetailDataSource;
import jqchen.dentalforum.http.ForumRetrofit;
import jqchen.dentalforum.http.ForumService;
import jqchen.dentalforum.util.StringUtil;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class RemotePostDetailDataSource implements PostDetailDataSource {
    Preference preference = new Preference(MyApplication.getInstance());

    @Override
    public void getPostDetail(int postId, final PostDetailCallBack callBack) {
        ForumRetrofit.getRetrofit().create(ForumService.class)
                .getPostDetail(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(PostBean postBean) {
                        callBack.onSuccess(postBean);
                    }
                });
    }

    @Override
    public void getComment(int postId, int page, int size, final PostCommentCallBack commentCallBack) {
        if (page > 1) {
            commentCallBack.onLoadCommentFinish();
            return;
        }
        ForumRetrofit.getRetrofit()
                .create(ForumService.class)
                .getPostComment(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PostCommentBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        commentCallBack.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(List<PostCommentBean> postCommentBeen) {
                        commentCallBack.onGetComment(postCommentBeen);
                    }
                });
    }

    @Override
    public void deleteComment(int postId, int commentId, List<PostCommentBean> list, int postition, SimpleCallBack callBack) {
        list.remove(postition);
        callBack.onSuccess();
    }

    @Override
    public void comment(int postId, String content, List<PostCommentBean> list, PostReplyCallBack callBack) {
        if (StringUtil.isEmpty(content)) {
            callBack.onContentNull();
            return;
        }
        callBack.onSuccess();
    }

    @Override
    public void reply(int postId, int commentId, String content, List<PostCommentBean> list, int position, PostReplyCallBack callBack) {
        if (StringUtil.isEmpty(content)) {
            callBack.onContentNull();
            return;
        }
        callBack.onSuccess();
    }


    @Override
    public void postLike(int postId, boolean isLike, SimpleCallBack callBack) {
        callBack.onSuccess();
    }

    @Override
    public void postCollect(int postId, final SimpleCallBack callBack) {
        Map<String, String> map = new ArrayMap<>();
        map.put("userId", preference.getUserId());
        map.put("postId", String.valueOf(postId));
        ForumRetrofit.getRetrofit().create(ForumService.class)
                .addCollect(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseReturnBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onDataNotAvailable();
                    }

                    @Override
                    public void onNext(BaseReturnBean baseReturnBean) {
                        if (baseReturnBean.isSuccess()) {
                            callBack.onSuccess();
                        } else {
                            callBack.onFail();
                        }
                    }
                });
    }
}
