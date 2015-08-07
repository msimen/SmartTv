package itri.smarttvsdk.broadcastSenders.tvContexts;

import android.content.Context;
import android.util.Log;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.TVModeBroadcastReceiver;

/**
 * Created by mimi on 15/3/12.
 */
public class TVRightModeBroadcastSender extends BroadcastSenderBase {
    public TVRightModeBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(TVModeBroadcastReceiver.ACTION_BROADCAST_RIGHTMODERECEIVE);
        Log.e("RightModeSender", "Constructors");
    }
}
