package itri.smarttvhome.broadcastReceivers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.bizs.workItems.AppWorkItem;
import itri.smarttvsdk.defines.AppSpecBroadcastReceiver;

/**
 * Created by mimi on 15/1/5.
 */
public class WorkItemIntentBroadcastReceiver extends ItriBroadcastReceiverBase {

    private IWorkItemIntentBroadcastReceiverDelegateListener mDelegateListener;

    public WorkItemIntentBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IWorkItemIntentBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(AppSpecBroadcastReceiver.ACTION_BROADCAST_WORKITEMINTENTSENDRECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("WorkItemIntentBR", "onReceive");
        if (this.mDelegateListener != null)
            this.mDelegateListener.workItemIncome(new AppWorkItem(context, intent, "AAA"));
    }
}

