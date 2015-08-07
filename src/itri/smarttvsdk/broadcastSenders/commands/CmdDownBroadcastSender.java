package itri.smarttvsdk.broadcastSenders.commands;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.CmdReceiveBroadcastReceiver;

/**
 * Created by mimi on 15/1/9.
 */
public class CmdDownBroadcastSender extends BroadcastSenderBase {
    public CmdDownBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(CmdReceiveBroadcastReceiver.ACTION_BROADCAST_DOWMCMDRECEIVE);
    }
}
