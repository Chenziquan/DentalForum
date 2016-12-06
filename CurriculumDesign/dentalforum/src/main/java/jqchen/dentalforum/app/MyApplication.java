package jqchen.dentalforum.app;

import android.app.Application;

/**
 * Created by jqchen on 2016/12/1.
 * Use to
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
