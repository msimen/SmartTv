package itri.smarttvsdk.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import tw.futureInsighters.Tv_bad.R;

/**
 * Created by mimi on 14/12/27.
 */
public class HomeAppFullView extends HomeAppViewBase {
    public HomeAppFullView(Context context) {
        super(context);
    }

    public HomeAppFullView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeAppFullView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        View content = this.inflate(getContext(), R.layout.homeappfullview, this);
        this.setBackgroundColor(Color.TRANSPARENT);
//        WindowManager wm = (WindowManager) this.getContext().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
//
//        this.wmParams = new WindowManager.LayoutParams();
//        this.wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
//        this.wmParams.format = PixelFormat.RGBA_8888;
//        this.wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//        this.wmParams.gravity = Gravity.LEFT | Gravity.TOP;
//
//        this.wmParams.width = screen_width / 3;
//        this.wmParams.height = screen_height / 3;
//        this.wmParams.x = screen_width / 3 * 2 - (screen_width / 3 * 2) / 20;
//        this.wmParams.y = screen_height / 3 * 2 - (screen_height / 3 * 2) / 20;
//        wm.addView(this, wmParams);
    }
}
