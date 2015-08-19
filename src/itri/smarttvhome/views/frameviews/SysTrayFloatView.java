package itri.smarttvhome.views.frameviews;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.views.FloatViewBase;
import itri.smarttvhome.views.sysitemviews.AllAppItemView;
import itri.smarttvhome.views.sysitemviews.CallBackItemView;
import itri.smarttvhome.views.sysitemviews.SettingItemView;
import itri.smarttvhome.views.sysitemviews.SysItemViewBase;


/**
 * Created by mimi on 15/1/22.
 */
public class SysTrayFloatView extends FloatViewBase {
    private int screen_width;
    private int screen_height;

    private boolean isShow;
    private ScrollView svHost;
    private LinearLayout llHost;
    private List<SysItemViewBase> items;
    private SysItemViewBase selectedItem;
    private int selectedIndex;
    private boolean isFunctionRun;

    public SysTrayFloatView(Context context) {
        super(context);
    }

    public SysTrayFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SysTrayFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isFunctionRun() {
        return this.isFunctionRun;
    }

    public void setFunctionRun(boolean isFunctionRun) {
        this.isFunctionRun = isFunctionRun;
    }

    public boolean isShow() {
        return this.isShow;
    }

    @Override
    protected void onInit() {
        super.onInit();

        View content = this.inflate(getContext(), R.layout.systrayfloatview, this);
        this.svHost = (ScrollView) content.findViewById(R.id.svHost);
        this.llHost = (LinearLayout) content.findViewById(R.id.llHost);
        this.items = new ArrayList<SysItemViewBase>();
        SysItemViewBase allAppItemView = new AllAppItemView(this.getContext());
        this.llHost.addView(allAppItemView);

        LinearLayout.LayoutParams allAppParams = (LinearLayout.LayoutParams) allAppItemView.getLayoutParams();
        allAppParams.topMargin = 20;
        allAppParams.width = 100;
        allAppParams.height = 50;
        allAppItemView.setLayoutParams(allAppParams);
        this.items.add(allAppItemView);

        SysItemViewBase settingItemView = new SettingItemView(this.getContext());
        this.llHost.addView(settingItemView);
        LinearLayout.LayoutParams settingParams = (LinearLayout.LayoutParams) settingItemView.getLayoutParams();
        settingParams.topMargin = 20;
        settingParams.width = 100;
        settingParams.height = 50;
        settingItemView.setLayoutParams(settingParams);
        this.items.add(settingItemView);

        SysItemViewBase callbackItemView = new CallBackItemView(this.getContext());
        this.llHost.addView(callbackItemView);
        LinearLayout.LayoutParams callBackParams = (LinearLayout.LayoutParams) callbackItemView.getLayoutParams();
        callBackParams.topMargin = 20;
        callBackParams.width = 100;
        callBackParams.height = 50;
        callbackItemView.setLayoutParams(callBackParams);
        this.items.add(callbackItemView);

        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;

        this.hide();
        this.itemSelected();

    }

    public void hide() {
        Animation ar = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                Log.d("SysTrayFloatView", "current_hide");

//                for(SysItemViewBase current : items)
//                {
//                    LinearLayout.LayoutParams sysParams = (LinearLayout.LayoutParams) current.getLayoutParams();
//                    sysParams.width=((int)(100-100*interpolatedTime));
//                    current.setLayoutParams(sysParams);
//                    current.invalidate();
//                    Log.d("SysTrayFloatView","current_hide");
//                }
            }
        };
        ar.setDuration(500);
        this.startAnimation(ar);

        for (SysItemViewBase current : items) {
            current.setVisibility(View.INVISIBLE);
//                    LinearLayout.LayoutParams sysParams = (LinearLayout.LayoutParams) current.getLayoutParams();
//                    sysParams.width=((int)(100-100*interpolatedTime));
//                    current.setLayoutParams(sysParams);
//                    current.invalidate();
//                    Log.d("SysTrayFloatView","current_hide");
        }

        Log.d("SysTrayFloatView", "hide");
        if (this.isShow == true) {
            this.removeView(this);
        }
        this.isShow = false;
    }

    public void show() {
        this.isShow = true;

        Animation als = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {

            }
        };

        als.setDuration(500);
        this.startAnimation(als);

        for (SysItemViewBase current : items) {
            current.setVisibility(View.VISIBLE);
//                    LinearLayout.LayoutParams sysParams = (LinearLayout.LayoutParams) current.getLayoutParams();
//                    sysParams.width=((int)(100-100*interpolatedTime));
//                    current.setLayoutParams(sysParams);
//                    current.invalidate();
//                    Log.d("SysTrayFloatView","current_hide");
        }

        WindowManager.LayoutParams wmParams = this.getWindowParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.RIGHT | Gravity.BOTTOM;
        wmParams.width = 100;
        wmParams.height = 250;
        this.addView(this, wmParams);
    }

    public void toPreviousItem() {
        this.selectedIndex--;
        if (this.selectedIndex < 0)
            this.selectedIndex = this.items.size() - 1;
        this.itemSelected();
    }

    public void toNextItem() {
        this.selectedIndex++;
        if (this.selectedIndex > this.items.size() - 1)
            this.selectedIndex = 0;
        this.itemSelected();
    }

    private void itemSelected() {
        if (this.selectedItem != null)
            this.selectedItem.itemUnSelected();
        this.selectedItem = this.items.get(this.selectedIndex);
        this.selectedItem.itemSelected();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                int x = selectedItem.getLeft();
                int y = selectedItem.getTop();

                svHost.scrollTo(x, y);
            }
        });
    }

    public void itemActionRun() {
        if (this.selectedItem != null)
            this.selectedItem.actionExec();
        this.isFunctionRun = true;
        this.hide();
    }
}
