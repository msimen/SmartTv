package itri.smarttvsdk.broadcastSenders.instructions;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.InstructionBroadcastReceiver;


/**
 * Created by mimi on 15/1/9.
 */
public class IstOkBroadcastSender extends BroadcastSenderBase {
    public IstOkBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(InstructionBroadcastReceiver.ACTION_BROADCAST_OKISTRECEIVE);
    }
}
