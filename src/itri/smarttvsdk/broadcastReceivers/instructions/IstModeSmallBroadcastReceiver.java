package itri.smarttvsdk.broadcastReceivers.instructions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.defines.InstructionBroadcastReceiver;

/**
 * Created by mimi on 14/12/31.
 */
public class IstModeSmallBroadcastReceiver extends ItriBroadcastReceiverBase {
    private IIstModeSmallBroadcastReceiverDelegateListener mDelegateListener;

    public IstModeSmallBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IIstModeSmallBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(InstructionBroadcastReceiver.ACTION_BROADCAST_MSISTRECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null) {
            this.mDelegateListener.onIstReceiver();
        }
    }
}
