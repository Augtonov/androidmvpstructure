package developer.xander.android_mvp_architecture.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import developer.xander.android_mvp_architecture.MvpArchiApp;


/**
 * Created by Augtonov on 1/10/17.
 */

public class PreferenceManager implements PreferenceHelper{

    private static final String PREF_KEY_CURRENT_USER_ID = "pref_key_current_user_id";

    private static SharedPreferences sharedPreferences;
    private static PreferenceManager preferenceManager;

    public static PreferenceManager getInstance() {
        if (preferenceManager == null) {
            preferenceManager = new PreferenceManager();
        }
        return preferenceManager;
    }

    private PreferenceManager() {
        String prefsFile = MvpArchiApp.getContext().getPackageName();
        sharedPreferences = MvpArchiApp.getContext().getSharedPreferences(prefsFile, Context.MODE_PRIVATE);
    }

    /*public void delete(String key) {
        if (sharedPreferences.contains(key)) {
            editor.remove(key).commit();
        }
    }

    public void savePref(String key, Object value) {
        delete(key);

        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            editor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-primitive preference");
        }

        editor.commit();
    }

    @SuppressWarnings("unchecked")
    public <T> T getPref(String key) {
        return (T) sharedPreferences.getAll().get(key);
    }

    @SuppressWarnings("unchecked")
    public <T> T getPref(String key, T defValue) {
        T returnValue = (T) sharedPreferences.getAll().get(key);
        return returnValue == null ? defValue : returnValue;
    }

    public boolean isPrefExists(String key) {
        return sharedPreferences.contains(key);
    }*/

    @Override
    public String getCurrentUserId() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_ID, "");
    }

    @Override
    public void setCurrentUserId(String userId) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply();
    }

    @Override
    public void deleteCurrentUserId() {
        if (sharedPreferences.contains(PREF_KEY_CURRENT_USER_ID)) {
            sharedPreferences.edit().remove(PREF_KEY_CURRENT_USER_ID).apply();
        }
    }
}
