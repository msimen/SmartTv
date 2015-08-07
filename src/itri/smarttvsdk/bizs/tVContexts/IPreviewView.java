package itri.smarttvsdk.bizs.tVContexts;

/**
 * Created by mimi on 15/3/23.
 */
public interface IPreviewView {
    public void bringToFront();
    public void setLayout(int x, int y, int width, int height);
    public void channelChange(String channel);
}
