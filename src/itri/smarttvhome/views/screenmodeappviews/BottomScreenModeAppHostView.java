package itri.smarttvhome.views.screenmodeappviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import tw.futureInsighters.Tv.R;


/**
 * Created by mimi on 14/12/25.
 */
public class BottomScreenModeAppHostView extends ScreenModeAppHostViewBase {
    public BottomScreenModeAppHostView(Context context) {
        super(context);
        this.init();
    }

    public BottomScreenModeAppHostView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public BottomScreenModeAppHostView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        View content = this.inflate(getContext(), R.layout.bottomscreenmodeapphostview, this);
//        this.setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //3 item=210
        this.setMeasuredDimension(this.screen_width, ((int) (this.screen_height -
                this.screen_height * 0.7)));
    }
}
