package jqchen.dentalforum.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jqchen on 2016/12/12.
 * Use to
 */
public class Preference {
    private SharedPreferences preferences;

    public Preference(Context context) {
        preferences = context.getSharedPreferences(PreferenceHelper.ShareName, Context.MODE_PRIVATE);
    }

    public String getUserId() {
        return preferences.getString(PreferenceHelper.UserId, "");
    }

    public String getUserName() {
        return preferences.getString(PreferenceHelper.UserName, "");
    }

    public String getUserTel(){
        return preferences.getString(PreferenceHelper.UserTel,"");
    }

    public boolean getAppStatus() {
        return preferences.getBoolean(PreferenceHelper.AppStatus, false);
    }

    public boolean getSignStatus() {
        return preferences.getBoolean(PreferenceHelper.SignStatus, false);
    }

    public void setUserName(String name) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PreferenceHelper.UserName, name);
        editor.apply();
    }

    public void setUserId(String userid) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PreferenceHelper.UserId, userid);
        editor.apply();
    }

    public void setAppStatus(boolean appStatus) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PreferenceHelper.AppStatus, appStatus);
        editor.apply();
    }

    public void setSignStatus(boolean signStatus) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PreferenceHelper.SignStatus, signStatus);
        editor.apply();
    }
    public void setUserTel(String tel){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PreferenceHelper.UserTel, tel);
        editor.apply();
    }

}
