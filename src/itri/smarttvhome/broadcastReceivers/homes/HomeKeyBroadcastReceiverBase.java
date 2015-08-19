package itri.smarttvhome.broadcastReceivers.homes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.defines.Home;

/**
 * Created by mimi on 15/1/13.
 */
public abstract class HomeKeyBroadcastReceiverBase extends ItriBroadcastReceiverBase {

    private IHomeKeyBroadcastReceiverDelegateListener mDelegateListener;

    public HomeKeyBroadcastReceiverBase(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IHomeKeyBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("HomeKeyBroadcastReceiverBase", "onReceive");
        String source_Context_Name = intent.getStringExtra(Home.SOURCE_CONTEXT_NAME_KEY);
        if (this.mDelegateListener != null)
            this.mDelegateListener.contextNameAccept(source_Context_Name);
    }
}