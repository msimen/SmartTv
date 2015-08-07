package itri.smarttvsdk.broadcastSenders.tvContexts;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.TVModeBroadcastReceiver;

/**
 * Created by mimi on 15/3/12.
 */
public class TVFreeModeBroadcastSender extends BroadcastSenderBase {
    public TVFreeModeBroadcastSender(Context ctx, int x, int y, int width, int height) {
        super(ctx);
        this.getSendItent().setAction(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODERECEIVE);
        this.getSendItent().putExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_XKEY, x);
        this.getSendItent().putExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_YKEY, y);
        this.getSendItent().putExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_WIDTHKEY, width);
        this.getSendItent().putExtra(TVModeBroadcastReceiver.ACTION_BROADCAST_FREEMODE_HEIGHTKEY, height);
    }
}
