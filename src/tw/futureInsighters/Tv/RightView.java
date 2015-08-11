package tw.futureInsighters.Tv;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import itri.smarttvsdk.views.HomeAppRightView;
import tw.futureInsighters.Tv.R;

/**
 * Created by mimi on 14/12/30.
 */
public class RightView extends HomeAppRightView {
    public RightView(Context context) {
        super(context);
    }

    public RightView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RightView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        super.onInit();
        View content = this.inflate(getContext(), R.layout.rightview, this);
        this.setBackgroundColor(Color.RED);
    }
}