package itri.smarttvhome.broadcastReceivers.dropTips;

import android.graphics.Bitmap;
import android.os.Bundle;

import itri.smarttvsdk.bizs.EventArgs;

/**
 * Created by mimi on 15/4/3.
 */
public class DropTipOnBroadcastReceiverEventArgs extends EventArgs {
    private Bitmap bitmap;
    private String dropAction;
    private String dropTipId;
    private Bundle bundle;

    public DropTipOnBroadcastReceiverEventArgs(Bitmap bitmap, String dropAction, String dropTipId, Bundle bundle) {
        this.bitmap = bitmap;
        this.dropAction = dropAction;
        this.dropTipId = dropTipId;
        this.bundle = bundle;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDropAction() {
        return this.dropAction;
    }

    public String getDropTipId() {
        return this.dropTipId;
    }

    public Bundle getBundle() {
        return this.bundle;
    }
}
