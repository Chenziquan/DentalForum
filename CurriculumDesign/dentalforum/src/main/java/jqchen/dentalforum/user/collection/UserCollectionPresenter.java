package jqchen.dentalforum.user.collection;

import java.util.List;

import jqchen.dentalforum.data.bean.UserCollectionBean;
import jqchen.dentalforum.data.source.UserCollectionDataSource;
import jqchen.dentalforum.data.source.repository.UserCollectionRepository;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class UserCollectionPresenter implements UserCollectionContract.Presenter {
    private UserCollectionContract.View mView;

    public UserCollectionPresenter(UserCollectionContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getUserCollection(int page, int size, final boolean isRefresh) {
        UserCollectionRepository.getInstance().getUserCollection(page, size, new UserCollectionDataSource.UserCollectionCallBack() {
            @Override
            public void onLoadUserCollection(List<UserCollectionBean> list) {
                if (isRefresh) {
                    mView.userCollectionRefresh(list);
                } else {
                    mView.userCollectionLoad(list);
                }
                mView.showError();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void start() {
        getUserCollection(1, 10, true);
    }

    @Override
    public void destory() {
        UserCollectionRepository.destoryInstance();
    }
}
