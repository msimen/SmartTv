package itri.smarttvsdk.bizs.workItems;

import android.content.Context;

/**
 * Created by mimi on 15/1/5.
 */
public interface IWorkItemIntent {
    public Context getContext();

    public void send();
}
