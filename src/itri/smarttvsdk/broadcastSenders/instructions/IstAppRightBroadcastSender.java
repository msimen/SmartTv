package itri.smarttvsdk.broadcastSenders.instructions;

import android.content.Context;

import itri.smarttvsdk.broadcastSenders.BroadcastSenderBase;
import itri.smarttvsdk.defines.InstructionBroadcastReceiver;

/**
 * Created by mimi on 15/1/9.
 */
public class IstAppRightBroadcastSender extends BroadcastSenderBase {
    public IstAppRightBroadcastSender(Context ctx) {
        super(ctx);
        this.getSendItent().setAction(InstructionBroadcastReceiver.ACTION_BROADCAST_ARISTRECEIVE);
    }
}
