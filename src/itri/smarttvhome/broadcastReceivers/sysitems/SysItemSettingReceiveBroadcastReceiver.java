package itri.smarttvhome.broadcastReceivers.sysitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

/**
 * Created by mimi on 14/12/23.
 */
public class SysItemSettingReceiveBroadcastReceiver extends ItriBroadcastReceiverBase {
    public static String ACTION_BROADCAST_ACTIONEXECRECEIVE = "itri.smarttvhome.broadcastReceivers.sysitems.SysItemSettingReceiveBroadcastReceiver.ActionExecReceive";
    private ISysItemSettingReceiveBroadcastReceiverDelegateListener mDelegateListener;

    public SysItemSettingReceiveBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ISysItemSettingReceiveBroadcastReceiverDelegateListener delegateListener) {
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
