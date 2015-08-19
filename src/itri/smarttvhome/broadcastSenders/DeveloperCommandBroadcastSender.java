package itri.smarttvhome.broadcastSenders;

import android.content.Context;
import android.util.Log;

//import itri.smarttvsdk.broadcastReceivers.DeveloperCommandBroadcastReceiver;
import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;

/**
 * Created by mimi on 15/4/24.
 */
public class DeveloperCommandBroadcastSender extends BroadcastSenderBase
{
    public DeveloperCommandBroadcastSender(Context ctx,String command) {
        super(ctx);
//        this.getSendItent().setAction(DeveloperCommandBroadcastReceiver.ACTION_BROADCAST);
//        this.getSendItent().putExtra(DeveloperCommandBroadcastReceiver.COMMAND_KEY, command);
        Log.e("DeveloperCommandBS", "constructor_Command:"+command);
    }
}
