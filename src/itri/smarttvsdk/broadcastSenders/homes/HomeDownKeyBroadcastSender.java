package itri.smarttvsdk.broadcastSenders.homes;

import android.content.Context;

import itri.smarttvsdk.defines.Home;

/**
 * Created by mimi on 15/1/13.
 */
public class HomeDownKeyBroadcastSender extends HomeKeyBroadcastSenderBase {
    public HomeDownKeyBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(Home.HOME_DOWN);
    }
}
