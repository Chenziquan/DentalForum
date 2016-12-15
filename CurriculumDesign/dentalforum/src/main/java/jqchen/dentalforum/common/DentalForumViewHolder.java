package jqchen.dentalforum.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.util.GlideUtil;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class DentalForumViewHolder extends BaseViewHolder {
    public DentalForumViewHolder(View view) {
        super(view);
    }

    public DentalForumViewHolder setImageUrl(int id, String url) {
        GlideUtil.getInstance().loadImage(MyApplication.getInstance(), (ImageView) getView(id), url, true);
        return this;
    }

    public DentalForumViewHolder setImagePath(int id, String path) {
        GlideUtil.getInstance().loadPathImage(MyApplication.getInstance(), (ImageView) getView(id), path, false);
        return this;
    }

    public DentalForumViewHolder setRecycler(int id, RecyclerView.LayoutManager layoutManager, BaseQuickAdapter baseQuickAdapter) {
        RecyclerView recyclerView = getView(id);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(baseQuickAdapter);
        return this;
    }
}
