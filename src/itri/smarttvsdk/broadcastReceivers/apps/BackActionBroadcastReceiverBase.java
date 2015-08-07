package itri.smarttvsdk.broadcastReceivers.apps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

/**
 * Created by mimi on 15/1/6.
 */
public abstract class BackActionBroadcastReceiverBase extends ItriBroadcastReceiverBase {

    public BackActionBroadcastReceiverBase(Activity host) {
        super(host);
    }


    //@Override
    public void onReceive(Context context, Intent intent) {
        this.onExecAction();
    }


    protected void onExecAction() {
        Toast.makeText(this.host, "ShowTextBackActionBroadcastReceiver_execAction",
                Toast.LENGTH_LONG).show();
    }
}
