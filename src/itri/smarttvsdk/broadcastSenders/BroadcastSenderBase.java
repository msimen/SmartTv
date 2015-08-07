package itri.smarttvsdk.broadcastSenders;

import android.content.Context;
import android.content.Intent;

/**
 * Created by mimi on 15/1/9.
 */
public abstract class BroadcastSenderBase implements IBroadcastSender {
    private Context mContext;
    private Intent sendItent;

    public BroadcastSenderBase(Context ctx) {
        this.mContext = ctx;
        this.sendItent = new Intent();
    }

    protected Intent getSendItent() {
        return this.sendItent;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void send() {
        this.getContext().sendBroadcast(this.getSendItent());
    }
}
