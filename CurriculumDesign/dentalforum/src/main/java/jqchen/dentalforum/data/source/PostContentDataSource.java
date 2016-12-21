package jqchen.dentalforum.data.source;

import java.util.List;

import jqchen.dentalforum.base.BaseCallBack;

/**
 * Created by jqchen on 2016/12/15.
 * Use to
 */
public interface PostContentDataSource {
    interface PostContentCallBack extends BaseCallBack {
        void onTitleNullError();

        void onContentNullError();

        void onPostSuccess();
    }

    interface UploadPictureCallBack extends BaseCallBack {
        void onAddPicture(List<String> strings);
        void onUploadSuccess(String url);
    }

    void addPicture(List<String> strings, UploadPictureCallBack callBack);

    void postSubmit(String title, String content, List<String> strings, PostContentCallBack contentCallBack);
}
