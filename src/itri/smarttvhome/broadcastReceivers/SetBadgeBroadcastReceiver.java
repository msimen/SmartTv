package itri.smarttvhome.broadcastReceivers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.defines.AppSpecBroadcastReceiver;

/**
 * Created by mimi on 14/12/31.
 */
public class SetBadgeBroadcastReceiver extends ItriBroadcastReceiverBase {

    private ISetBadgeBroadcastReceiverDelegateListener mDelegateListener;

    public SetBadgeBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ISetBadgeBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(AppSpecBroadcastReceiver.ACTION_BROADCAST_SETBADGERECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int badgeNumber = intent.getIntExtra(AppSpecBroadcastReceiver.NUMBER_KEY, 0);
        String name = intent.getStringExtra(AppSpecBroadcastReceiver.NAME_KEY);
        if (this.mDelegateListener != null)
            this.mDelegateListener.setBadge(name, badgeNumber);
    }
}
