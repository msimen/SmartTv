package itri.smarttvsdk.bizs.itemStorages;

/**
 * Created by mimi on 15/1/6.
 */
public interface IStorageBook {
    public IStorageItem getStorageItem();

    public void setStorageItem(IStorageItem item);

    public void clear();

    public boolean isEmpty();

    public void remove(IStorageItem item);
}
