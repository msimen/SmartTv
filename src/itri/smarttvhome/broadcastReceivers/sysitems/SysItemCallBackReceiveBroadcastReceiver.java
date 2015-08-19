package itri.smarttvhome.broadcastReceivers.sysitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

/**
 * Created by mimi on 14/12/23.
 */
public class SysItemCallBackReceiveBroadcastReceiver extends ItriBroadcastReceiverBase {
    public static String ACTION_BROADCAST_ACTIONEXECRECEIVE = "itri.smarttvhome.broadcastReceivers.sysitems.SysItemCallBackReceiveBroadcastReceiver.ActionExecReceive";
    private ISysItemCallBackReceiveBroadcastReceiverDelegateListener mDelegateListener;

    public SysItemCallBackReceiveBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ISysItemCallBackReceiveBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(ACTION_BROADCAST_ACTIONEXECRECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null) {
            this.mDelegateListener.onActionExecReceiver();
        }
    }
}
