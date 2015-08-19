package itri.smarttvhome.views.frameviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
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
import itri.smarttvhome.bizs.AppDetail;
import itri.smarttvhome.views.AppIconView;
import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;

/**
 * Created by mimi on 14/12/24.
 */
public class AppTrayView extends RelativeLayout {
    protected int screen_width;
    protected int screen_height;
    private IAppTrayViewDelegateListener mDelegateListener;
    private boolean isShow;
    private ScrollView svHost;
    private LinearLayout llHost;
    private List<AppIconView> items;
    private AppIconView selectedItem;
    private int selectedIndex;
    private PackageManager manager;
    private List<AppDetail> apps;

    public AppTrayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public AppTrayView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    public void setDelegateListener(
            IAppTrayViewDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    public boolean isShow() {
        return this.isShow;
    }

    private void init() {
        View content = this.inflate(getContext(), R.layout.apptrayview, this);
        this.svHost = (ScrollView) content.findViewById(R.id.svHost);
        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;
        this.appRefresh();
    }

    public void appRefresh() {
        this.selectedIndex = 0;
        View content = this.inflate(getContext(), R.layout.apptrayview, this);
        this.manager = this.getContext().getPackageManager();
        this.apps = new ArrayList<AppDetail>();
        this.llHost = (LinearLayout) content.findViewById(R.id.llHost);
        this.llHost.removeAllViews();
        this.items = new ArrayList<AppIconView>();
        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        i.addCategory("itri.smarttvhome.category.ACTIVITY");

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(
                i, 0);
        for (ResolveInfo ri : availableActivities) {
            AppDetail app = new AppDetail(this.getContext());
            app.setLabel(ri.loadLabel(manager));
            app.setName(ri.activityInfo.packageName);
            app.setIcon(ri.activityInfo.loadIcon(manager));

            apps.add(app);
        }

        for (AppDetail ad : apps) {
            AppIconView aivApp = new AppIconView(this.getContext());
            aivApp.setTag(ad.getName());
            aivApp.setAppDetail(ad);
            this.items.add(aivApp);
            this.llHost.addView(aivApp);
            LinearLayout.LayoutParams aviParams = (LinearLayout.LayoutParams) aivApp.getLayoutParams();
            aviParams.topMargin = 20;
            aivApp.setLayoutParams(aviParams);

        }

        this.itemSelected();
    }

    public void hide() {
        this.isShow = false;
        final int newLeftMargin = -300;
        Animation al = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                LayoutParams params = (LayoutParams) AppTrayView.this.getLayoutParams();
                params.leftMargin = (int) (newLeftMargin * interpolatedTime);
                AppTrayView.this.setLayoutParams(params);
            }
        };

        al.setDuration(500);
        this.startAnimation(al);

        if (this.mDelegateListener != null)
            this.mDelegateListener.hideBack();
    }

    public void show() {
        this.isShow = true;
        final int newLeftMargin = -180;
        LayoutParams params = (LayoutParams) this.getLayoutParams();
        params.leftMargin = -129;
        this.setLayoutParams(params);
        Animation als = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                LayoutParams params = (LayoutParams) AppTrayView.this.getLayoutParams();
                params.leftMargin = newLeftMargin - (int) (newLeftMargin * interpolatedTime);
                AppTrayView.this.setLayoutParams(params);
            }
        };

        als.setDuration(500);
        this.startAnimation(als);
        if (this.mDelegateListener != null)
            this.mDelegateListener.showBack();
    }

    public void toPreviousItem() {
        if (this.selectedIndex > 0) {
            this.selectedIndex--;
            this.itemSelected();
        }
    }

    public void toNextItem() {
        if (this.selectedIndex < this.items.size() - 1) {
            this.selectedIndex++;
            this.itemSelected();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = 0;
        for (AppIconView current : items) {
            height += current.getHeight();
        }

        height += 20;

        if (height > this.screen_height - 20)
            height = this.screen_height - 20;
        this.setMeasuredDimension(200, height);
        // this.setMeasuredDimension(200, height+ 20);
    }

    public void itemActionRun(int channel, String userId, String channelAddress, int msoid, IRReceiverType receiverType) {
        if (this.selectedItem != null) {
            this.selectedItem.setBadge("");
            this.selectedItem.getAppDetail().setBadgeNumber(0);
            this.selectedItem.actionExec(channel, userId, channelAddress, msoid, receiverType);
            if (this.mDelegateListener != null)
                this.mDelegateListener.itemActionRun();
        }

        this.hide();
    }

    private void itemSelected() {
        if (this.items.size() == 0)
            return;
        if (this.selectedItem != null)
            this.selectedItem.itemUnSelected();
        this.selectedItem = this.items.get(this.selectedIndex);
        if (this.selectedItem == null)
            return;
        this.selectedItem.itemSelected();
//        if (this.selectedIndex + 1 > 6) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                int x = selectedItem.getLeft();
                int y = selectedItem.getTop();

                //67æ¯�Itemé«˜åº¦,6 å‰� 6ç­†ä¸�å‹•,20 ç¬¬ä¸€ç­†ä¸Šé�¢é‚Šç•Œå€¼
//                    int movePy = 67 * 6 + 20;
//                    svHost.scrollTo(x, y - movePy);
                svHost.scrollTo(x, y);
            }
        });
//        }
    }

    public void setBadge(String packageName, int number) {
        for (AppIconView current : items) {
            if (current.getAppDetail().getName().equals(packageName)) {
                if (number > 0) {
                    current.setBadge(number + "");
                    current.getAppDetail().setBadgeNumber(number);
                } else {
                    current.setBadge("");
                    current.getAppDetail().setBadgeNumber(0);
                }
            }
        }
    }

    public int getTotalBadgeNumber() {
        int result = 0;
        for (AppIconView current : items) {
            result += current.getAppDetail().getBadgeNumber();
        }
        return result;
    }
}
