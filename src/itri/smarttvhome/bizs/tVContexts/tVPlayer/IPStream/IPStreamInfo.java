package itri.smarttvhome.bizs.tVContexts.tVPlayer.IPStream;

/**
 * Created by mimi on 15/3/16.
 */
public class IPStreamInfo {
    private String channelCode;
    private String channelName;
    private String channelUrAddress;

    public IPStreamInfo(String channelCode, String channelName, String channelUrAddress) {
        this.channelCode = channelCode;
        this.channelName = channelName;
        this.channelUrAddress = channelUrAddress;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getChannelUrAddress() {
        return this.channelUrAddress;
    }
}
