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
public class NotificationView extends HomeAppRightView {
    public NotificationView(Context context) {
        super(context);
    }

    public NotificationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NotificationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        super.onInit();
        View content = this.inflate(getContext(), R.layout.notificationview, this);
        this.setBackgroundColor(Color.TRANSPARENT);
        
    }
}