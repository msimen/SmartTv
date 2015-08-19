package itri.smarttvhome.bizs.tVContexts.tVPlayer.HDMI.MitraStar;

import android.app.Activity;
import android.util.Log;
import android.widget.RelativeLayout;

import itri.smarttvhome.bizs.tVContexts.tVPlayer.TVPlayerBase;
import itri.smarttvsdk.bizs.MitraStarTVObject;

/**
 * Created by mimi on 15/3/12.
 */
public class MitraStarTVPlayer extends TVPlayerBase {
    private Activity host;
    private MitraStarTVObject tVObject;

    public MitraStarTVPlayer(Activity host, RelativeLayout layout) {
        super(host, layout);
        this.host = host;
        this.init();
    }

    private void init() {
        this.tVObject = new MitraStarTVObject(this.host, this.screen_width, this.screen_height, 2000);
        this.tVObject.toHideMode();
    }

    @Override
    protected String onChannelHandle(int channel) {
        String result = "";
        Log.e("MitraStarTVPlayer", "onChannelHandle");
        return result;
    }

    @Override
    public void toFullMode() {
        super.toFullMode();
        Log.e("MitraStarTVPlayer", "toFullMode");
        this.tVObject.toFullMode();
    }

    @Override
    public void toRightMode() {
        super.toRightMode();
        Log.e("MitraStarTVPlayer", "toRightMode");
        this.tVObject.toRightMode();
    }

    @Override
    public void toBottomMode() {
        super.toBottomMode();
        Log.e("MitraStarTVPlayer", "toBottomMode");
        this.tVObject.toBottomMode();
    }

    @Override
    public void toFreeMode(int x, int y, int width, int height) {
        super.toFreeMode(x, y, width, height);
        Log.e("MitraStarTVPlayer", "toFreeMode");
    }

    @Override
    public void toPreviewMode() {
        super.toPreviewMode();
        Log.e("MitraStarTVPlayer", "toPreviewMode");
        this.tVObject.toPreviewMode();
    }

    @Override
    public void toFreePreviewMode(int x, int y, int width, int height) {
        super.toFreePreviewMode(x, y, width, height);
        Log.e("MitraStarTVPlayer", "toFreePreviewMode");
    }

    @Override
    public void toHideMode() {
        super.toHideMode();
        Log.e("MitraStarTVPlayer", "toHideMode");
        this.tVObject.toHideMode();
    }
}
