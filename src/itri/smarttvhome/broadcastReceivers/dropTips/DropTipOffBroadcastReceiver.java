package itri.smarttvhome.broadcastReceivers.dropTips;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

//import itri.smarttvsdk.broadcastSenders.dropTips.DropTipOffBroadcastSender;

/**
 * Created by mimi on 15/4/3.
 */
public class DropTipOffBroadcastReceiver extends ItriBroadcastReceiverBase {
    private IDropTipOffBroadcastReceiverDelegateListener mDelegateListener;

    public DropTipOffBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IDropTipOffBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
//        this.intentFilter.addAction(DropTipOffBroadcastSender.ACTION_BROADCAST);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("DropTipOffBR", "onReceive");
        if (this.mDelegateListener != null) {
//            DropTipOffBroadcastReceiverEventArgs eventArgs = new DropTipOffBroadcastReceiverEventArgs(intent.getStringExtra(DropTipOffBroadcastSender.DROPTIPID_KEY));
//            this.mDelegateListener.onReceiver(this, eventArgs);
        }
    }
}
