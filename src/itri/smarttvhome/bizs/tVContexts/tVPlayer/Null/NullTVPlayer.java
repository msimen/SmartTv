package itri.smarttvhome.bizs.tVContexts.tVPlayer.Null;

import android.app.Activity;
import android.util.Log;
import android.widget.RelativeLayout;

import itri.smarttvhome.bizs.tVContexts.tVPlayer.TVPlayerBase;

/**
 * Created by mimi on 15/3/12.
 */
public class NullTVPlayer extends TVPlayerBase {
    public NullTVPlayer(Activity host, RelativeLayout layout) {
        super(host, layout);
    }

    @Override
    public void toFullMode() {
        super.toFullMode();
        Log.e("NullTVPlayer", "toFullMode");
    }

    @Override
    public void toRightMode() {
        super.toRightMode();
        Log.e("NullTVPlayer", "toRightMode");
    }

    @Override
    public void toBottomMode() {
        super.toBottomMode();
        Log.e("NullTVPlayer", "toBottomMode");
    }

    @Override
    public void toFreeMode(int x, int y, int width, int height) {
        super.toFreeMode(x, y, width, height);
        Log.e("NullTVPlayer", "toFreeMode");
    }

    @Override
    public void toPreviewMode() {
        super.toPreviewMode();
        Log.e("NullTVPlayer", "toPreviewMode");
    }

    @Override
    public void toFreePreviewMode(int x, int y, int width, int height) {
        super.toFreePreviewMode(x, y, width, height);
        Log.e("NullTVPlayer", "toFreePreviewMode");
    }

    @Override
    public void toHideMode() {
        super.toHideMode();
        Log.e("NullTVPlayer", "toHideMode");
    }
}
