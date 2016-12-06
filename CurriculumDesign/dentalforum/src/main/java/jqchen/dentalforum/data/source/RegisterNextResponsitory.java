package jqchen.dentalforum.data.source;

import jqchen.dentalforum.data.source.local.LocalRegisterNextDataSource;
import jqchen.dentalforum.data.source.remote.RemoteRegisterNextDataSource;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RegisterNextResponsitory implements RegisterNextDataSource {
    private static RegisterNextResponsitory INSTANCE = null;
    private LocalRegisterNextDataSource localRegisterNextDataSource;
    private RemoteRegisterNextDataSource remoteRegisterNextDataSource;

    public RegisterNextResponsitory() {
        this.localRegisterNextDataSource = new LocalRegisterNextDataSource();
        this.remoteRegisterNextDataSource = new RemoteRegisterNextDataSource();
    }

    public static RegisterNextResponsitory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RegisterNextResponsitory();
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }

    @Override
    public void sendCode(String telnum, RegisterSendCodeCallBack callBack) {
        localRegisterNextDataSource.sendCode(telnum, callBack);
    }

    @Override
    public void registerNext(String telnum, String code, RegisterNextCallBack callBack) {
        remoteRegisterNextDataSource.registerNext(telnum, code, callBack);
    }
}
