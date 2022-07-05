package com.andyron.array;

public class GenericArray<T> {
    private T[] data;
    /**
     * 当前元素个数
     */
    private int size;

    /**
     *
     * @param capacity 容量
     */
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public  boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在 index 位置，插入元素e, 时间复杂度 O(m+n)
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    public void  addFirst(T e) {
        add(0, e);
    }

    public void addEnd(T e) {
        add(size, e);
    }

    /**
     * 删除 index 位置的元素，并返回
     */
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * 扩容方法，时间复杂度 O(n)
     */
    private void resize(int newCapacity) {
        if(newCapacity <= getCapacity()) {
            return;
        }
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw  new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }

    public static void main(String[] args) {
        GenericArray<String> strs = new GenericArray<>();
        strs.addFirst("ab");
        strs.addFirst("cd");
        strs.addEnd("hj");
        strs.add(1, "xxx");
        System.out.println(strs);

    }

}