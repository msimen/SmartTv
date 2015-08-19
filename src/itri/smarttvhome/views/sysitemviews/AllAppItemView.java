package itri.smarttvhome.views.sysitemviews;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

import itri.smarttvhome.broadcastReceivers.sysitems.SysItemAllAppReceiveBroadcastReceiver;

/**
 * Created by mimi on 14/12/25.
 */
public class AllAppItemView extends SysItemViewBase {
    //    protected MitraStarTVObject tvObject;
    public AllAppItemView(Context context) {
        super(context);
    }

    public AllAppItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AllAppItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init() {
        super.init();
        this.setValue("AllApp");
//        this.tvObject = new MitraStarTVObject(this.getContext(), 500, 500, 2000);

    }

    @Override
    public void actionExec() {
        super.actionExec();
//        this.tvObject.toHideMode();
        Intent intent = new Intent();
        intent.setAction(SysItemAllAppReceiveBroadcastReceiver.ACTION_BROADCAST_ACTIONEXECRECEIVE);
        this.getContext().sendBroadcast(intent);
    }
}
