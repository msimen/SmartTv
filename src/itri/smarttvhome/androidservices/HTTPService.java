package itri.smarttvhome.androidservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import itri.smarttvhome.bizservices.WebServer;

public class HTTPService extends Service {
    private WebServer server = null;

    @Override
    public void onCreate() {
        super.onCreate();
        this.server = new WebServer(this);
        Log.e("HTTPService", "serviceCreate");
    }

    @Override
    public void onDestroy() {
        this.server.stopThread();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (server.isAlive() == false) {
            server.startThread();
        }

        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
