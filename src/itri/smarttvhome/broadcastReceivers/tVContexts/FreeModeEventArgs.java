package itri.smarttvhome.broadcastReceivers.tVContexts;


import itri.smarttvsdk.bizs.EventArgs;

/**
 * Created by mimi on 15/3/12.
 */
public class FreeModeEventArgs extends EventArgs {
    private int x;
    private int y;
    private int width;
    private int height;

    public FreeModeEventArgs(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
