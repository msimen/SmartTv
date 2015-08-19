package itri.smarttvhome.views;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import itri.smarttvhome.bizs.AppDetail;
import itri.smarttvhome.interfaces.IItriAppChanged;

/**
 * Created by mimi on 14/12/30.
 */
public class ItriAppListView extends LinearLayout implements IItriAppChanged {

    private PackageManager manager;
    private List<AppDetail> apps;
    private List<AppIconView> appIconViews;

    public ItriAppListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.viewInit();
    }

    public ItriAppListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.viewInit();
    }

    public ItriAppListView(Context context) {
        super(context);
        this.viewInit();
    }

    private void viewInit() {
        this.appIconViews = new ArrayList<AppIconView>();
        this.appRefersh();
    }

    public void appRefersh() {
        this.manager = this.getContext().getPackageManager();
        this.apps = new ArrayList<AppDetail>();
        this.appIconViews.clear();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        i.addCategory(" itri.smarttvhome.intent.category.ACTIVITY");

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(
                i, 0);
        for (ResolveInfo ri : availableActivities) {
            AppDetail app = new AppDetail(this.getContext());
            app.setLabel(ri.loadLabel(manager));
            app.setName(ri.activityInfo.packageName);
            app.setIcon(ri.activityInfo.loadIcon(manager));
            apps.add(app);
        }

        this.removeAllViews();
        for (AppDetail ad : apps) {
            AppIconView aivApp = new AppIconView(this.getContext());
            aivApp.setTag(ad.getName());
            aivApp.setAppDetail(ad);
            // aivApp.setBadge("3");
            aivApp.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent i = manager.getLaunchIntentForPackage(arg0.getTag()
                            .toString());
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    ItriAppListView.this.getContext().startActivity(i);
                }
            });
            this.addView(aivApp);
            this.appIconViews.add(aivApp);
        }
        Button btnAll = new Button(this.getContext());
        btnAll.setText("All");
        btnAll.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
//            Intent i = new Intent(ItriAppListView.this.getContext(),
//                    AppsListActivity.class);
//            ItriAppListView.this.getContext().startActivity(i);
            }
        });
        this.addView(btnAll);
    }

    public void setBadge(String packageName, String number) {
        for (AppIconView current : this.appIconViews) {
            if (current.getAppDetail().getName().equals(packageName) == true)
                current.setBadge(number);
        }
    }

}
