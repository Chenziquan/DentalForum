package jqchen.dentalforum.user.info;

import jqchen.dentalforum.data.bean.UserInfoBean;
import jqchen.dentalforum.data.source.UserInfoDataSource;
import jqchen.dentalforum.data.source.repository.UserInfoRepository;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public class UserInfoPresenter implements UserInfoContract.Presenter{
    private UserInfoContract.View mView;

    public UserInfoPresenter(UserInfoContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getUserInfo() {
        UserInfoRepository.getInstance().getUserInfo(new UserInfoDataSource.UserInfoCallBack() {
            @Override
            public void onSuccess(UserInfoBean userInfoBean) {
                mView.setUserInfo(userInfoBean);
                mView.showNormal();
            }

            @Override
            public void onDataNotAvailable() {
                mView.showError();
            }
        });
    }

    @Override
    public void updateProtrait(String url) {
        UserInfoRepository.getInstance().updateProtrait(url, new UserInfoDataSource.UpdateInfoCallBack() {
            @Override
            public void onSuccess(String string) {
                mView.updateProtrait(string);
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
    public void updateName(String name) {
        UserInfoRepository.getInstance().updateName(name, new UserInfoDataSource.UpdateInfoCallBack() {
            @Override
            public void onSuccess(String string) {
                mView.updateName(string);
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
    public void start() {
        getUserInfo();
    }

    @Override
    public void destory() {
        UserInfoRepository.destoryInstance();
    }
}
