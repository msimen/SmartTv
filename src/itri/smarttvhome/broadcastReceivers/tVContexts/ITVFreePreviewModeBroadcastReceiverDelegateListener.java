package itri.smarttvhome.broadcastReceivers.tVContexts;

/**
 * Created by mimi on 15/3/12.
 */
public interface ITVFreePreviewModeBroadcastReceiverDelegateListener extends ITVModeBroadcastReceiverDelegateListener {
    public void receive(Object sender, FreeModeEventArgs args);
}
