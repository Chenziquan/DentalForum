package jqchen.dentalforum.data.source.remote;

import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import jqchen.dentalforum.app.Constants;
import jqchen.dentalforum.app.MyApplication;
import jqchen.dentalforum.data.source.PostContentDataSource;
import jqchen.dentalforum.http.cos.BizServer;
import jqchen.dentalforum.http.cos.PutObjectSamples;
import jqchen.dentalforum.util.StringUtil;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class RemotePostContentDataSource implements PostContentDataSource {
    @Override
    public void addPicture(final List<String> strings, final UploadPictureCallBack callBack) {
        if (strings != null && strings.size() != 0) {
            callBack.onAddPicture(strings);
            BizServer bizServer = BizServer.getInstance(MyApplication.getInstance());
            bizServer.setListPath(strings);
            bizServer.setFileId(Constants.Upload_Pic);
            jqchen.dentalforum.base.UploadPictureCallBack uploadPictureCallBack = new jqchen.dentalforum.base.UploadPictureCallBack() {
                @Override
                public void onProgress(long progress) {
                    Log.e("progress", String.valueOf(progress));
                }

                @Override
                public void onCancel() {

                }

                @Override
                public void onSuccess(String result) {
                    Log.e("成功", StringUtil.cosUrlTransfer(result));
                    callBack.onUploadSuccess(StringUtil.cosUrlTransfer(result));
                }

                @Override
                public void onFail(String string) {
                    Log.e("fail", string);
                }
            };
            PutObjectSamples putObjectSamples = new PutObjectSamples(uploadPictureCallBack, PutObjectSamples.PUT_TYPE.LIST);
            putObjectSamples.execute(bizServer);
        }


    }

    @Override
    public void postSubmit(String title, String content, List<String> strings, PostContentCallBack contentCallBack) {
        if (TextUtils.isEmpty(title)) {
            contentCallBack.onTitleNullError();
            return;
        }
        if (TextUtils.isEmpty(content)) {
            contentCallBack.onContentNullError();
            return;
        }
        contentCallBack.onPostSuccess();
    }
}
