package itri.smarttvhome.views.frameviews;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by mimi on 15/1/22.
 */
public class ChannelView extends TextView {
    public ChannelView(Context context) {
        super(context);
        this.init();
    }

    public ChannelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public ChannelView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        WindowManager wManager = ((Activity) this.getContext()).getWindowManager();
        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.x = 1800;
        wmParams.y = 50;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        wManager.addView(this, wmParams);
        this.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);

        this.setVisibility(View.INVISIBLE);
    }
}
