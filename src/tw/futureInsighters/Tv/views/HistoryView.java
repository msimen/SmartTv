package tw.futureInsighters.Tv.views;

import tw.futureInsighters.Tv.R;
import itri.smarttvsdk.views.HomeAppFullView;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;

/**
 * Created by mimi on 15/3/25.
 */
public class HistoryView extends HomeAppFullView {
	private DrawerLayout drawerLayout;

	public HistoryView(Context context) {
		super(context);
	}

	public HistoryView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HistoryView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onInit() {
		super.onInit();
		View content = this.inflate(getContext(), R.layout.fullview, this);
		this.setBackgroundColor(Color.TRANSPARENT);

		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		new android.os.Handler().postDelayed(new Runnable() {
			public void run() {
				drawerLayout.openDrawer(Gravity.END);
			}
		}, 300);

	}
}