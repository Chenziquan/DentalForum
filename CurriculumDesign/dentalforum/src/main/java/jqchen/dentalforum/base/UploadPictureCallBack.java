package jqchen.dentalforum.base;

import com.alibaba.sdk.android.oss.model.PutObjectResult;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public interface UploadPictureCallBack {
    void onProgress(long progress);
    void onCancel();
    void onSuccess(PutObjectResult result);
    void onFail(String string);
}
