package jqchen.dentalforum.post.detail.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.CommentBean;
import jqchen.dentalforum.data.bean.PostBean;
import jqchen.dentalforum.library.BaseFragment;
import jqchen.dentalforum.post.detail.reply.PostReplyActivity;
import jqchen.dentalforum.util.GlideUtil;

/**
 * 帖子内容
 */
public class PostDetailFragment extends BaseFragment implements PostDetailContract.View, BaseQuickAdapter.RequestLoadMoreListener, PopupMenu.OnMenuItemClickListener {
    @BindView(R.id.post_detail_recycler)
    RecyclerView postDetailRecycler;
    @BindView(R.id.post_detail_input)
    EditText postDetailInput;
    @BindView(R.id.post_detail_like)
    CheckBox postDetailLike;
    @BindView(R.id.network_error_layout)
    ViewStub networkErrorLayout;

    private ImageView itemPostImage;
    private TextView itemPostName;
    private TextView itemPostGroup;
    private TextView itemPostThem;
    private TextView itemPostTitle;
    private TextView itemPostContent;
    private RecyclerView itemPostRecycler;
    private TextView itemPostTime;
    private TextView itemPostViewnum;
    private TextView itemPostCommentnum;

    private Unbinder unbinder;
    private List<CommentBean> list;
    private PostDetailAdapter postDetailAdapter;
    private View postDetailHeader, netwrokErrorView;
    private PostDetailPresenter mPresenter;
    private int page = 1;
    private int size = 10;
    private int postId;

    public static PostDetailFragment getInstance() {
        return new PostDetailFragment();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new PostDetailPresenter(this);
        initHeader();
        setListener();
    }

    private void setListener() {
        postDetailRecycler.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                /*PopupMenu popupMenu = new PopupMenu(getContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_post_opera, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(PostDetailFragment.this);
                popupMenu.show();*/
                Intent intent = new Intent(getHoldingActivity(), PostReplyActivity.class);
                intent.putExtra(getString(R.string.post_reply_bean), list.get(i));
                startActivity(intent);
            }
        });
    }

    private void initHeader() {
        postDetailHeader = LayoutInflater.from(this.getContext()).inflate(R.layout.item_post, null);
        itemPostImage = (ImageView) postDetailHeader.findViewById(R.id.item_post_image);
        itemPostName = (TextView) postDetailHeader.findViewById(R.id.item_post_name);
        itemPostGroup = (TextView) postDetailHeader.findViewById(R.id.item_post_group);
        itemPostThem = (TextView) postDetailHeader.findViewById(R.id.item_post_them);
        itemPostTitle = (TextView) postDetailHeader.findViewById(R.id.item_post_title);
        itemPostContent = (TextView) postDetailHeader.findViewById(R.id.item_post_content);
        itemPostRecycler = (RecyclerView) postDetailHeader.findViewById(R.id.item_post_recycler);
        itemPostTime = (TextView) postDetailHeader.findViewById(R.id.item_post_time);
        itemPostViewnum = (TextView) postDetailHeader.findViewById(R.id.item_post_viewnum);
        itemPostCommentnum = (TextView) postDetailHeader.findViewById(R.id.item_post_commentnum);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post_detail;
    }

    @Override
    public void initData() {
        initAdapter();
        mPresenter.getPostDetail(postId);
        mPresenter.getComment(postId, page, size, true);
    }

    private void initAdapter() {
        list = new ArrayList<>();
        postDetailAdapter = new PostDetailAdapter(R.layout.item_post_comment, list);
        postDetailAdapter.addHeaderView(postDetailHeader);
        postDetailRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        postDetailRecycler.setAdapter(postDetailAdapter);
        postDetailAdapter.setOnLoadMoreListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destory();
    }

    @Override
    public void setPostDetail(PostBean postDetail) {
        GlideUtil.getInstance().loadCircleImage(this.getContext(), itemPostImage, postDetail.getUimage());
        itemPostName.setText(postDetail.getUname());
        itemPostGroup.setText(postDetail.getUgroup());
        itemPostThem.setText(postDetail.getThem());
        itemPostTime.setText(postDetail.getTime());
        itemPostTitle.setText(postDetail.getTitle());
        itemPostContent.setText(postDetail.getContent());
        itemPostViewnum.setText(postDetail.getViewnum());
        itemPostCommentnum.setText(postDetail.getCommentnum());
        if (postDetail.getPictures() != null && postDetail.getPictures().size() != 0) {
            itemPostRecycler.setVisibility(View.VISIBLE);
            itemPostRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
            PostDetailImageAdapter imageAdapter = new PostDetailImageAdapter(R.layout.item_post_detail_image, postDetail.getPictures());
            itemPostRecycler.setAdapter(imageAdapter);
        } else {
            itemPostRecycler.setVisibility(View.GONE);
        }
    }

    @Override
    public void setCommentRefresh(List<CommentBean> list) {
        this.list.clear();
        this.list.addAll(list);
        postDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void setCommentLoad(List<CommentBean> list) {
        this.list.addAll(list);
        postDetailAdapter.loadMoreComplete();
    }

    @Override
    public void refreshComment(int position) {
        postDetailAdapter.notifyItemChanged(position);
    }

    @Override
    public void refresh() {
        postDetailAdapter.notifyDataSetChanged();
    }

    @Override
    public void showContentNull() {
        postDetailInput.setError(getString(R.string.post_detail_reply_null_error));
    }

    @Override
    public void setLike(boolean isLike) {
        postDetailLike.setChecked(isLike);
    }

    @Override
    public void setPresenter(Object presenter) {

    }

    @Override
    public void showError() {
        if (netwrokErrorView != null) {
            netwrokErrorView.setVisibility(View.VISIBLE);
            return;
        }
        netwrokErrorView = networkErrorLayout.inflate();
    }

    @Override
    public void showNormal() {
        if (netwrokErrorView != null) {
            netwrokErrorView.setVisibility(View.GONE);
        }
    }


    @OnClick(R.id.post_detail_comment_submit)
    public void onClick() {
        mPresenter.comment(1, postDetailInput.getText().toString(), list);
    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        postDetailRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getComment(postId, page, size, false);
            }
        }, 1800);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.post_detail_opera_reply:
                Log.e("menu", "复制");
                break;
            case R.id.post_detail_opera_delete:
                Log.e("menu", "粘贴");
                break;
        }
        return false;
    }
}
