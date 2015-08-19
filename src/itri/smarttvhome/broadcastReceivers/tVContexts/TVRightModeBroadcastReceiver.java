package itri.smarttvhome.broadcastReceivers.tVContexts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.bizs.EventArgs;
import itri.smarttvsdk.defines.TVModeBroadcastReceiver;

/**
 * Created by mimi on 15/3/12.
 */
public class TVRightModeBroadcastReceiver extends ItriBroadcastReceiverBase {
    private ITVRightModeBroadcastReceiverDelegateListener mDelegateListener;

    public TVRightModeBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ITVRightModeBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(TVModeBroadcastReceiver.ACTION_BROADCAST_RIGHTMODERECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null)
            this.mDelegateListener.receive(this, new EventArgs());
//        Log.e("TVRightModeModeBR", "onReceive");
    }
}