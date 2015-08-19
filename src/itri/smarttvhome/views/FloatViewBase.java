package itri.smarttvhome.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * Created by mimi on 15/2/3.
 */
public abstract class FloatViewBase extends RelativeLayout {
    private WindowManager windowManager;
    private boolean isAdd;
    public FloatViewBase(Context context) {
        super(context);
        this.onInit();
    }

    public FloatViewBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.onInit();
    }

    public FloatViewBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.onInit();
    }

    public WindowManager getWindowManager() {
        if (this.windowManager == null)
            this.windowManager = ((Activity) this.getContext()).getWindowManager();
        return this.windowManager;
    }

    public WindowManager.LayoutParams getWindowParams() {
        return new WindowManager.LayoutParams();
    }

    public WindowManager.LayoutParams getRightWindowParams() {
        return new WindowManager.LayoutParams();
    }

    public void removeView(View view) {
//        this.getWindowManager().removeView(view);
        if(this.isAdd==true) {
            this.getWindowManager().removeViewImmediate(view);
            this.isAdd = false;
        }
    }

    public void addView(View view, WindowManager.LayoutParams wmParams) {
//        this.getWindowManager().removeViewImmediate(view);
        if(this.isAdd==false) {
            this.getWindowManager().addView(this, wmParams);
            this.isAdd = true;
        }
    }

    protected void onInit() {

    }
}
