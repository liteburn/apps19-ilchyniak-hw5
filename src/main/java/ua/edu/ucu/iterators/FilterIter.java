package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntPredicate;

import java.util.Iterator;

public class FilterIter implements Iterator<Integer> {
    private Iterator<Integer> toIter;
    private IntPredicate pr;
    private int next;

    public FilterIter(Iterator<Integer> iter, IntPredicate pr) {
        toIter = iter;
        this.pr = pr;
    }

    @Override
    public boolean hasNext() {
        while (toIter.hasNext()) {
            next = toIter.next();
            if (pr.test(next)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return next;
    }
}

