package itri.smarttvsdk.bizs.persists;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by mimi on 15/1/7.
 */
public class PersistManager {
    private Context mContext;

    public PersistManager(Context ctx) {
        this.mContext = ctx;
    }

    public JSONObject getJObject(String key) {
        JSONObject result = null;
        try {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            String ps = settings.getString(key, "");
            result = new JSONObject(ps);
        } catch (Exception ex) {

        }
        return result;
    }

    public String getValue(String key) {
        String result = "";
        try {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            String ps = settings.getString(key, "");
            result = ps;
        } catch (Exception ex) {

        }
        return result;
    }


    public String saveJObject(String key, JSONObject object) {
        String result = "-1";
        try {
            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(this.mContext);

            SharedPreferences.Editor edit = prefs.edit();

            edit.putString(key, object.toString());
            edit.commit();
            result = key;
        } catch (Exception ex) {

        }
        return result;
    }

    public String saveValue(String key, String value) {
        String result = "-1";
        try {
            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(this.mContext);

            SharedPreferences.Editor edit = prefs.edit();

            edit.putString(key, value);
            edit.commit();
            result = key;
        } catch (Exception ex) {

        }
        return result;
    }

    public String saveJObject(JSONObject object) {
        String key = UUID.randomUUID().toString();
        return this.saveJObject(key, object);
    }

    public String saveValue(String value) {
        String key = UUID.randomUUID().toString();
        return this.saveValue(key, value);
    }

    public boolean removeJObject(String key) {
        boolean result = false;
        try {
            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(this.mContext);

            SharedPreferences.Editor edit = prefs.edit();

            edit.remove(key);
            edit.commit();
            result = true;
        } catch (Exception ex) {

        }

        return result;
    }

    public JSONArray getJArray(String key) {
        JSONArray result = null;
        try {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            String ps = settings.getString(key, "");
            result = new JSONArray(ps);
        } catch (Exception ex) {

        }
        return result;
    }

    public String saveJArray(String key, JSONArray array) {
        String result = "-1";
        try {
            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(this.mContext);

            SharedPreferences.Editor edit = prefs.edit();

            edit.putString(key, array.toString());

            edit.commit();
            result = key;
        } catch (Exception ex) {

        }
        return result;
    }

    public String saveJArray(JSONArray array) {
        String key = UUID.randomUUID().toString();
        return this.saveJArray(key, array);
    }

    public boolean removeJArray(String key) {
        boolean result = false;
        try {
            SharedPreferences prefs =
                    PreferenceManager.getDefaultSharedPreferences(this.mContext);

            SharedPreferences.Editor edit = prefs.edit();

            edit.remove(key);
            edit.commit();
            result = true;
        } catch (Exception ex) {

        }
        return result;
    }
}
