package itri.smarttvsdk.androidservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.json.JSONArray;
import org.json.JSONObject;

import itri.smarttvsdk.bizs.persists.PersistManager;

/**
 * Created by mimi on 15/1/7.
 */
public abstract class HomeAppServiceBase extends Service {
    private PersistManager persistManager;

    private PersistManager getPersistManager() {
        if (this.persistManager == null)
            this.persistManager = new PersistManager(this);
        return this.persistManager;
    }

    protected JSONObject getJObject(String key) {
        return this.getPersistManager().getJObject(key);
    }

    protected String saveJObject(String key, JSONObject object) {
        return this.getPersistManager().saveJObject(key, object);
    }

    protected String saveJObject(JSONObject object) {
        return this.getPersistManager().saveJObject(object);
    }

    protected JSONArray getJArray(String key) {
        return this.getPersistManager().getJArray(key);
    }

    protected String saveJArray(String key, JSONArray object) {
        return this.getPersistManager().saveJArray(key, object);
    }

    protected String saveJArray(JSONArray object) {
        return this.getPersistManager().saveJArray(object);
    }

    protected void removeJObject(String key) {
        this.getPersistManager().removeJObject(key);
    }

    protected void removeJArray(String key) {
        this.getPersistManager().removeJArray(key);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
