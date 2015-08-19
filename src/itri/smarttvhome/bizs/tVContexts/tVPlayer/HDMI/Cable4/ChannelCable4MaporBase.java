package itri.smarttvhome.bizs.tVContexts.tVPlayer.HDMI.Cable4;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mimi on 15/4/8.
 */
public abstract class ChannelCable4MaporBase implements IChannelCable4Mapor {
    protected Map<String, Cable4Info> cable4Infos = new HashMap();
    private int minChannel = 3;
    private int maxChannel = 411;
    private int currentChnnelNumber = 5;

    @Override
    public Cable4Info getCable4ByChannel(int channelNumber) {
        Cable4Info result;
        String channel = ("000" + channelNumber);
        int sublength = channel.length() - 3;
        String searchKey = channel.substring(sublength);
        Log.e("ChannelCable4MaporBase", "getHLSByChannel_SearchKey:" + searchKey);
        result = this.cable4Infos.get(searchKey);
        if (result != null) {
            this.currentChnnelNumber = channelNumber;
        }
        return result;
    }

    @Override
    public Cable4Info getPreChannel() {
        Cable4Info result = null;
        while (result == null && this.currentChnnelNumber > this.minChannel) {
            this.currentChnnelNumber--;
//            if (this.currentChnnelNumber == this.minChannel)
//                this.currentChnnelNumber = this.minChannel;
            result = this.getCable4ByChannel(this.currentChnnelNumber);
        }
        return result;
    }

    @Override
    public Cable4Info getNextChannel() {
        Cable4Info result = null;
        while (result == null && this.currentChnnelNumber < this.maxChannel) {
            this.currentChnnelNumber++;
//            if (this.currentChnnelNumber == this.maxChannel)
//                this.currentChnnelNumber = this.maxChannel;
            result = this.getCable4ByChannel(this.currentChnnelNumber);
        }
        return result;
    }

}
