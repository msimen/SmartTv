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
public class IstAdBroadcastReceiver extends ItriBroadcastReceiverBase {
    private IIstAdBroadcastReceiverDelegateListener mDelegateListener;

    public IstAdBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IIstAdBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(InstructionBroadcastReceiver.ACTION_BROADCAST_ADISTRECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null) {
            this.mDelegateListener.onIstReceiver();
        }
    }
}
