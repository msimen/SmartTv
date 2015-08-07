package itri.smarttvsdk.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import tw.futureInsighters.Tv_bad.R;


/**
 * Created by mimi on 14/12/27.
 */
public class HomeAppLeftView extends HomeAppViewBase {
    public HomeAppLeftView(Context context) {
        super(context);
    }

    public HomeAppLeftView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeAppLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        View content = this.inflate(getContext(), R.layout.homeappleftview, this);
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        this.setMeasuredDimension((int) (this.screen_width * 0.3), this.screen_height);

        this.setMeasuredDimension((int) (this.screen_width * 0.3), this.screen_height);
    }
}
