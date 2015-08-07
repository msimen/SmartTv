package itri.smarttvsdk.broadcastSenders.tvContexts;

import android.content.Context;
import android.util.Log;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.TVModeBroadcastReceiver;


/**
 * Created by mimi on 15/3/12.
 */
public class TVPreviewModeBroadcastSender extends BroadcastSenderBase {
    public TVPreviewModeBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(TVModeBroadcastReceiver.ACTION_BROADCAST_PREVIEWMODERECEIVE);
        Log.e("PreviewModeSender", "Constructors");
    }
}
