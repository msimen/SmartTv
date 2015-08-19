package itri.smarttvhome.broadcastReceivers.tVContexts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.defines.TVModeBroadcastReceiver;

/**
 * Created by mimi on 15/3/12.
 */
public class TVFreePreviewModeBroadcastReceiver extends ItriBroadcastReceiverBase {
    private ITVFreePreviewModeBroadcastReceiverDelegateListener mDelegateListener;

    public TVFreePreviewModeBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            ITVFreePreviewModeBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEPREVIEWMODERECEIVE);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int x = intent.getIntExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_XKEY, 0);
        int y = intent.getIntExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_YKEY, 0);
        int width = intent.getIntExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_WIDTHKEY, 0);
        int height = intent.getIntExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_HEIGHTKEY, 0);
        if (this.mDelegateListener != null)
            this.mDelegateListener.receive(this, new FreeModeEventArgs(x, y, width, height));
//        Log.e("TVFreePreviewModeBR", "onReceive");
    }
}