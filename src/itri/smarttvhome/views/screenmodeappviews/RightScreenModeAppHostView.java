package itri.smarttvhome.views.screenmodeappviews;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import tw.futureInsighters.Tv.R;


/**
 * Created by mimi on 14/12/25.
 */
public class RightScreenModeAppHostView extends ScreenModeAppHostViewBase {
    private int screen_width;
    private int screen_height;

    public RightScreenModeAppHostView(Context context) {
        super(context);
        this.init();
    }

    public RightScreenModeAppHostView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public RightScreenModeAppHostView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        View content = this.inflate(getContext(), R.layout.rightscreenmodeapphostview, this);
        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;
//        this.setBackgroundColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.setMeasuredDimension((int) (this.screen_width * 0.3), this.screen_height);
    }
}
