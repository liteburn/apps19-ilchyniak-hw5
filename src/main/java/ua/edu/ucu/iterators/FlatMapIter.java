package ua.edu.ucu.iterators;

import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.stream.AsIntStream;

import java.util.Iterator;

public class FlatMapIter implements Iterator<Integer>{
    private Iterator<Integer> toIter;
    private IntToIntStreamFunction func;
    private Iterator<Integer> currStream;

    public FlatMapIter(Iterator<Integer> iter, IntToIntStreamFunction fn) {
        toIter = iter;
        func = fn;
    }

    @Override
    public boolean hasNext() {
        if (currStream != null && currStream.hasNext()){
            return true;
        }
        if (toIter.hasNext()){
            currStream = ((AsIntStream) func.applyAsIntStream(toIter.next())).getIterator();
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        return currStream.next();
    }
}
