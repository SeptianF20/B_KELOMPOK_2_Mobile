package com.example.app_yoovis.Activity.Auth;

import android.content.Context;
import android.preference.PreferenceManager;

public class SharedPref {
    static final String ID_SEDANG_LOGIN = "Id_login";
    static final String USERNAME_SEDANG_LOGIN = "Username_login";
    static final String TOKEN_SEDANG_LOGIN = "Token_login";
    static final String STATUS_SEDANG_LOGIN = "Status_login";

    /** Pendlakarasian Shared Preferences yang berdasarkan paramater context */
    private static android.content.SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLoginId(Context context, String id){
        android.content.SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(ID_SEDANG_LOGIN, id);
        editor.apply();
    }

    public static String getLoginId(Context context){
        return getSharedPreference(context).getString(ID_SEDANG_LOGIN,"");
    }

    public static void setLoginUsername(Context context, String username){
        android.content.SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(USERNAME_SEDANG_LOGIN, username);
        editor.apply();
    }

    public static String getLoginUsername(Context context){
        return getSharedPreference(context).getString(USERNAME_SEDANG_LOGIN,"");
    }

    public static void setLogInToken(Context context, String token){
        android.content.SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(TOKEN_SEDANG_LOGIN, token);
        editor.apply();
    }

    public static String getLoginToken(Context context){
        return getSharedPreference(context).getString(TOKEN_SEDANG_LOGIN,"");
    }

    public static void setLoginStatus(Context context, boolean status){
        android.content.SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(STATUS_SEDANG_LOGIN,status);
        editor.apply();
    }

    public static boolean getLogInStatus(Context context){
        return getSharedPreference(context).getBoolean(STATUS_SEDANG_LOGIN,false);
    }

    public static void clearLogoutUser(Context context){
        android.content.SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.remove(ID_SEDANG_LOGIN);
        editor.remove(USERNAME_SEDANG_LOGIN);
        editor.remove(STATUS_SEDANG_LOGIN);
        editor.remove(TOKEN_SEDANG_LOGIN);
        editor.apply();
    }
}
