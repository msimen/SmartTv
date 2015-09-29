package tw.futureInsighters.Tv.views;


import java.util.List;

import tw.futureInsighters.Tv.R;
import itri.smarttvsdk.views.HomeAppBottomView;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by mimi on 14/12/30.
 */
public class BottomView extends HomeAppBottomView {
	private HorizontalScrollView appsLayout;
	
    public BottomView(Context context) {
        super(context);
    }

    public BottomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        super.onInit();
        View content = this.inflate(getContext(), R.layout.bottomview, this);
        this.setBackgroundColor(Color.TRANSPARENT);
        
        new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				appsLayout = (HorizontalScrollView) findViewById(R.id.appsLayout);
				final LinearLayout timeLayout = (LinearLayout) findViewById(R.id.timeLayout);
				
				appsLayout.setTranslationY(450);
				appsLayout.animate().translationY(0);
				
				timeLayout.setTranslationX(1280);
				timeLayout.animate().translationX(0);
			}
		}, 150);
        
    }
    
}