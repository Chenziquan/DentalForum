package jqchen.dentalforum.post.detail.comment;

import java.util.List;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.source.PostDetailDataSource;
import jqchen.dentalforum.data.source.repository.PostDetailRepository;

/**
 * Created by jqchen on 2016/12/19.
 * Use to
 */
public class PostDetailPresenter implements PostDetailContract.Presenter {
    private PostDetailContract.View mView;

    public PostDetailPresenter(PostDetailContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getPostDetail(int postId) {
        PostDetailRepository.getInstance().getPostDetail(postId, new PostDetailDataSource.PostDetailCallBack() {
            @Override
            public void onSuccess(PostBean postBean) {
                mView.setPostDetail(postBean);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void getComment(int postId, int page, int size, final boolean isRefresh) {
        PostDetailRepository.getInstance().getComment(postId, page, size, new PostDetailDataSource.PostCommentCallBack() {
            @Override
            public void onGetComment(List<CommentBean> list) {
                if (isRefresh) {
                    mView.setCommentRefresh(list);
                } else {
                    mView.setCommentLoad(list);
                }
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void deleteComment(int postId, int commentId, List<CommentBean> list, int position) {
        PostDetailRepository.getInstance().deleteComment(postId, commentId, list, position, new SimpleCallBack() {
            @Override
            public void onSuccess() {
                mView.refresh();
            }

            @Override
            public void onFail() {

            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void comment(int postId, String content, List<CommentBean> list) {
        PostDetailRepository.getInstance().comment(postId, content, list, new PostDetailDataSource.PostReplyCallBack() {
            @Override
            public void onContentNull() {
                mView.showContentNull();
            }

            @Override
            public void onSuccess() {
                mView.refresh();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void reply(int postId, int commentId, String content, List<CommentBean> list, final int position) {
        PostDetailRepository.getInstance().reply(postId, commentId, content, list, position, new PostDetailDataSource.PostReplyCallBack() {
            @Override
            public void onContentNull() {
                mView.showContentNull();
            }

            @Override
            public void onSuccess() {
                mView.refreshComment(position);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void postLike(int postId, final boolean isLike) {
        PostDetailRepository.getInstance().postLike(postId, isLike, new SimpleCallBack() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFail() {
                mView.setLike(!isLike);
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {
        mView.showNormal();
    }

    @Override
    public void destory() {
        PostDetailRepository.destoryInstance();
    }
}
