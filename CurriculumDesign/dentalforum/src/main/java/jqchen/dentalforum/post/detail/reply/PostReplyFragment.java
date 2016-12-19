package jqchen.dentalforum.post.detail.reply;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.util.GlideUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostReplyFragment extends BaseFragment implements PostReplyContract.View {
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;
    @BindView(R.id.post_reply_recycler)
    RecyclerView postReplyRecycler;
    @BindView(R.id.post_reply_input)
    EditText postReplyInput;

    private ImageView postReplyPortrait;
    private TextView postReplyName;
    private TextView postReplyGroup;
    private TextView postReplyTime;
    private TextView postReplyContent;

    private Unbinder unbinder;
    private CommentBean commentBean;
    private PostReplyAdapter postReplyAdapter;
    private PostReplyPresenter mPresenter;
    private View networkErrorView, postReplyHeader;

    public PostReplyFragment() {
        // Required empty public constructor
    }

    public static PostReplyFragment getInstance(){
        return new PostReplyFragment();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new PostReplyPresenter(this);
        initHeader();
    }

    private void initHeader() {
        postReplyHeader = LayoutInflater.from(getContext()).inflate(R.layout.post_reply_header, null);
        postReplyPortrait = (ImageView) postReplyHeader.findViewById(R.id.post_reply_portrait);
        postReplyName = (TextView) postReplyHeader.findViewById(R.id.post_reply_name);
        postReplyGroup = (TextView) postReplyHeader.findViewById(R.id.post_reply_group);
        postReplyTime = (TextView) postReplyHeader.findViewById(R.id.post_reply_time);
        postReplyContent = (TextView) postReplyHeader.findViewById(R.id.post_reply_content);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post_reply;
    }

    @Override
    public void initData() {
        commentBean = getArguments().getParcelable(getString(R.string.post_reply_bean));
        setAdapter();
        setHeader();
    }

    private void setHeader() {
        GlideUtil.getInstance().loadCircleImage(this.getContext(), postReplyPortrait, commentBean.getuImage());
        postReplyName.setText(commentBean.getuName());
        postReplyGroup.setText(commentBean.getuGroup());
        postReplyTime.setText(commentBean.getTime());
        postReplyContent.setText(commentBean.getContent());
    }

    private void setAdapter() {
        postReplyRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        postReplyAdapter = new PostReplyAdapter(R.layout.item_post_reply, commentBean.getReplyBeen());
        postReplyRecycler.setAdapter(postReplyAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick(R.id.post_reply_submit)
    public void onClick() {
        mPresenter.reply(1, postReplyInput.getText().toString(), commentBean.getReplyBeen());
    }

    @Override
    public void setComment(CommentBean commentBean) {

    }

    @Override
    public void setReplyRefresh(List<CommentBean.ReplyBean> replyBeen) {

    }

    @Override
    public void setReplyLoad(List<CommentBean.ReplyBean> replyBeen) {

    }

    @Override
    public void refresh() {
        postReplyAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearInput() {
        postReplyInput.setText("");
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {
        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.VISIBLE);
            return;
        }
        networkErrorView = networkErrorLayout.inflate();
    }

    @Override
    public void showNormal() {
        if (networkErrorView != null) {
            networkErrorView.setVisibility(View.GONE);
        }
    }
}
