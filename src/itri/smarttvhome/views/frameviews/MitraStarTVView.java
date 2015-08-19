package itri.smarttvhome.views.frameviews;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import itri.smarttvsdk.bizs.MitraStarTVObject;

/**
 * Created by mimi on 15/1/21.
 */
public class MitraStarTVView extends View {
    private int screen_width;
    private int screen_height;
    private MitraStarTVObject tVObject;

    public MitraStarTVView(Context context) {
        super(context);
        this.init();
    }

    public MitraStarTVView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public MitraStarTVView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;

        this.tVObject = new MitraStarTVObject(this.getContext(), this.screen_width, this.screen_height, 2000);
        this.tVObject.toHideMode();
//        this.toFullMode();


    }

    public void toFullMode() {
        Log.e("MitraStarTVView", "toFullMode");
        this.tVObject.toFullMode();
    }

    public void toPreviewMode() {
        Log.e("MitraStarTVView", "toPreviewMode");
        this.tVObject.toPreviewMode();
    }

    public void toRightMode() {
        Log.e("MitraStarTVView", "toRightMode");
        this.tVObject.toRightMode();
    }

    public void toBottomMode() {
        Log.e("MitraStarTVView", "toBottomMode");
        this.tVObject.toBottomMode();
    }

    public void toHideMode() {
        Log.e("MitraStarTVView", "toHideMode");
        this.tVObject.toHideMode();
    }
}
