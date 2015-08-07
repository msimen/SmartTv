package itri.smarttvsdk.bizs.itemStorages;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mimi on 15/1/6.
 */
public class DefaultStorageManager implements IStorageManager {
    private Map<String, IStorageBook> books;

    private Map<String, IStorageBook> getBooks() {
        if (this.books == null) {
            this.books = new HashMap<String, IStorageBook>();
        }

        return this.books;
    }

    @Override
    public IStorageBook getValue(String key) {
        return this.getBooks().get(key);
    }

    @Override
    public void addStorageBook(String key, IStorageBook book) {
        if (this.getBooks().containsKey(key)) {
            this.getBooks().remove(key);
        }
        this.getBooks().put(key, book);
    }

    @Override
    public void clear() {
        this.getBooks().clear();
    }

    @Override
    public boolean isEmpty() {
        return this.getBooks().isEmpty();
    }

    @Override
    public void remove(String key) {
        if (this.getBooks().containsKey(key)) {
            this.getBooks().remove(key);
        }
    }
}
