package itri.smarttvsdk.bizs.workItems;

/**
 * Created by mimi on 15/1/5.
 */
public interface IWorkItemManager {
    public IInstantQueuer getInstantQueuer();

    public IWailQueuer getWailQueuer();
}
