package tw.futureInsighters.Tv;

import itri.smarttvsdk.views.HomeAppRightView;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

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
        
        new Handler().postDelayed(new Runnable() {
        	  @Override
        	  public void run() {
        		  final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
        		  notificationWrapper.setAlpha(0.0f);
        	  }
        	}
        , 4000);
        
    }
}