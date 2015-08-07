package itri.smarttvsdk.broadcastSenders;

import android.content.Context;

import itri.smarttvsdk.defines.AppSpecBroadcastReceiver;

/**
 * Created by mimi on 15/1/7.
 */
public class SetBadgeBroadcastSender extends BroadcastSenderBase {
    private int badgeNumber;

    public SetBadgeBroadcastSender(Context ctx, int badgeNumber) {
        super(ctx);
        this.badgeNumber = badgeNumber;

        this.getSendItent().setAction(AppSpecBroadcastReceiver.ACTION_BROADCAST_SETBADGERECEIVE);
        this.getSendItent().putExtra(AppSpecBroadcastReceiver.NAME_KEY, this.getContext().getPackageName());
        this.getSendItent().putExtra(AppSpecBroadcastReceiver.NUMBER_KEY, this.badgeNumber);
    }
}
