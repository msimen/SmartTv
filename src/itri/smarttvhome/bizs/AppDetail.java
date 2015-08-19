package itri.smarttvhome.bizs;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import itri.smarttvsdk.bizs.tVContexts.IRReceiverType;
import itri.smarttvsdk.defines.IntentApp;

/**
 * Created by mimi on 14/12/26.
 */
public class AppDetail {
    private PackageManager manager;
    private Context mContext;
    private CharSequence label;
    private CharSequence name;
    private Drawable icon;
    private View presentView;
    private int badgeNumber;

    public AppDetail(Context ctx) {
        this.mContext = ctx;
    }

    public int getBadgeNumber() {
        return this.badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public CharSequence getLabel() {
        return label;
    }

    public void setLabel(CharSequence label) {
        this.label = label;
    }

    public CharSequence getName() {
        return name;
    }

    public void setName(CharSequence name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public View getPresentView() {
        return this.presentView;
    }

    public void setPresentView(View presentView) {
        this.presentView = presentView;
    }

    public void itemSelected() {
        if (this.presentView != null) {
            this.presentView.setBackgroundColor(Color.CYAN);
        }
    }

    public void execAction() {
        Intent i = this.mContext.getPackageManager().getLaunchIntentForPackage(name.toString());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.mContext.startActivity(i);
    }

    public void execAction(String badgeNumber, int channel, String userId, String channelAddress, int msoid, IRReceiverType receiverType) {
        Intent i = this.mContext.getPackageManager().getLaunchIntentForPackage(name.toString());
        if (badgeNumber.matches("-?\\d+(.\\d+)?")) {
            i.putExtra(IntentApp.NUMBER_KEY, badgeNumber);
        } else {
            i.putExtra(IntentApp.NUMBER_KEY, "0");
        }


        i.putExtra(IntentApp.CHANNEL_KEY, channel);
        i.putExtra(IntentApp.USERID_KEY, userId);
        i.putExtra(IntentApp.CHANNELADDRESS_KEY, channelAddress);
        Bundle args = new Bundle();
//        args.putSerializable(IntentApp.MSOID_KEY, msoid);
        args.putSerializable(IntentApp.IRRECEIVERTYPE_KEY, receiverType);
        i.putExtras(args);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.mContext.startActivity(i);
    }
}
