package itri.smarttvhome.bizs.tVContexts.tVPlayer.HDMI.Cable4;

/**
 * Created by mimi on 15/4/8.
 */
public interface IChannelCable4Mapor {
    public Cable4Info getCable4ByChannel(int channelNumber);

    public Cable4Info getPreChannel();

    public Cable4Info getNextChannel();
}
