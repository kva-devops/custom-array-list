package org.example;


import java.util.Arrays;

/**
 * Custom ArrayList implementation
 */
public class CustomArrayListImpl implements CustomArrayListInterface {

    /**
     * Count of elements
     */
    private int size;

    /**
     * Array containing elements
     */
    private Object[] elements;

    /**
     * Default constructor
     */
    public CustomArrayListImpl() {
        this.elements = new Object[10];
    }

    /**
     * Constructor with parameter
     * @param capacity - capacity of array
     */
    public CustomArrayListImpl(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else {
            this.elements = new Object[10];
        }

    }

    /**
     * Method for getting element by index
     * @param index - Index of element
     * @return Object
     */
    @Override
    public Object get(int index) {
        if (checkIndexWithinBoundsOfArray(index)) {
            return elements[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Method for adding new element
     * @param element - Object
     */
    @Override
    public void add(Object element) {
        int s = this.size;
        if (s == elements.length) {
            elements = this.growArraySize();
        }
        elements[s] = element;
        this.size++;
    }

    /**
     * Method for adding a new element at a specific position
     * @param element - Object
     * @param index - position
     */
    @Override
    public void add(Object element, int index) {
        int s;
        if (checkIndexWithinBoundsOfArray(index)) {
            s = this.size;
            if (s == this.elements.length) {
                elements = this.growArraySize();
            }
            System.arraycopy(elements, index, elements, index + 1, s - index);
            elements[index] = element;
            this.size++;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * Method for deleting object
     * @param element - Object
     * @return boolean result
     */
    @Override
    public boolean delete(Object element) {
        int i = 0;
        if (element == null) {
            while (true) {
                if (i >= size) {
                    return false;
                }
                if (elements[i] == null) {
                    break;
                }
                i++;
            }
        } else {
            while (true) {
                if (i >= size) {
                    return false;
                }
                if (element.equals(elements[i])) {
                    break;
                }
                i++;
            }
        }
        int newSize = size - 1;
        if (newSize > i) {
            System.arraycopy(elements, i + 1, elements, i, newSize - i);
        }
        this.size = newSize;
        elements[size] = null;
        return true;
    }

    /**
     * Method for sorting array
     */
    @Override
    public void sort() {
        mergeSort(elements, 0, elements.length - 1);
    }

    /**
     * Method for getting size of array
     * @return size of array
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Private method for growing array
     * @return array after growing
     */
    private Object[] growArraySize() {
        int oldCapacity = this.elements.length;
        int newCapacity = (int) Math.round(oldCapacity * 1.5);
        this.elements = Arrays.copyOf(this.elements, newCapacity);
        return elements;
    }

    /**
     * Private method for validation index of element
     * @param index - index of element
     * @return boolean result
     */
    private boolean checkIndexWithinBoundsOfArray(int index) {
        return (index < size && index >= 0);
    }

    /**
     * Private method for sorting array. Array division phase.
     * @param elements - array of elements
     * @param startIdx - index of start sorting
     * @param endIdx - index of end sorting
     */
    private void mergeSort(Object[] elements, int startIdx, int endIdx) {
        if (startIdx >= endIdx) {
            return;
        }
        int midIdx = startIdx + (endIdx - startIdx) / 2;
        mergeSort(elements, startIdx, midIdx);
        mergeSort(elements, midIdx + 1, endIdx);
        merge(elements, startIdx, midIdx, endIdx);
    }

    /**
     * Private method for sorting array. Array connection phase/
     * @param elements - Array of elements
     * @param startIdx - index of start array
     * @param midIdx - index of middle array
     * @param endIdx - index of end array
     */
    private void merge(Object[] elements, int startIdx, int midIdx, int endIdx) {
        Object[] leftArr = new Object[midIdx - startIdx + 1];
        Object[] rightArr = new Object[endIdx - midIdx];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = elements[startIdx + i];
        }
        for (int i = 0; i< rightArr.length; i++) {
            rightArr[i] = elements[midIdx + i + 1];
        }
        int leftArrIdx = 0;
        int rightArrIdx = 0;
        int sortedArrIdx = startIdx;
        while ((leftArrIdx < leftArr.length) && (rightArrIdx < rightArr.length)) {
            if (leftArr[leftArrIdx] instanceof Integer) {
                if ((int) leftArr[leftArrIdx] < (int) rightArr[rightArrIdx]) {
                    elements[sortedArrIdx] = leftArr[leftArrIdx];
                    leftArrIdx++;
                } else {
                    elements[sortedArrIdx] = rightArr[rightArrIdx];
                    rightArrIdx++;
                }
            } else if (leftArr[leftArrIdx] instanceof Double) {
                if ((double) leftArr[leftArrIdx] < (double) rightArr[rightArrIdx]) {
                    elements[sortedArrIdx] = leftArr[leftArrIdx];
                    leftArrIdx++;
                } else {
                    elements[sortedArrIdx] = rightArr[rightArrIdx];
                    rightArrIdx++;
                }
            } else if (leftArr[leftArrIdx] instanceof String) {
                String leftString = (String) leftArr[leftArrIdx];
                String rightString = (String) rightArr[rightArrIdx];
                if (leftString.compareTo(rightString) < 0) {
                    elements[sortedArrIdx] = leftArr[leftArrIdx];
                    leftArrIdx++;
                } else {
                    elements[sortedArrIdx] = rightArr[rightArrIdx];
                    rightArrIdx++;
                }
            }
            sortedArrIdx++;
        }
        while (leftArrIdx < leftArr.length) {
            elements[sortedArrIdx] = leftArr[leftArrIdx];
            leftArrIdx++;
            sortedArrIdx++;
        }
        while (rightArrIdx < rightArr.length) {
            elements[sortedArrIdx] = rightArr[rightArrIdx];
            rightArrIdx++;
            sortedArrIdx++;
        }
    }
}
