package itri.smarttvhome.broadcastReceivers.homes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import itri.smarttvsdk.defines.Home;

/**
 * Created by mimi on 15/1/13.
 */
public class HomeOtherKeyBroadcastReceiver extends HomeKeyBroadcastReceiverBase {

    private IHomeOtherKeyBroadcastReceiverDelegateListener mDelegateListener;

    public HomeOtherKeyBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IHomeOtherKeyBroadcastReceiverDelegateListener delegateListener) {
        super.setDelegateListener(delegateListener);
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(Home.HOME_OTHER);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        int keycode = intent.getIntExtra(Home.KEYCODE_KEY, 0);
        if (this.mDelegateListener != null)
            this.mDelegateListener.otherAccept(keycode);
    }
}