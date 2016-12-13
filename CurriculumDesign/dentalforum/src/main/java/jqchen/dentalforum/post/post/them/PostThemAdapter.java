package jqchen.dentalforum.post.post.them;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.List;

import jqchen.dentalforum.R;
import jqchen.dentalforum.data.bean.PostThemBean;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public class PostThemAdapter extends TagAdapter<PostThemBean> {
    private Context mContext;

    public PostThemAdapter(List<PostThemBean> datas, Context mContext) {
        super(datas);
        this.mContext = mContext;
    }

    public PostThemAdapter(List<PostThemBean> datas) {
        super(datas);
    }

    @Override
    public View getView(FlowLayout parent, int position, PostThemBean postThemBean) {
        if (postThemBean.isSelected()) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_post_them_checked, null);
            ((TextView) view.findViewById(R.id.post_them_checked)).setText(postThemBean.getThem());
            return view;
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_post_them_unchecked, null);
            ((TextView) view.findViewById(R.id.post_them_unchecked)).setText(postThemBean.getThem());
            return view;
        }
    }
}
