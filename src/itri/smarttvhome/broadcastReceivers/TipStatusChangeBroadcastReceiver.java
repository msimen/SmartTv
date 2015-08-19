package itri.smarttvhome.broadcastReceivers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.bizs.TipStatus;
import itri.smarttvsdk.broadcastSenders.TipStatusChangeBroadcastSender;

/**
 * Created by mimi on 15/3/13.
 */
public class TipStatusChangeBroadcastReceiver extends ItriBroadcastReceiverBase {
    private ITipStatusChangeBroadcastReceiverDelegateListener mDelegateListener;

    public TipStatusChangeBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ITipStatusChangeBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(TipStatusChangeBroadcastSender.ACTION_BROADCAST);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        TipStatus tipStatus = (TipStatus) intent.getSerializableExtra(TipStatusChangeBroadcastSender.TIPSTATUS_KEY);
        String serviceName = intent.getStringExtra(TipStatusChangeBroadcastSender.SERVICENAME_KEY);

        if (this.mDelegateListener != null)
            this.mDelegateListener.receive(this, new TipStatusEventArgs(tipStatus, serviceName));
//        Log.e("ChannelChangeBackCallBR", "onReceive");
    }
}
