package itri.smarttvsdk.broadcastSenders.homes;

import android.content.Context;

import itri.smarttvsdk.defines.Home;


/**
 * Created by mimi on 15/1/13.
 */
public class HomeOtherKeyBroadcastSender extends HomeKeyBroadcastSenderBase {
    public HomeOtherKeyBroadcastSender(Context ctx, int keyCode) {
        super(ctx);
        this.getSendItent().setAction(Home.HOME_OTHER);
        this.getSendItent().putExtra(Home.KEYCODE_KEY, keyCode);
    }
}
