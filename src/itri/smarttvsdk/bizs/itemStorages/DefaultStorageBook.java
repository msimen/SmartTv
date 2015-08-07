package itri.smarttvsdk.bizs.itemStorages;

import android.util.Log;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mimi on 15/1/6.
 */
public class DefaultStorageBook implements IStorageBook {
    private Queue<IStorageItem> itemQueue;

    private Queue<IStorageItem> getItemQueue() {
        if (this.itemQueue == null) {
            Log.e("DefaultStorageBook", "getItemQueue");
            this.itemQueue = new PriorityQueue<IStorageItem>(1000);
        }

        return this.itemQueue;
    }

    @Override
    public IStorageItem getStorageItem() {
        Log.e("DefaultStorageBook", "getStorageItem");
        return this.getItemQueue().poll();
    }

    @Override
    public void setStorageItem(IStorageItem item) {
        Log.e("DefaultStorageBook", "setStorageItem");
        this.getItemQueue().offer(item);
    }

    @Override
    public void clear() {
        this.getItemQueue().clear();
    }

    @Override
    public boolean isEmpty() {
        return this.getItemQueue().isEmpty();
    }

    @Override
    public void remove(IStorageItem item) {
        this.getItemQueue().remove(item);
    }
}
