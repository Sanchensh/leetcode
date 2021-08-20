package com.mrxu.datastructure;

import java.util.*;

/**
 * @author jlxu@telenav.cn
 * @date 2021/7/22 15:47
 */
public class CustomArrayList<T> implements List<T> {
    private int size = 0;
    private Object[] objects = new Object[1 << 5];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (objects[i] == o) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(objects).iterator();
    }

    @Override
    public Object[] toArray() {
        Object[] os = new Object[size];
        for (int i = 0; i < size; i++) {
            os[i] = objects[i];
        }
        return os;
    }

    @Override
    public boolean add(Object o) {
        add(size,o);
        return true;
    }

    private boolean reSize() {
        return size >= objects.length;
    }

    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i < 0) return false;
        for (int j = i; j < size - 1; j++) {
            objects[j] = objects[j + 1];
        }
        size--;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        int i = 0;
        if (c.size() + size >= objects.length) {
            Object[] os = new Object[(int) ((c.size() + size) * 1.5)];
            for (Object o : c) {
                if (i >= c.size()) {
                    break;
                }
                os[size++] = o;
                i++;
            }
            objects = os;
        } else {
            for (Object o : c) {
                if (i >= c.size()) {
                    break;
                }
                objects[size++] = o;
                i++;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        objects = new Object[1 << 5];
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) objects[index];
    }

    @Override
    public Object set(int index, Object element) {
        validateIndex(index);
        objects[index] = element;
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index > 0){
            validateIndex(index);
        }
        if (reSize()) {
            Object[] os =  new Object[size * 2];
            for (int i = 0; i < index; i++) {
                os[i] = objects[i];
            }
            os[index] = element;
            for (int i = size - 1; i > 0; i++) {
                os[i + 1] = objects[i];
            }
            objects = os;
        } else {
            for (int i = size; i > index; i--) {
                objects[i] = objects[i - 1];
            }
            objects[index] = element;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T t = (T) objects[index];
        for (int j = index; j < size - 1; j++) {
            objects[j] = objects[j + 1];
        }
        size--;
        return t;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (objects[i] == o)
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (objects[i] == o)
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        validateIndex(fromIndex);
        validateIndex(toIndex - 1);
        validateIndex(toIndex - fromIndex - 1);
        List<T> list = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add((T) objects[i]);
        }
        return list;
    }

    void validateIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("参数不合法或数组越界");
        }
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        c.clear();
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return a;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(objects[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        return "CustomArrayList{" + sb + '}';
    }
}
