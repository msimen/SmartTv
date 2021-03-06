package itri.smarttvhome.views.sysviews;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.bizs.AppDetail;
import itri.smarttvsdk.bizs.MitraStarTVObject;

/**
 * Created by mimi on 14/12/26.
 */
public class AllAppFloatView extends SysViewFloatBase {
    WindowManager.LayoutParams wmParams;
    private PackageManager manager;
    private List<AppDetail> apps;
    private ListView list;
    private ArrayAdapter<AppDetail> adapter;
    private int selectedIndex;
    private View selectedView;

    public AllAppFloatView(Context context) {
        super(context);
    }

    public AllAppFloatView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AllAppFloatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onInit() {
        super.onInit();
        View content = this.inflate(getContext(), R.layout.allappview, this);
        this.loadApps();
        this.loadListView();
        this.addClickListener();
        this.setBackgroundColor(Color.WHITE);
        this.viewAttachedWindow();
    }

    private void loadApps() {
        manager = this.getContext().getPackageManager();
        apps = new ArrayList<AppDetail>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
        for (ResolveInfo ri : availableActivities) {
            AppDetail app = new AppDetail(getContext());
            app.setLabel(ri.loadLabel(manager));
            app.setName(ri.activityInfo.packageName);
            app.setIcon(ri.activityInfo.loadIcon(manager));
            this.apps.add(app);
        }
    }

    private void loadListView() {
        this.list = (ListView) findViewById(R.id.apps_list);

        this.adapter = new ArrayAdapter<AppDetail>(this.getContext(), R.layout.list_item, apps) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService
                            (Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.list_item, null);
                }

                ImageView appIcon = (ImageView) convertView.findViewById(R.id.item_app_icon);
                appIcon.setImageDrawable(apps.get(position).getIcon());

                TextView appLabel = (TextView) convertView.findViewById(R.id.item_app_label);
                appLabel.setText(apps.get(position).getLabel());

                TextView appName = (TextView) convertView.findViewById(R.id.item_app_name);
                appName.setText(apps.get(position).getName());
                apps.get(position).setPresentView(convertView);
                return convertView;
            }
        };

        this.list.setAdapter(this.adapter);
    }

    private void viewAttachedWindow() {
        this.wmParams = this.getWindowParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.RIGHT | Gravity.TOP;
        wmParams.width = 300;
        this.addView(this, wmParams);
    }

    private void addClickListener() {
        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                Intent i = manager.getLaunchIntentForPackage(apps.get(pos).getName().toString());
                AllAppFloatView.this.getContext().startActivity(i);
            }
        });
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
//        this.itemSelected();
//    }

    @Override
    protected void onUpClick() {
        if (this.selectedIndex > 0) {
            this.selectedIndex--;
            this.itemSelected();
        }
    }

    @Override
    protected void onDownClick() {
        if (this.selectedIndex < this.apps.size() - 1) {
            this.selectedIndex++;
            this.itemSelected();
        }
    }

    @Override
    protected void onOkClick() {
        this.removeView(this);
        MitraStarTVObject tVObject = new MitraStarTVObject(this.getContext(), 0, 0, 0);
        tVObject.toHideMode();
        this.apps.get(this.selectedIndex).execAction();
        if (this.mDelegateListener != null)
            this.mDelegateListener.disposeEvent(this, null);
    }

    @Override
    protected void onBackClick() {
        this.removeView(this);
        if (this.mDelegateListener != null)
            this.mDelegateListener.disposeEvent(this, null);
    }

    private void itemSelected() {
        if (this.selectedView != null)
            this.selectedView.setBackgroundColor(Color.WHITE);
        this.list.setSelection(this.selectedIndex);
        this.apps.get(this.selectedIndex).itemSelected();
        this.selectedView = this.apps.get(this.selectedIndex).getPresentView();
    }
}
