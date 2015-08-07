package itri.smarttvsdk.bizs.workItems;

/**
 * Created by mimi on 15/1/5.
 */
public abstract class AppWorkItemIntent extends WorkItemIntentBase {

    public AppWorkItemIntent(IHomeAppActivity homeAppActivity, String backAction) {
        super(homeAppActivity);
        this.putExtra("BackAction", backAction);
    }
}
