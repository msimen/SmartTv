package itri.smarttvsdk.bizs.workItems;

/**
 * Created by mimi on 15/1/5.
 */
public interface INormalQueuer {
    public IDequeueHandler getDequeueHandler();

    public IEnqueueHandler getEnqueueHandler();

}
