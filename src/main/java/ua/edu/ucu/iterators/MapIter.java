package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIter implements Iterator<Integer> {
    private Iterator<Integer> toIter;
    private IntUnaryOperator mapper;

    public MapIter(Iterator<Integer> iter, IntUnaryOperator oper) {
        toIter = iter;
        this.mapper = oper;
    }

    @Override
    public boolean hasNext() {
        if (toIter.hasNext()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        return mapper.apply(toIter.next());
    }
}
