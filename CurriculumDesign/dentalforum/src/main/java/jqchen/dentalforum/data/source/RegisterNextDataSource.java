package jqchen.dentalforum.data.source;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public interface RegisterNextDataSource {
    interface RegisterNextCallBack {
        void onCodeNullError();

        void onCodeError();

        void onRegisterSuccess();
    }

    interface RegisterSendCodeCallBack {
        void onError();

        void onSuccess();
    }

    void sendCode(String telnum, RegisterSendCodeCallBack callBack);

    void registerNext(String telnum, String code, RegisterNextCallBack callBack);
}
