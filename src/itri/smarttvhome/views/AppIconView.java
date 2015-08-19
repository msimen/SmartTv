package itri.smarttvhome.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import tw.futureInsighters.Tv.R;
import itri.smarttvhome.bizs.AppDetail;
import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;


/**
 * Created by mimi on 14/12/30.
 */
public class AppIconView extends RelativeLayout {
    private ImageView appIcon;
    private TextView appLabel;
    private TextView badge;
    private AppDetail appDetail;
    private boolean isSelected;

    public AppIconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.viewInit();
    }

    public AppIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.viewInit();
    }

    public AppIconView(Context context) {
        super(context);
        this.viewInit();
    }

    private void viewInit() {
        Button contentHost = new Button(this.getContext());
        this.appIcon = new ImageView(this.getContext());
        LayoutParams pmsAppIcon = new LayoutParams(
                0, 0);
        this.appIcon.setId(1);
        this.addView(this.appIcon, pmsAppIcon);
        this.badge = new TextView(this.getContext());
        LayoutParams pmsBadge = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        pmsBadge.addRule(RelativeLayout.ALIGN_RIGHT, this.appIcon.getId());
        pmsBadge.addRule(RelativeLayout.ALIGN_TOP, this.appIcon.getId());
        this.badge.setId(3);
        this.badge.setTextColor(Color.RED);
        this.badge.setTextSize(16);
        this.addView(this.badge, pmsBadge);

        this.appLabel = new TextView(this.getContext());
        LayoutParams pmsAppLabel = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        pmsAppLabel.addRule(RelativeLayout.BELOW, this.appIcon.getId());
        this.appLabel.setId(2);
        this.addView(this.appLabel, pmsAppLabel);
//        this.appLabel.setTextColor(Color.BLACK);
        this.appLabel.setTextColor(Color.YELLOW);
        this.appLabel.setTextSize(18);

        this.setBackgroundResource(R.drawable.item_normal);
        this.setPadding(10, 10, 10, 10);

    }

    public AppDetail getAppDetail() {
        return this.appDetail;
    }

    public void setAppDetail(AppDetail appDetail) {
        this.appDetail = appDetail;
        this.appIcon.setImageDrawable(appDetail.getIcon());
        this.appLabel.setText(appDetail.getLabel());
    }

    public void setBadge(String number) {
        this.badge.setText(number);
    }

    public void actionExec(int channel, String userId, String channelAddress, int msoid, IRReceiverType receiverType) {
        Log.e("AppIconView", "BadgeNumber:" + this.badge.getText().toString());
        getAppDetail().execAction(this.badge.getText().toString(), channel, userId, channelAddress, msoid, receiverType);
    }

    public void itemSelected() {
        this.isSelected = true;
        this.setBackgroundResource(R.drawable.item_selected);
    }

    public void itemUnSelected() {
        this.isSelected = false;
        this.setBackgroundResource(R.drawable.item_normal);
    }
}