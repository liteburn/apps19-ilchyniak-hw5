package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntUnaryOperator;

import java.util.Iterator;

public class MapIter implements Iterator<Integer> {
    private Iterator<Integer> toIter;
    private IntUnaryOperator mapper;
    private int next;

    public MapIter(Iterator<Integer> iter, IntUnaryOperator oper) {
        toIter = iter;
        this.mapper = oper;
    }

    @Override
    public boolean hasNext() {
        return toIter.hasNext();
    }

    @Override
    public Integer next() {
        return mapper.apply(toIter.next());
    }
}
