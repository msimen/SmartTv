package itri.smarttvhome.bizs.tVContexts;

import itri.smarttvhome.bizs.tVContexts.tVPlayer.ChannelChangedEventArgs;

/**
 * Created by mimi on 15/3/12.
 */
public interface ITVPlayerDelegateListener {
    public void channelChanged(Object sender, ChannelChangedEventArgs args);

    public void channelFail(Object sender, ChannelFailEventArgs args);

    public void modeChanged(Object sender, ModeChangedEventArgs args);

}
