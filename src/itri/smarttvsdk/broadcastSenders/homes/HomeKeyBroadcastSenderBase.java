package itri.smarttvsdk.broadcastSenders.homes;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.Home;

/**
 * Created by mimi on 15/1/13.
 */
public abstract class HomeKeyBroadcastSenderBase extends BroadcastSenderBase {
    public HomeKeyBroadcastSenderBase(Context ctx) {
        super(ctx);
        this.getSendItent().putExtra(Home.SOURCE_CONTEXT_NAME_KEY, this.getContext().getClass().getName());
    }
}