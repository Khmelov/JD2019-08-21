package by.it.gorevoy.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private List<T> elements = new ArrayList<>();
    int size = 0;

    @Override
    public boolean add(T e) {
        if (size == elements.size()) {
            System.arraycopy(elements, 0, elements, 0,size*3/2+1);
        }
        for (int i = 0; i < elements.size(); i++) {
            if (e.equals(elements.get(i)))
                return false;
            else {
                elements.set(size, e);
                size++;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0)
            sb.append("[]");
        else {
            sb.append('[');
            String delimiter = "";
            for (int i = 0; i < size; i++) {
                sb.append(delimiter).append(elements.get(i));
                delimiter = ", ";
            }
            sb.append("]");
        }
    return sb.toString();
    }

    // stubs

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}

