package jqchen.dentalforum.user.register;

import android.os.CountDownTimer;

import jqchen.dentalforum.data.source.RegisterNextDataSource;
import jqchen.dentalforum.data.source.repository.RegisterNextRepository;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class RegisterNextPresenter implements RegisterNextContract.Presenter {
    private RegisterNextContract.View mView;

    public RegisterNextPresenter(RegisterNextContract.View mView) {
        this.mView = mView;
    }

    private CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long l) {
            mView.setSendCode(String.valueOf(l / 1000));
        }

        @Override
        public void onFinish() {
            mView.setCanSendCode();
        }
    };

    @Override
    public void sendCode(String telnum) {
        RegisterNextRepository.getInstance().sendCode(telnum, new RegisterNextDataSource.RegisterSendCodeCallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess() {
                mView.setCanNotSendCode();
                countDownTimer.start();
            }
        });
    }

    @Override
    public void registerNext(String telnum, String code) {
        RegisterNextRepository.getInstance().registerNext(telnum, code, new RegisterNextDataSource.RegisterNextCallBack() {
            @Override
            public void onCodeNullError() {
                mView.showCodeNullError();
            }

            @Override
            public void onCodeError() {
                mView.showCodeError();
            }

            @Override
            public void onRegisterSuccess() {
                mView.registerSuccess();
            }
        });
    }

    @Override
    public void start() {
        mView.showNormal();
    }

    @Override
    public void destory() {
        RegisterNextRepository.destoryInstance();
        countDownTimer.cancel();
    }
}