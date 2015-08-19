package itri.smarttvhome.views.sysitemviews;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

import itri.smarttvhome.broadcastReceivers.sysitems.SysItemCallBackReceiveBroadcastReceiver;

/**
 * Created by mimi on 14/12/25.
 */
public class CallBackItemView extends SysItemViewBase {
    public CallBackItemView(Context context) {
        super(context);
    }

    public CallBackItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CallBackItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();
        this.setValue("CallBack");
    }

    @Override
    public void actionExec() {
        super.actionExec();
        Intent intent = new Intent();
        intent.setAction(SysItemCallBackReceiveBroadcastReceiver.ACTION_BROADCAST_ACTIONEXECRECEIVE);
        this.getContext().sendBroadcast(intent);
    }
}
