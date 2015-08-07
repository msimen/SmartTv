package itri.smarttvsdk.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Created by mimi on 14/12/27.
 */
public abstract class HomeAppViewBase extends RelativeLayout {
    protected WindowManager.LayoutParams wmParams;
    protected int screen_width;
    protected int screen_height;

    public HomeAppViewBase(Context context) {
        super(context);
        this.init();
    }

    public HomeAppViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public HomeAppViewBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        this.onInit();
        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;
    }

    protected void onInit() {

    }
}
