package itri.smarttvhome.broadcastSenders;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.ChannelChangeBroadcastReceiver;
import itri.smarttvsdk.defines.IntentApp;

/**
 * Created by mimi on 15/3/13.
 */
public class ChannelChangeBroadcastSender extends BroadcastSenderBase {
    public ChannelChangeBroadcastSender(Context ctx, int channel, String userId, int msoid,String channelAddress) {
        super(ctx);
        this.getSendItent().setAction(ChannelChangeBroadcastReceiver.ACTION_BROADCAST);
        this.getSendItent().putExtra(IntentApp.CHANNEL_KEY, channel);
        this.getSendItent().putExtra(IntentApp.USERID_KEY, userId);
//        this.getSendItent().putExtra(IntentApp.MSOID_KEY, msoid);
        this.getSendItent().putExtra(IntentApp.CHANNELADDRESS_KEY, channelAddress);
        Log.e("ChannelChangeBS", "onCreate_channelAddress:" + channelAddress);

    }
}
