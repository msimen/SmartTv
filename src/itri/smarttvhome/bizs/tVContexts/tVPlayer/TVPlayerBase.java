package itri.smarttvhome.bizs.tVContexts.tVPlayer;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.widget.RelativeLayout;

import itri.smarttvhome.bizs.tVContexts.ChannelFailEventArgs;
import itri.smarttvhome.bizs.tVContexts.ITVPlayer;
import itri.smarttvhome.bizs.tVContexts.ITVPlayerDelegateListener;
import itri.smarttvhome.bizs.tVContexts.ModeChangedEventArgs;
import itri.smarttvhome.bizs.tVContexts.TVPlayerModeType;
import itri.smarttvsdk.bizs.persists.PersistManager;


/**
 * Created by mimi on 15/3/12.
 */
public abstract class TVPlayerBase implements ITVPlayer {
    public static String SAVE_KEY_CHANNEL = "TVPlayerBase.saveChannelKey";
    protected Activity host;
    protected RelativeLayout layout;
    protected int screen_width;
    protected int screen_height;
    private PersistManager persistManager;
    private ITVPlayerDelegateListener delegateListener;
    protected int channel = -1;

    public TVPlayerBase(Activity host, RelativeLayout layout) {
        this.host = host;
        this.layout = layout;
        Point screenSize = new Point();
        this.host.getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;
    }

    private PersistManager getPersistManager() {
        if (this.persistManager == null)
            this.persistManager = new PersistManager(this.host);
        return this.persistManager;
    }

    @Override
    public ITVPlayerDelegateListener getDelegateListener() {
        return this.delegateListener;
    }

    @Override
    public void setDelegateListener(ITVPlayerDelegateListener delegateListener) {
        this.delegateListener = delegateListener;
    }

    @Override
    public int getChannel() {

        if (this.channel == -1) {
            //從Store 讀取值
            //假如Store有值,觸發channel event 讓系統打紅外線出去,只要是開關機時使用,裝置開機讀取上次關機的頻道並打到外部裝置轉換台
            String channelStr = this.getPersistManager().getValue(SAVE_KEY_CHANNEL);
            if (channelStr.equals("") == false) {
                int channelResult = Integer.parseInt(channelStr);
                if (this.channel != channelResult) {
                    String result = onChannelHandle(channelResult);
                    if (result.equals("")) {
                        this.channel = channelResult;
                        if (this.delegateListener != null)
                            this.delegateListener.channelChanged(this, new ChannelChangedEventArgs(this.channel));
                    } else {
                        if (this.delegateListener != null)
                            this.delegateListener.channelFail(this, new ChannelFailEventArgs(result));
                    }
                }
            }
//            Log.e("TVPlayerBase","getChannel:"+ this.channel);
        }
        return this.channel;
    }

    @Override
    public void toChannel(int channel) {
        if (this.channel == channel)
            return;
        String result = this.onChannelHandle(channel);
        if (result.equals("")) {
            //非同步將頻道存至Back Store;
            this.channel = channel;
            this.getPersistManager().saveValue(SAVE_KEY_CHANNEL, this.channel + "");
            if (this.delegateListener != null)
                this.delegateListener.channelChanged(this, new ChannelChangedEventArgs(this.channel));
//        Log.e("TVPlayerBase","toChannel:"+channel);
        } else {
            if (this.delegateListener != null)
                this.delegateListener.channelFail(this, new ChannelFailEventArgs(result));
        }
    }

    protected String onChannelHandle(int channel) {
        String result = "no concrete channel handler";
        Log.e("TVPlayerBase", "onChannelHandle:" + channel);
        return result;
    }

    @Override
    public void toPreChannel() {
        String result = this.toPreChannelHandle();
        Log.e("TVPlayerBase", "toPreChannel:" + channel);
        if (result.equals("")) {
            //非同步將頻道存至Back Store;
            this.channel = channel;
            this.getPersistManager().saveValue(SAVE_KEY_CHANNEL, this.channel + "");
            if (this.delegateListener != null)
                this.delegateListener.channelChanged(this, new ChannelChangedEventArgs(this.channel));
//        Log.e("TVPlayerBase","toChannel:"+channel);
        } else {
            if (this.delegateListener != null)
                this.delegateListener.channelFail(this, new ChannelFailEventArgs(result));
        }
    }

    protected String toPreChannelHandle() {
        String result = "no concrete pre channel handler";
        Log.e("TVPlayerBase", "toPreChannelHandle:" + channel);
        return result;
    }

    @Override
    public void toNextChannel() {
        String result = this.toNextChannelHandle();
        if (result.equals("")) {
            //非同步將頻道存至Back Store;
            this.channel = channel;
            this.getPersistManager().saveValue(SAVE_KEY_CHANNEL, this.channel + "");
            if (this.delegateListener != null)
                this.delegateListener.channelChanged(this, new ChannelChangedEventArgs(this.channel));
//        Log.e("TVPlayerBase","toChannel:"+channel);
        } else {
            if (this.delegateListener != null)
                this.delegateListener.channelFail(this, new ChannelFailEventArgs(result));
        }
    }

    protected String toNextChannelHandle() {
        String result = "no concrete next channel handler";
        Log.e("TVPlayerBase", "toNextChannelHandle:" + channel);
        return result;
    }

    @Override
    public void toFullMode() {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.FullMode));
    }

    @Override
    public void toRightMode() {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.RightMode));
    }

    @Override
    public void toBottomMode() {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.BottomMode));
    }

    @Override
    public void toFreeMode(int x, int y, int width, int height) {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.FreeMode, x, y, width, height));
    }

    @Override
    public void toPreviewMode() {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.PreviewMode));
    }

    @Override
    public void toFreePreviewMode(int x, int y, int width, int height) {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.FreeMode, x, y, width, height));
    }

    @Override
    public void toHideMode() {
        if (this.delegateListener != null)
            this.delegateListener.modeChanged(this, new ModeChangedEventArgs(TVPlayerModeType.HideMode));
    }

    @Override
    public String getChannelAddress() {
        return "";
    }
}
