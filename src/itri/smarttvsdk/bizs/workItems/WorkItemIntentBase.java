package itri.smarttvsdk.bizs.workItems;

import android.content.Context;
import android.content.Intent;

import itri.smarttvsdk.defines.AppSpecBroadcastReceiver;
import itri.smarttvsdk.defines.WorkIntemItentDefs;


/**
 * Created by mimi on 15/1/5.
 */
public abstract class WorkItemIntentBase extends Intent implements IWorkItemIntent {
    private IHomeAppActivity homeAppActivity;

    public WorkItemIntentBase(IHomeAppActivity homeAppActivity) {
        this.homeAppActivity = homeAppActivity;
        this.putExtra(WorkIntemItentDefs.NUMBER_KEY, this.homeAppActivity.getBadgeNumber());
    }

    @Override
    public Context getContext() {
        return homeAppActivity.getContext();
    }

    @Override
    public void send() {
        this.setAction(AppSpecBroadcastReceiver.ACTION_BROADCAST_WORKITEMINTENTSENDRECEIVE);
        this.getContext().sendBroadcast(this);
    }
}
