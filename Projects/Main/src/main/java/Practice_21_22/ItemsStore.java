package Practice_21_22;

import java.io.IOException;
import java.util.List;

public interface ItemsStore {
    List<Item> getAll() throws IOException, InterruptedException;
    Item get(int id) throws IOException, InterruptedException;
    Item addItem(Item item);
    Item editItem(int id, Item item);
    boolean deleteItem(int id);
}
