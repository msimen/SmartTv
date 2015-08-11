package itri.smarttvsdk.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import tw.futureInsighters.Tv.R;


/**
 * Created by mimi on 14/12/27.
 */
public class HomeAppBottomView extends HomeAppViewBase {
    public HomeAppBottomView(Context context) {
        super(context);
    }

    public HomeAppBottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeAppBottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        View content = this.inflate(getContext(), R.layout.homeappbottomview, this);
        this.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.setMeasuredDimension(this.screen_width, ((int) (this.screen_height -
                this.screen_height * 0.5)));
    }
}
