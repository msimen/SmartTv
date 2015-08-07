package itri.smarttvsdk.broadcastSenders.tvContexts;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.TVModeBroadcastReceiver;


/**
 * Created by mimi on 15/3/12.
 */
public class TVFullModeBroadcastSender extends BroadcastSenderBase {
    public TVFullModeBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(TVModeBroadcastReceiver.ACTION_BROADCAST_FULLMODERECEIVE);
    }
}
