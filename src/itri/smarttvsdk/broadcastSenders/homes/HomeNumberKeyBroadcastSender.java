package itri.smarttvsdk.broadcastSenders.homes;

import android.content.Context;

import itri.smarttvsdk.defines.Home;


/**
 * Created by mimi on 15/1/13.
 */
public class HomeNumberKeyBroadcastSender extends HomeKeyBroadcastSenderBase {
    public HomeNumberKeyBroadcastSender(Context ctx, int number) {
        super(ctx);
        this.getSendItent().setAction(Home.HOME_NUMBER);
        this.getSendItent().putExtra(Home.NUMBER_KEY, number);
    }
}
