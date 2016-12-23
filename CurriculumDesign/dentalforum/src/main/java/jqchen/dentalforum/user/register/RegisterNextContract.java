package jqchen.dentalforum.user.register;

import jqchen.dentalforum.base.BasePresenter;
import jqchen.dentalforum.base.BaseView;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public interface RegisterNextContract {
    interface View extends BaseView {
        void showCodeNullError();

        void showCodeError();

        void registerSuccess();

        void setSendCode(String time);

        void showPasswordNullError();

        void showPasswordLengthError();

        void setCanSendCode();

        void setCanNotSendCode();
    }

    interface Presenter extends BasePresenter {
        void sendCode(String telnum);

        void registerNext(String telnum, String code, String passowrd);
    }
}
