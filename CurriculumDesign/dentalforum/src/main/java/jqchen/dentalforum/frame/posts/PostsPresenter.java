package jqchen.dentalforum.frame.posts;

import java.util.List;

import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.data.source.PostDataSource;
import jqchen.dentalforum.data.source.repository.PostRepository;

/**
 * Created by jqchen on 2016/12/9.
 * Use to
 */
public class PostsPresenter implements PostsContract.Presenter {
    private PostsContract.View mView;

    public PostsPresenter(PostsContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getPost(int page, int size, final boolean isRefresh) {
        PostRepository.getInstance().getPost(page, size, new PostDataSource.PostCallBack() {
            @Override
            public void onLoadHeader(List<String> header) {

            }

            @Override
            public void onLoadPost(List<PostBean> posts) {
                if (isRefresh) {
                    mView.refresh(posts);
                } else {
                    mView.load(posts);
                }
                mView.showNormal();
            }

            @Override
            public void onLoadFinish() {
                mView.loadFinish();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void getHeader() {
        PostRepository.getInstance().getHeader(new PostDataSource.PostCallBack() {
            @Override
            public void onLoadHeader(List<String> header) {
                mView.setHeader(header);
                mView.showNormal();
            }

            @Override
            public void onLoadPost(List<PostBean> posts) {

            }

            @Override
            public void onLoadFinish() {

            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {
        getPost(1, 10, true);
        getHeader();
    }

    @Override
    public void destory() {
        PostRepository.destoryInstance();
    }
}
