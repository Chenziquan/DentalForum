package jqchen.dentalforum.base;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public interface UploadPictureCallBack {
    void onProgress(long progress);
    void onCancel();
    void onSuccess(String result);
    void onFail(String string);
}
