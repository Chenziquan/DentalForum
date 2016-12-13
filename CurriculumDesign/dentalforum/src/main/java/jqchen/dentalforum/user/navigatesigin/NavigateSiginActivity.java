package jqchen.dentalforum.user.navigatesigin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.user.login.LoginActivity;
import jqchen.dentalforum.user.register.RegisterActivity;

public class NavigateSiginActivity extends AppActivity {

    private TextView navigationsiginQq;
    private TextView navigationsiginSina;
    private TextView navigationsiginWechat;
    private BottomSheetDialog bottomSheetDialog;


    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_navigate_sigin;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    private void setListener() {
        OtherSiginOnclickListener listener = new OtherSiginOnclickListener();
        navigationsiginQq.setOnClickListener(listener);
        navigationsiginSina.setOnClickListener(listener);
        navigationsiginWechat.setOnClickListener(listener);
    }

    @OnClick({R.id.navigationsigin_login, R.id.navigationsigin_register, R.id.navigationsigin_other,
            R.id.navigationsigin_forget, /*R.id.navigationsigin_qq, R.id.navigationsigin_sina, R.id.navigationsigin_wechat*/})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.navigationsigin_login:
                intent = new Intent(NavigateSiginActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.navigationsigin_register:
                intent = new Intent(NavigateSiginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.navigationsigin_other:
                setBottomSheet();
                break;
            case R.id.navigationsigin_forget:
                break;
        }
    }

    class OtherSiginOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.navigationsigin_qq:
                    bottomSheetDialog.dismiss();
                    break;
                case R.id.navigationsigin_sina:
                    bottomSheetDialog.dismiss();
                    break;
                case R.id.navigationsigin_wechat:
                    bottomSheetDialog.dismiss();
                    break;
            }
        }
    }

    private void setBottomSheet() {
        bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.navigatesigin_dialog);
        navigationsiginQq = (TextView) bottomSheetDialog.findViewById(R.id.navigationsigin_qq);
        navigationsiginSina = (TextView) bottomSheetDialog.findViewById(R.id.navigationsigin_sina);
        navigationsiginWechat = (TextView) bottomSheetDialog.findViewById(R.id.navigationsigin_wechat);
        setListener();
        bottomSheetDialog.show();
    }

}
