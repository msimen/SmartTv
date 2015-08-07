package itri.smarttvsdk.bizs.itemStorages;

/**
 * Created by mimi on 15/1/6.
 */
public interface IStorageManager {
    public IStorageBook getValue(String key);

    public void addStorageBook(String key, IStorageBook book);

    public void clear();

    public boolean isEmpty();

    public void remove(String key);
}
