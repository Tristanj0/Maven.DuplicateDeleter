package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    abstract public T[] removeDuplicates(int maxNumberOfDuplications);
    abstract public T[] removeDuplicatesExactly(int exactNumberOfDuplications);
    abstract public Integer[] countMultiples(T [] input);
    abstract public int calculateNewLength(Integer [] multiples, int maxNumberOfDuplications);
    abstract public int calculateExactLength(Integer [] multiples, int maxNumberOfDuplications);
}
