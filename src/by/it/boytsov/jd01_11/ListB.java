package by.it.boytsov.jd01_11;

import java.util.*;



public class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{} ;
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements , (size*3)/2+1) ;
        elements [size] = t ;
        size++ ;
        return true ;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[") ;
        String delimeter = "" ;

        for (int i = 0 ; i < size ; i++) {
            str.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        str.append("]") ;
        return str.toString() ;
    }

    @Override
    public T remove(int index) {
        T del = elements [index] ;
        System.arraycopy(elements, index+1, elements, index, size-index-1);
        size-- ;
        return del;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T delete = elements [index] ;
        elements [index] = element ;
        return delete;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e : c) add(e) ;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size==0)
            return true;
        else return false ;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() { }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}