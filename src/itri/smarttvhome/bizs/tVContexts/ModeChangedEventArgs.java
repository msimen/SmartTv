package itri.smarttvhome.bizs.tVContexts;

import itri.smarttvsdk.bizs.EventArgs;

/**
 * Created by mimi on 15/3/12.
 */
public class ModeChangedEventArgs extends EventArgs {
    private TVPlayerModeType modeType;
    private int x;
    private int y;
    private int width;
    private int height;

    public ModeChangedEventArgs(TVPlayerModeType modeType) {
        this.modeType = modeType;
    }

    public ModeChangedEventArgs(TVPlayerModeType modeType, int x, int y, int width, int height) {
        this.modeType = modeType;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public TVPlayerModeType getModeType() {
        return this.modeType;
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