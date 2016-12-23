package jqchen.dentalforum.data.source;

import jqchen.dentalforum.base.BaseCallBack;
import jqchen.dentalforum.base.SimpleCallBack;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public interface RegisterNextDataSource {
    interface RegisterNextCallBack extends BaseCallBack {
        void onCodeNullError();

        void onCodeError();

        void onRegisterSuccess();

        void onPassowrdNullError();

        void onPasswordLengthError();

    }

    void sendCode(String telnum, SimpleCallBack callBack);

    void registerNext(String telnum, String code, String passowrd, RegisterNextCallBack callBack);
}
