package itri.smarttvhome.broadcastReceivers.medias;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

public class MediaReceiveBroadcastReceiver extends ItriBroadcastReceiverBase {
    public static String ACTION_BROADCAST_MEDIARECEIVE = "itri.smarttvhome.broadcastReceivers.medias.MediaReceiveBroadcastReceiver.MediaReceive";
    private IMediaReceiveBroadcastReceiverDelegateListener mDelegateListener;

    public MediaReceiveBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IMediaReceiveBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(ACTION_BROADCAST_MEDIARECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegateListener != null) {
            String filePath = intent.getStringExtra("filePath");
            this.mDelegateListener.onMediaReceiver(filePath);
        }
    }
}
