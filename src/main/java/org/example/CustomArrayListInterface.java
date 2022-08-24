package org.example;

/**
 * Custom ArrayList interface
 */
public interface CustomArrayListInterface {

    Object get(int index);

    void add(Object element);

    void add(Object element, int index);

    boolean delete(Object element);

    void sort();

    int getSize();

}
