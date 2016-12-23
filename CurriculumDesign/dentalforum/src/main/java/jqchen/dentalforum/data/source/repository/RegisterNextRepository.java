package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.base.SimpleCallBack;
import jqchen.dentalforum.data.source.RegisterNextDataSource;
import jqchen.dentalforum.data.source.local.LocalRegisterNextDataSource;
import jqchen.dentalforum.data.source.remote.RemoteRegisterNextDataSource;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RegisterNextRepository implements RegisterNextDataSource {
    private static RegisterNextRepository INSTANCE = null;
    private LocalRegisterNextDataSource localRegisterNextDataSource;
    private RemoteRegisterNextDataSource remoteRegisterNextDataSource;

    public RegisterNextRepository() {
        this.localRegisterNextDataSource = new LocalRegisterNextDataSource();
        this.remoteRegisterNextDataSource = new RemoteRegisterNextDataSource();
    }

    public static RegisterNextRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RegisterNextRepository();
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }


    @Override
    public void sendCode(String telnum, SimpleCallBack callBack) {
        localRegisterNextDataSource.sendCode(telnum, callBack);
    }

    @Override
    public void registerNext(String telnum, String code, String passowrd, RegisterNextCallBack callBack) {
        remoteRegisterNextDataSource.registerNext(telnum, code, passowrd, callBack);
    }
}
