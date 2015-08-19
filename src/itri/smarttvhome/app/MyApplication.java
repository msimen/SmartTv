package itri.smarttvhome.app;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import itri.smarttvhome.androidservices.HTTPService;

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Log.e("MyApplication", "appStart");
        Intent intentHTTPService;
        intentHTTPService = new Intent(this, HTTPService.class);
        this.startService(intentHTTPService);
    }
}
