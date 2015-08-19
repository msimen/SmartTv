package itri.smarttvhome.views.sysviews;

/**
 * Created by mimi on 14/12/27.
 */
public interface ISysFloatViewDelegateListener {
    public boolean upClickEvent(Object sender, Object args);

    public boolean downClickEvent(Object sender, Object args);

    public boolean okClickEvent(Object sender, Object args);

    public boolean leftClickEvent(Object sender, Object args);

    public boolean rightClickEvent(Object sender, Object args);

    public boolean backClickEvent(Object sender, Object args);

    public boolean homeClickEvent(Object sender, Object args);

    public boolean disposeEvent(Object sender, Object args);
}
