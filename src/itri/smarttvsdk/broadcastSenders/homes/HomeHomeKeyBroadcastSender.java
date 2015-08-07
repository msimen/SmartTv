package itri.smarttvsdk.broadcastSenders.homes;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.Home;

/**
 * Created by mimi on 15/1/13.
 */
public class HomeHomeKeyBroadcastSender extends BroadcastSenderBase {
    public HomeHomeKeyBroadcastSender(Context ctx, String homePackageName) {
        super(ctx);
        this.getSendItent().setAction(homePackageName);
    }

    public void send() {
        super.send();
        this.getSendItent().setAction(Home.HOME_HOME);
        this.getSendItent().putExtra(Home.SOURCE_CONTEXT_NAME_KEY, this.getContext().getClass().getName());
        this.getContext().sendBroadcast(this.getSendItent());
    }
}
