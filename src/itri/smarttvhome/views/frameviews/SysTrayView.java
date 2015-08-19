package itri.smarttvhome.views.frameviews;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.views.sysitemviews.AllAppItemView;
import itri.smarttvhome.views.sysitemviews.CallBackItemView;
import itri.smarttvhome.views.sysitemviews.SettingItemView;
import itri.smarttvhome.views.sysitemviews.SysItemViewBase;

/**
 * Created by mimi on 14/12/24.
 */
public class SysTrayView extends RelativeLayout {
    private boolean isShow;
    private ScrollView svHost;
    private LinearLayout llHost;
    private List<SysItemViewBase> items;
    private SysItemViewBase selectedItem;
    private int selectedIndex;

    public SysTrayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public SysTrayView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    public boolean isShow() {
        return this.isShow;
    }

    private void init() {
        View content = this.inflate(getContext(), R.layout.apptrayview, this);
        this.svHost = (ScrollView) content.findViewById(R.id.svHost);
        this.llHost = (LinearLayout) content.findViewById(R.id.llHost);
        this.items = new ArrayList<SysItemViewBase>();

        SysItemViewBase allAppItemView = new AllAppItemView(this.getContext());
        this.llHost.addView(allAppItemView);
        LinearLayout.LayoutParams allAppParams = (LinearLayout.LayoutParams) allAppItemView.getLayoutParams();
        allAppParams.topMargin = 20;
        allAppItemView.setLayoutParams(allAppParams);
        this.items.add(allAppItemView);

        SysItemViewBase settingItemView = new SettingItemView(this.getContext());
        this.llHost.addView(settingItemView);
        LinearLayout.LayoutParams settingParams = (LinearLayout.LayoutParams) settingItemView.getLayoutParams();
        settingParams.topMargin = 20;
        settingItemView.setLayoutParams(settingParams);
        this.items.add(settingItemView);

        SysItemViewBase callbackItemView = new CallBackItemView(this.getContext());
        this.llHost.addView(callbackItemView);
        LinearLayout.LayoutParams callBackParams = (LinearLayout.LayoutParams) callbackItemView.getLayoutParams();
        callBackParams.topMargin = 20;
        callbackItemView.setLayoutParams(callBackParams);
        this.items.add(callbackItemView);

        this.itemSelected();
    }

    public void hide() {
        this.isShow = false;
        final int newRightMargin = -this.getHeight();
        Animation ar = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                LayoutParams params = (LayoutParams) SysTrayView.this.getLayoutParams();
                params.rightMargin = (int) (newRightMargin * interpolatedTime);
                SysTrayView.this.setLayoutParams(params);
            }
        };

        ar.setDuration(500);
        this.startAnimation(ar);
    }

    public void show() {
        this.isShow = true;
        final int newRightMargin = -300;
        LayoutParams params = (LayoutParams) this.getLayoutParams();
        params.rightMargin = -199;
        this.setLayoutParams(params);
        Animation als = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                LayoutParams params = (LayoutParams) SysTrayView.this.getLayoutParams();
                params.rightMargin = newRightMargin - (int) (newRightMargin * interpolatedTime);
                SysTrayView.this.setLayoutParams(params);
            }
        };

        als.setDuration(500);
        this.startAnimation(als);
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //3 item=210
        this.setMeasuredDimension(200, items.size() * 70 + 20);
    }

    public void itemActionRun() {
        if (this.selectedItem != null)
            this.selectedItem.actionExec();
        this.hide();
    }
}
