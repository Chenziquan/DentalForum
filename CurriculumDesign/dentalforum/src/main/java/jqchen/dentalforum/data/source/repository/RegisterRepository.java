package jqchen.dentalforum.data.source.repository;

import jqchen.dentalforum.data.source.RegisterDataSource;
import jqchen.dentalforum.data.source.local.LocalRegisterDataSource;
import jqchen.dentalforum.data.source.remote.RemoteRegisterDataSource;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RegisterRepository implements RegisterDataSource {
    public static RegisterRepository INSTANCE = null;
    private LocalRegisterDataSource localRegisterDataSource;
    private RemoteRegisterDataSource remoteRegisterDataSource;

    public RegisterRepository() {
        this.localRegisterDataSource = new LocalRegisterDataSource();
        this.remoteRegisterDataSource = new RemoteRegisterDataSource();
    }
    public static RegisterRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RegisterRepository();
        }
        return INSTANCE;
    }
    public static void destoryInstance(){
        INSTANCE = null;
    }

    @Override
    public void register(String tel, RegisterCallBack callBack) {
        remoteRegisterDataSource.register(tel,callBack);
    }
}
