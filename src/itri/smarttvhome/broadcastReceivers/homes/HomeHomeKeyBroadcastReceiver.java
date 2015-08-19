package itri.smarttvhome.broadcastReceivers.homes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

import itri.smarttvsdk.defines.Home;

/**
 * Created by mimi on 15/1/13.
 */
public class HomeHomeKeyBroadcastReceiver extends ItriBroadcastReceiverBase {

    private IHomeHomeKeyBroadcastReceiverDelegateListener mDelegateListener;

    public HomeHomeKeyBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IHomeHomeKeyBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(Home.HOME_HOME);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("HomeHomeKeyBroadcastReceiver", "onReceive");
        String source_Context_Name = intent.getStringExtra(Home.SOURCE_CONTEXT_NAME_KEY);
        if (this.mDelegateListener != null)
            this.mDelegateListener.contextNameAccept(source_Context_Name);
    }
}