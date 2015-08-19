package itri.smarttvhome.broadcastReceivers.homes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import itri.smarttvsdk.defines.Home;


/**
 * Created by mimi on 15/1/13.
 */
public class HomeNumberKeyBroadcastReceiver extends HomeKeyBroadcastReceiverBase {

    private IHomeNumberKeyBroadcastReceiverDelegateListener mDelegateListener;

    public HomeNumberKeyBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IHomeNumberKeyBroadcastReceiverDelegateListener delegateListener) {
        super.setDelegateListener(delegateListener);
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(Home.HOME_NUMBER);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        int number = intent.getIntExtra(Home.NUMBER_KEY, 0);
        if (this.mDelegateListener != null)
            this.mDelegateListener.numberAccept(number);
    }
}