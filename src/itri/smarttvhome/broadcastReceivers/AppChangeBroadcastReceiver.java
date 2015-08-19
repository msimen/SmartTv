package itri.smarttvhome.broadcastReceivers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import org.itri.icl.droptv.sharetvcore.broadcastReceivers.ItriBroadcastReceiverBase;

/**
 * Created by mimi on 14/12/31.
 */
public class AppChangeBroadcastReceiver extends ItriBroadcastReceiverBase {

    private IAppChangeBroadcastReceiverDelegateListener mDelegateListener;

    public AppChangeBroadcastReceiver(Activity host) {
        super(host);
    }

    public void setDelegateListener(
            IAppChangeBroadcastReceiverDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    @Override
    protected void onInitializeIntentFilter() {
        this.intentFilter = new IntentFilter();
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_CHANGED);
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_DATA_CLEARED);
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_INSTALL);
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_REPLACED);
        this.intentFilter.addAction(Intent.ACTION_PACKAGE_RESTARTED);
        this.intentFilter.addDataScheme("package");
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AppChangeBR", "onReceive");
        if (this.mDelegateListener != null)
            this.mDelegateListener.appChange();
    }
}
