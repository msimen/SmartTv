package itri.smarttvhome.views.screenmodeappviews;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import itri.smarttvhome.views.sysviews.SysViewBase;


/**
 * Created by mimi on 14/12/26.
 */
public abstract class ScreenModeAppHostViewBase extends RelativeLayout {
    protected int screen_width;
    protected int screen_height;

    public ScreenModeAppHostViewBase(Context context) {
        super(context);
        this.init();
    }

    public ScreenModeAppHostViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public ScreenModeAppHostViewBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;
    }

    public void addSysView(SysViewBase view) {
        super.addView(view);
    }

    public void addView(SysViewBase view) {

    }
}
