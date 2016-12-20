package jqchen.dentalforum.user.info;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;
import jqchen.dentalforum.data.bean.UserInfoBean;

/**
 * Created by jqchen on 2016/12/20.
 * Use to
 */
public interface UserInfoContract {
    interface View extends BaseView {
        void setUserInfo(UserInfoBean userInfoBean);

        void updateProtrait(String url);

        void updateName(String name);
    }

    interface Presenter extends BasePresenter {
        void getUserInfo();

        void updateProtrait(String url);

        void updateName(String name);

    }
}
