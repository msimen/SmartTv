package itri.smarttvsdk.bizs.workItems;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by mimi on 15/1/5.
 */
public class AppWorkItem extends WorkItemBase {

    private String showText;

    public AppWorkItem(Context ctx, Intent workItemIntent, String showText) {
        super(ctx, workItemIntent);
        this.showText = showText;
    }

    @Override
    public void execAction() {
        Log.e("DemoWorkItem", "execAction_BackAction:" + this.getWorkItemIntent().getStringExtra("BackAction"));
        Intent backIntent = new Intent();
        backIntent.setAction(this.getWorkItemIntent().getStringExtra("BackAction"));
        backIntent.putExtras(this.getWorkItemIntent());
        this.getContext().sendBroadcast(backIntent);
////        Log.e("DemoWorkItem", "execAction");
////        if(this.getContext()!=null)
//        Toast.makeText(this.getContext(), "execAction:"+this.showText,
//                Toast.LENGTH_LONG).show();
    }
}
