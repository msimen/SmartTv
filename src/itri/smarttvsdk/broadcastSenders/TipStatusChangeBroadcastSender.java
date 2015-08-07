package itri.smarttvsdk.broadcastSenders;

import android.content.Context;
import android.os.Bundle;

import itri.smarttvsdk.bizs.TipStatus;

/**
 * Created by mimi on 15/3/13.
 */
public class TipStatusChangeBroadcastSender extends BroadcastSenderBase  {
    public static String ACTION_BROADCAST = "itri.smarttvsdk.broadcastSenders.TipStatusChangeBroadcastSender.BroadcastAction";
    public static String TIPSTATUS_KEY = "itri.smarttvsdk.broadcastSenders.TipStatusChangeBroadcastSender.TipStatusKey";
    public static String SERVICENAME_KEY = "itri.smarttvsdk.broadcastSenders.TipStatusChangeBroadcastSender.ServiceNameKey";
    public TipStatusChangeBroadcastSender(Context ctx, TipStatus tipStatusip, String serviceName) {
        super(ctx);
        this.getSendItent().setAction(ACTION_BROADCAST);
        this.getSendItent().putExtra(SERVICENAME_KEY,serviceName);
        Bundle bud = new Bundle();
        bud.putSerializable(TIPSTATUS_KEY,tipStatusip);
        this.getSendItent().putExtras(bud);
    }
}
