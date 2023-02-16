package com.hookmiui.browser;

import static com.hookmiui.browser.DataStoreNameKt.spFileName;

import java.lang.ref.WeakReference;

import de.robv.android.xposed.XSharedPreferences;

public class Settings {
    private static WeakReference<XSharedPreferences> weakModulePreferences = new WeakReference<>(null);

    private static XSharedPreferences getModuleSharedPreferences() {
        XSharedPreferences preferences = weakModulePreferences.get();
        if (preferences == null) {
            preferences = new XSharedPreferences(BuildConfig.APPLICATION_ID, spFileName);
            preferences.makeWorldReadable();
            weakModulePreferences = new WeakReference<>(preferences);
        } else {
            preferences.reload();
        }
        return preferences;
    }


    public static String getModulePreferencesString(String keyId, String defaultValue) {
        return getModuleSharedPreferences().getString(keyId, defaultValue);
    }


}