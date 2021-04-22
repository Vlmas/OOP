package lab3.collections;

public interface MyCollection {
    int size();

    boolean contains(Object obj);

    boolean isEmpty();

    void add(Object obj);

    void remove(Object obj);

    void clear();

    int hashCode();

    boolean equals(Object obj);
}