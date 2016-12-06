package jqchen.dentalforum.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jqchen on 2016/12/5.
 * Use to
 */
public class ShowToast {
    private Context mContext;
    private Toast mToast;

    public ShowToast(Context mContext) {
        this.mContext = mContext;
    }
    public void show(String msg){
        if (mToast == null){
            mToast = Toast.makeText(mContext,msg,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
