package itri.smarttvhome.broadcastSenders;

import android.content.Context;
import android.util.Log;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;

/**
 * Created by mimi on 15/4/14.
 */
public class HomeCompletedSender extends BroadcastSenderBase {
    public static String ACTION_BROADCAST = "itri.smarttvhome.action.HOME_COMPLETED";

    public HomeCompletedSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(ACTION_BROADCAST);

        Log.e("HomeCompletedSender", "HomeCompletedSender");
    }
}
