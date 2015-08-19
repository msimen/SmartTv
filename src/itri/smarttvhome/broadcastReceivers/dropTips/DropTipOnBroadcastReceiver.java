package itri.smarttvhome.broadcastReceivers.dropTips;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

//import itri.smarttvsdk.broadcastSenders.dropTips.DropTipOnBroadcastSender;
//import itri.smarttvsdk.utilities.BitmapHelper;

/**
 * Created by mimi on 15/4/3.
 */
public class DropTipOnBroadcastReceiver extends ItriBroadcastReceiverBase {
    private IDropTipOnBroadcastReceiverDelegateListener mDelegateListener;

    public DropTipOnBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IDropTipOnBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
//        this.intentFilter.addAction(DropTipOnBroadcastSender.ACTION_BROADCAST);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("DropTipOnBR", "onReceive");
        if (this.mDelegateListener != null) {
//            byte[] byteArraySource = intent.getByteArrayExtra(DropTipOnBroadcastSender.BITMAP_KEY);
//            Bitmap bitmap = BitmapHelper.bytes2Bitmap(byteArraySource);
//            String dropAction = intent.getStringExtra(DropTipOnBroadcastSender.DROPACTION_KEY);
//            String dropTipId = intent.getStringExtra(DropTipOnBroadcastSender.DROPTIPID_KEY);
//            Bundle bundle = intent.getBundleExtra(DropTipOnBroadcastSender.BUNDLE_KEY);
//            DropTipOnBroadcastReceiverEventArgs eventArgs =
//                    new DropTipOnBroadcastReceiverEventArgs(bitmap, dropAction, dropTipId, bundle);
//            this.mDelegateListener.onReceiver(this, eventArgs);
        }
    }
}
