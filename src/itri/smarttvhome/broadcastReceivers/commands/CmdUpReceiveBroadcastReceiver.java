package itri.smarttvhome.broadcastReceivers.commands;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.defines.CmdReceiveBroadcastReceiver;

/**
 * Created by mimi on 14/12/23.
 */
public class CmdUpReceiveBroadcastReceiver extends ItriBroadcastReceiverBase {
    private ICmdUpReceiveBroadcastReceiverDelegateListener mDelegateListener;

    public CmdUpReceiveBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ICmdUpReceiveBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(CmdReceiveBroadcastReceiver.ACTION_BROADCAST_UPCMDRECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null) {
            this.mDelegateListener.onCmdReceiver();
        }
    }
}
