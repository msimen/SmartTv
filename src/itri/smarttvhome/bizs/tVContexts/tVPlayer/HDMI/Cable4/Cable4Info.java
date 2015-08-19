package itri.smarttvhome.bizs.tVContexts.tVPlayer.HDMI.Cable4;

/**
 * Created by mimi on 15/4/8.
 */
public class Cable4Info {

    private String channelCode;
    private String channelName;

    public Cable4Info(String channelCode, String channelName) {
        this.channelCode = channelCode;
        this.channelName = channelName;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public String getChannelName() {
        return this.channelName;
    }
}
