package jqchen.dentalforum.function.video;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import jqchen.dentalforum.R;
import jqchen.dentalforum.library.AppActivity;
import jqchen.dentalforum.library.BaseFragment;

public class VideoActivity extends AppActivity {

    @BindView(R.id.video_title)
    TextView videoTitle;
    @BindView(R.id.login_toolbar)
    Toolbar loginToolbar;
    @BindView(R.id.video_play)
    JCVideoPlayerStandard videoPlay;

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initToolBar();
        setVideo();
    }

    private void setVideo() {
        videoPlay.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4",
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,
                "测试");
    }

    private void initToolBar() {
        setSupportActionBar(loginToolbar);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_video;
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.video_back)
    public void onClick() {
    }
}
