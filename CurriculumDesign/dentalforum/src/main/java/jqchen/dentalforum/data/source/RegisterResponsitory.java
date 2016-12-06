package jqchen.dentalforum.data.source;

import jqchen.dentalforum.data.source.local.LocalRegisterDataSource;
import jqchen.dentalforum.data.source.remote.RemoteRegisterDataSource;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RegisterResponsitory implements RegisterDataSource {
    public static RegisterResponsitory INSTANCE = null;
    private LocalRegisterDataSource localRegisterDataSource;
    private RemoteRegisterDataSource remoteRegisterDataSource;

    public RegisterResponsitory() {
        this.localRegisterDataSource = new LocalRegisterDataSource();
        this.remoteRegisterDataSource = new RemoteRegisterDataSource();
    }
    public static RegisterResponsitory getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RegisterResponsitory();
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
