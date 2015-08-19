package itri.smarttvhome.views.screenmodeappviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import tw.futureInsighters.Tv.R;

/**
 * Created by mimi on 14/12/25.
 */
public class FullScreenModeAppHostView extends ScreenModeAppHostViewBase {
    private int screen_width;
    private int screen_height;

    public FullScreenModeAppHostView(Context context) {
        super(context);
        this.init();
    }

    public FullScreenModeAppHostView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public FullScreenModeAppHostView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    private void init() {
        View content = this.inflate(getContext(), R.layout.fullscreenmodeapphostview, this);
//        this.setBackgroundColor(Color.BLUE);
    }
}
