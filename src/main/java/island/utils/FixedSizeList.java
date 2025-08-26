package island.utils;

import java.util.ArrayList;

public class FixedSizeList<E> extends ArrayList<E> {

    private static final long serialVersionUID = 8538918704714966182L;
    private final int maxSize;

    public FixedSizeList(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return maxSize == size();
    }

    @Override
    public boolean add(E e) {
        if (size() >= maxSize) {
            return false;
        }
        return super.add(e);
    }
}
