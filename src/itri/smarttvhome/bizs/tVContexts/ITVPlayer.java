package itri.smarttvhome.bizs.tVContexts;

/**
 * Created by mimi on 15/3/12.
 */
public interface ITVPlayer {
    public ITVPlayerDelegateListener getDelegateListener();

    public void setDelegateListener(ITVPlayerDelegateListener delegateListener);

    public int getChannel();

    public void toChannel(int channel);

    public void toPreChannel();

    public void toNextChannel();

    public void toFullMode();

    public void toRightMode();

    public void toBottomMode();

    public void toFreeMode(int x, int y, int width, int height);

    public void toPreviewMode();

    public void toFreePreviewMode(int x, int y, int width, int height);

    public void toHideMode();

    public String getChannelAddress();

}
