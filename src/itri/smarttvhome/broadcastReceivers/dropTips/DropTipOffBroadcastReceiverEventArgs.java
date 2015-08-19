package itri.smarttvhome.broadcastReceivers.dropTips;

import itri.smarttvsdk.bizs.EventArgs;

/**
 * Created by mimi on 15/4/3.
 */
public class DropTipOffBroadcastReceiverEventArgs extends EventArgs {
    private String dropTipId;

    public DropTipOffBroadcastReceiverEventArgs(String dropTipId) {
        this.dropTipId = dropTipId;
    }

    public String getDropTipId() {
        return this.dropTipId;
    }
}
