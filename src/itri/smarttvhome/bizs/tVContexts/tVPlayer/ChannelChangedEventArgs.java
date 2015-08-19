package itri.smarttvhome.bizs.tVContexts.tVPlayer;

import itri.smarttvsdk.bizs.EventArgs;

/**
 * Created by mimi on 15/3/12.
 */
public class ChannelChangedEventArgs extends EventArgs {
    private int channel;

    public ChannelChangedEventArgs(int channel) {
        this.channel = channel;
    }

    public int getChannel() {
        return this.channel;
    }
}
