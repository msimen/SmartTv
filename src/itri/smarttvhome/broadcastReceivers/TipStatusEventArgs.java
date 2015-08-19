package itri.smarttvhome.broadcastReceivers;

import itri.smarttvsdk.bizs.EventArgs;
import itri.smarttvsdk.bizs.TipStatus;

/**
 * Created by mimi on 15/3/13.
 */
public class TipStatusEventArgs extends EventArgs {
    private TipStatus tipStatus;
    private String serviceName;

    public TipStatusEventArgs(TipStatus tipStatus, String serviceName) {
        this.tipStatus = tipStatus;
        this.serviceName = serviceName;
    }

    public TipStatus getTipStatus() {
        return this.tipStatus;
    }

    public String getServiceName() {
        return this.serviceName;
    }
}
