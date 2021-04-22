package lab3.collections;

public class Array<E> implements MyCollection {
    E[] array;

    public Array() {}

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object obj) {
        if(obj instanceof Array) {
            return true;
        } else {
            throw new IllegalArgumentException("Enter the type of the Collection!");
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove(Object obj) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void add(Object elem) {

    }
}
