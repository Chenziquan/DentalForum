package jqchen.dentalforum.data.source.remote;

import android.text.TextUtils;

import java.util.List;

import jqchen.dentalforum.data.source.PostContentDataSource;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class RemotePostContentDataSource implements PostContentDataSource {
    @Override
    public void addPicture(List<String> strings, UploadPictureCallBack callBack) {
        callBack.onSuccess(strings);
    }

    @Override
    public void postSubmit(String title, String content, List<String> strings, PostContentCallBack contentCallBack) {
        if (TextUtils.isEmpty(title)){
            contentCallBack.onTitleNullError();
            return;
        }
        if (TextUtils.isEmpty(content)){
            contentCallBack.onContentNullError();
            return;
        }
        contentCallBack.onPostSuccess();
    }
}
