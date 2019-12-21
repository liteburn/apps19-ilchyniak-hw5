package ua.edu.ucu.iterators;

import java.util.Iterator;

public class AsIntStreamIter implements Iterator<Integer> {


    private int[] array;
    private int i = 0;

    public AsIntStreamIter(int... values) {
        array = values.clone();

    }

    @Override
    public boolean hasNext() {
        return i < array.length;
    }

    @Override
    public Integer next() {

        return array[i++];
    }
}
