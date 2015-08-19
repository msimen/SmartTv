package itri.smarttvhome.broadcastReceivers;

import itri.smarttvsdk.bizs.workItems.IWorkItem;

/**
 * Created by mimi on 15/1/5.
 */
public interface IWorkItemIntentBroadcastReceiverDelegateListener {
    public void workItemIncome(IWorkItem workItem);
}
