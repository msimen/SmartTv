package tw.futureInsighters.Tv.views;

import tw.futureInsighters.Tv.R;
import itri.smarttvsdk.views.HomeAppRightView;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
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
        
        final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
		
        notificationWrapper.setTranslationX(700);
		notificationWrapper.animate().translationX(0);
        
        new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
      		  	if(notificationWrapper== null) return; // crash protection...
				notificationWrapper.animate().translationX(700);

			}
		}, 7000);
        
//        new Handler().postDelayed(new Runnable() {
//        	  @Override
//        	  public void run() {
//        		  final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
//        		  notificationWrapper.setAlpha(0.8f);
//        	  }
//        	}
//        , 7000);
//        new Handler().postDelayed(new Runnable() {
//      	  @Override
//      	  public void run() {
//      		  final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
//      		  notificationWrapper.setAlpha(0.5f);
//      	  }
//      	}
//      , 7300);
//        new Handler().postDelayed(new Runnable() {
//      	  @Override
//      	  public void run() {
//      		  final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
//      		  notificationWrapper.setAlpha(0.2f);
//      	  }
//      	}
//      , 7600);
//        new Handler().postDelayed(new Runnable() {
//        	  @Override
//        	  public void run() {
//        		  final LinearLayout notificationWrapper = (LinearLayout) findViewById(R.id.notificationWrapper);
//        		  notificationWrapper.setAlpha(0.0f);
//        	  }
//        	}
//        , 7900);
        
    }
}