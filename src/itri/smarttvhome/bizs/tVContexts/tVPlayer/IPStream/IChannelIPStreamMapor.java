package itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream;

/**
 * Created by mimi on 15/3/16.
 */
public interface IChannelIPStreamMapor {
    public IPStreamInfo getIPStreamByChannel(int channelNumber);

    public IPStreamInfo getPreChannel();

    public IPStreamInfo getNextChannel();
}
