package jqchen.dentalforum.user.posts;

import java.util.List;

import jqchen.dentalforum.data.bean.UserPostsBean;
import jqchen.dentalforum.data.source.UserPostsDataSource;
import jqchen.dentalforum.data.source.repository.UserPostsRepository;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserPostsPresenter implements UserPostsContract.Presenter {
    private UserPostsContract.View mView;

    public UserPostsPresenter(UserPostsContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        getUserPosts(1, 10, true);
    }

    @Override
    public void destory() {
        UserPostsRepository.destoryInstance();
    }

    @Override
    public void getUserPosts(int page, int size, final boolean isRefresh) {
        UserPostsRepository.getInstance().getUserPosts(page, size, new UserPostsDataSource.UserPostsCallBack() {
            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }

            @Override
            public void onLoadUserPosts(List<UserPostsBean> list) {
                if (isRefresh) {
                    mView.userPostsRefresh(list);
                } else {
                    mView.userPostsLoad(list);
                }
                mView.showNormal();
            }
        });
    }
}
