package itri.smarttvhome.views.sysitemviews;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

import itri.smarttvhome.broadcastReceivers.sysitems.SysItemSettingReceiveBroadcastReceiver;


/**
 * Created by mimi on 14/12/25.
 */
public class SettingItemView extends SysItemViewBase {

    public SettingItemView(Context context) {
        super(context);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SettingItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();
        this.setValue("Setting");

    }

    @Override
    public void actionExec() {
        super.actionExec();
        Intent intent = new Intent();
        intent.setAction(SysItemSettingReceiveBroadcastReceiver.ACTION_BROADCAST_ACTIONEXECRECEIVE);
        this.getContext().sendBroadcast(intent);
    }
}
