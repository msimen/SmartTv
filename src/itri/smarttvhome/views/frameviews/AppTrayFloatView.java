package itri.smarttvhome.views.frameviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.bizs.AppDetail;
import itri.smarttvhome.views.AppIconView;
import itri.smarttvhome.views.FloatViewBase;
import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;

/**
 * Created by mimi on 15/1/23.
 */
public class AppTrayFloatView extends FloatViewBase {
    private int screen_width;
    private int screen_height;
    private IAppTrayViewDelegateListener mDelegateListener;
    private boolean isShow;
    private ScrollView svHost;
    private LinearLayout llHost;
    private List<AppIconView> items;
    private AppIconView selectedItem;
    private int selectedIndex;
    private PackageManager manager;
    private List<AppDetail> apps;


    public AppTrayFloatView(Context context) {
        super(context);
    }

    public AppTrayFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppTrayFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegateListener(
            IAppTrayViewDelegateListener delegateListener) {
        this.mDelegateListener = delegateListener;
    }

    public boolean isShow() {
        return this.isShow;
    }

    protected void onInit() {
        super.onInit();
        View content = this.inflate(getContext(), R.layout.apptrayfloatview, this);
        this.svHost = (ScrollView) content.findViewById(R.id.svHost);
        this.manager = this.getContext().getPackageManager();
        this.apps = new ArrayList<AppDetail>();
        this.llHost = (LinearLayout) content.findViewById(R.id.llHost);
        this.items = new ArrayList<AppIconView>();

        Point screenSize = new Point();
        ((Activity) this.getContext()).getWindowManager().getDefaultDisplay().getSize(screenSize);
        this.screen_width = screenSize.x;
        this.screen_height = screenSize.y;

        this.appRefresh();
        this.hide();
    }

    public void appRefresh() {
        Log.e("AppTrayFloatView", "AppTrayFloatView_appRefresh");
        this.selectedIndex = 0;

        this.llHost.removeAllViews();
        this.apps.clear();
        this.items.clear();
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
            aviParams.width = 150;
            aviParams.height = 70;
            aivApp.setLayoutParams(aviParams);
            Log.e("AppTrayFloatView", "aivApp_Layout");

        }

        this.itemSelected();
    }

    public void hide() {
        for (AppIconView current : items) {
            current.setVisibility(View.INVISIBLE);
        }

//        WindowManager wManager = ((Activity) this.getContext()).getWindowManager();

        if (this.isShow == true) {
//            wManager.removeView(this);
            this.removeView(this);
        }

        this.isShow = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            this.removeView(this);
            this.isShow = false;
            if (this.mDelegateListener != null)
                this.mDelegateListener.hideBack();
        }
        return false;
    }

    public void show() {
        this.isShow = true;
        for (AppIconView current : items) {
            current.setVisibility(View.VISIBLE);
        }

//        WindowManager wManager = ((Activity) this.getContext()).getWindowManager();
//        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
//        WindowManager.LayoutParams wmParams = this.getWindowParams();
//        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
//        wmParams.format = PixelFormat.RGBA_8888;
//        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
//                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
//                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
//        wmParams.width = 150;
//        wmParams.height = 900;
////        wManager.addView(this, wmParams);
//        this.addView(this, wmParams);

        WindowManager.LayoutParams wmParams = this.getWindowParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.BOTTOM;
        wmParams.width = 150;
//        wmParams.height = 350;
        int h = 80 * items.size();
        if (h > 350)
            h = 350;
        wmParams.height = h;
        this.addView(this, wmParams);
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

    public void itemActionRun(int channel, String userId, String channelAddress, int msoid, IRReceiverType receiverType) {
//        this.hide();
//        WindowManager wManager = ((Activity) this.getContext()).getWindowManager();
//        wManager.removeView(this);
        this.removeView(this);
        this.isShow = false;
        if (this.selectedItem != null) {
            this.selectedItem.setBadge("");
            this.selectedItem.getAppDetail().setBadgeNumber(0);
            if (this.mDelegateListener != null)
                this.mDelegateListener.itemActionRun();
            this.selectedItem.actionExec(channel, userId, channelAddress, msoid, receiverType);
        }
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
