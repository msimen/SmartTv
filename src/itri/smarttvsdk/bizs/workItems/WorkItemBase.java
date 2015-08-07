package itri.smarttvsdk.bizs.workItems;

import android.content.Context;
import android.content.Intent;

import java.util.UUID;

/**
 * Created by mimi on 15/1/5.
 */
public abstract class WorkItemBase implements IWorkItem {
    private String id;
    private Context ctx;
    private Intent workItemIntent;

    public WorkItemBase(Context ctx, Intent workItemIntent) {
        this.ctx = ctx;
        this.id = UUID.randomUUID().toString();
        this.workItemIntent = workItemIntent;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Context getContext() {
        return this.ctx;
    }

    @Override
    public Intent getWorkItemIntent() {
        return this.workItemIntent;
    }
}
