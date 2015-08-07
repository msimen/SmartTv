package itri.smarttvsdk.bizs.workItems;

import android.content.Context;
import android.content.Intent;

/**
 * Created by mimi on 15/1/5.
 */
public interface IWorkItem {
    public Context getContext();

    public String getId();

    public Intent getWorkItemIntent();

    public void execAction();
}
