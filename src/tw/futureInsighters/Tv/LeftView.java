package tw.futureInsighters.Tv;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import itri.smarttvsdk.views.HomeAppLeftView;
import itri.smarttvsdk.views.HomeAppRightView;
import tw.futureInsighters.Tv.R;

/**
 * Created by mimi on 14/12/30.
 */
public class LeftView extends HomeAppLeftView {
    public LeftView(Context context) {
        super(context);
    }

    public LeftView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        super.onInit();
        View content = this.inflate(getContext(), R.layout.leftview, this);
        this.setBackgroundColor(Color.BLACK);
    }
}