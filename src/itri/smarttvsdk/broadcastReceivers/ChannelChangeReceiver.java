package itri.smarttvsdk.broadcastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import itri.smarttvsdk.bizs.TipStatus;
import itri.smarttvsdk.bizs.tVContexts.ProgramProviderType;
import itri.smarttvsdk.broadcastSenders.TipStatusChangeBroadcastSender;
import itri.smarttvsdk.defines.IntentApp;

/**
 * Created by mimi on 15/3/13.
 */
public class ChannelChangeReceiver extends BroadcastReceiver {
    protected  Context mContext;
    private int channelNumber;
    private String userId;
    private ProgramProviderType programProvider;

    public int getChannelNumber() {
        return this.channelNumber;
    }

    public String getUserId() {
        return this.userId;
    }

    public ProgramProviderType getProgramProvider() {
        return this.programProvider;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext=context;
        Log.e("ChannelChangeReceiver", "onReceive");
        this.channelNumber = intent.getIntExtra(IntentApp.CHANNEL_KEY, -1);
        this.userId = intent.getStringExtra(IntentApp.USERID_KEY);
        this.programProvider = (ProgramProviderType) intent.getSerializableExtra(IntentApp.PROGRAMPROVIDER_KEY);
        this.onChannelChangeHandle(channelNumber, userId, programProvider);
        TipStatus tipStatus = this.onProvideTipStatus();
        String serviceName = this.onProvideServiceName();
        new TipStatusChangeBroadcastSender(context, tipStatus, serviceName).send();
    }

    protected void onChannelChangeHandle(int channel, String userId, ProgramProviderType programProvider) {

    }

    protected TipStatus onProvideTipStatus() {
        return TipStatus.Null;
    }

    protected String onProvideServiceName() {
        return "ChannelChangeReceiver";
    }
}
