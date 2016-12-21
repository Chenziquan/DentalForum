package jqchen.dentalforum.data.source.remote;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.sdk.android.oss.model.PutObjectResult;

import java.util.List;

import jqchen.dentalforum.data.source.PostContentDataSource;
import jqchen.dentalforum.http.alipay.PutObjectSamples;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public class RemotePostContentDataSource implements PostContentDataSource {
    @Override
    public void addPicture(final List<String> strings, final UploadPictureCallBack callBack) {
        if (strings != null && strings.size() != 0) {
            callBack.onAddPicture(strings);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new PutObjectSamples(strings.get(0), new jqchen.dentalforum.base.UploadPictureCallBack() {
                        @Override
                        public void onProgress(long progress) {

                        }

                        @Override
                        public void onCancel() {

                        }

                        @Override
                        public void onSuccess(PutObjectResult result) {
                            Log.e("upload", result.getETag()+"内容");
                        }

                        @Override
                        public void onFail(String string) {
                            Log.e("upload", "fail");
                        }
                    }).asyncPutObjectFromLocalFile();

                }
            }).start();
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
