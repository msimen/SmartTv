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
public class TVFullModeBroadcastReceiver extends ItriBroadcastReceiverBase {
    private ITVFullModeBroadcastReceiverDelegateListener mDelegateListener;

    public TVFullModeBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ITVFullModeBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(TVModeBroadcastReceiver.ACTION_BROADCAST_FULLMODERECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null)
            this.mDelegateListener.receive(this, new EventArgs());
//        Log.e("TVFullModeBR", "onReceive");
    }
}