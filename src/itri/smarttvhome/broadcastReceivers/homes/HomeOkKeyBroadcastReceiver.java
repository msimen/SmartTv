package itri.smarttvhome.broadcastReceivers.homes;

import android.app.Activity;
import android.content.IntentFilter;

import itri.smarttvsdk.defines.Home;


/**
 * Created by mimi on 15/1/13.
 */
public class HomeOkKeyBroadcastReceiver extends HomeKeyBroadcastReceiverBase {

    private IHomeOkKeyBroadcastReceiverDelegateListener mDelegateListener;

    public HomeOkKeyBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IHomeOkKeyBroadcastReceiverDelegateListener delegateListener) {
        super.setDelegateListener(delegateListener);
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(Home.HOME_OK);
    }
}