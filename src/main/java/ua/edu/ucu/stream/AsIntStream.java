package ua.edu.ucu.stream;

import ua.edu.ucu.function.*;
import ua.edu.ucu.iterators.AsIntStreamIter;
import ua.edu.ucu.iterators.FilterIter;
import ua.edu.ucu.iterators.FlatMapIter;
import ua.edu.ucu.iterators.MapIter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


public class AsIntStream implements IntStream {
    private Iterator<Integer> iterator;

    private AsIntStream(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Iterable<Integer> iterable() {
        return () -> iterator;
    }

    public static IntStream of(int... values) {
        return new AsIntStream(new AsIntStreamIter(values));
    }

    public Iterator<Integer> getIterator() {
        return iterator;
    }

    private void check() {
        if (iterator == null || !iterator.hasNext()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Double average() {
        check();
        return (double) sum() / count();
    }

    @Override
    public Integer max() {
        check();
        int max = Integer.MIN_VALUE;
        for (int val : iterable()) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        check();
        int min = Integer.MAX_VALUE;
        for (int val : iterable()) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    @Override
    public long count() {
        int length = 0;
        for (int val : iterable()) {
            length += 1;
        }
        return length;
    }

    @Override
    public Integer sum() {
        int sum = 0;
        check();
        for (int val : iterable()) {
            sum += val;
        }
        return sum;
    }

    @Override
    public IntStream filter(IntPredicate predicate) {
        return new AsIntStream(new FilterIter(getIterator(), predicate));
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int elem : iterable()) {
            action.accept(elem);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        return new AsIntStream(new MapIter(getIterator(), mapper));
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        return new AsIntStream(new FlatMapIter(getIterator(), func));
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        for (int el : iterable()) {
            identity = op.apply(identity, el);
        }
        return identity;
    }

    @Override
    public int[] toArray() {
        Collection<Integer> toConvert = new ArrayList<>();
        for (int elem : iterable()) {
            toConvert.add(elem);
        }
        int[] arr = new int[toConvert.size()];
        int i = 0;
        for (int elem : toConvert) {
            arr[i] = elem;
            i += 1;
        }
        return arr;
     //   int[] arr = new int[(int) count()];
     //   int i = 0;
     //   for (int el: iterable()) {
      //      arr[i] = el;
       //     i += 1;
        //}
        //System.out.println(Arrays.toString(arr));
        //return arr;
    }
}
