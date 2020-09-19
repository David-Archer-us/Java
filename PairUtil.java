package com.sjsu;

/**
 * This is a class for finding the pair of min & max in an array
 * Author: David Zhang
 * Course: cs49j
 * Instructor: Dr. Ramin Moazeni
 * Teacher Assistant: Yan Chen
 * Date: 11/30/19
 */

// create the class PairUtil
public class PairUtil
{
    public static void main(String[] args)
    {
        Measurable[] arr = new Measurable[5];
        arr[0] = new Measure<Integer>(3);
        arr[1] = new Measure<Double>(5.5);
        arr[2] = new Measure<Double>(99.9);
        arr[3] = new Measure<Integer>(1);
        arr[4] = new Measure<Double>(1.33);

        Pair pair = PairUtil.minmax(arr);
        System.out.println(pair.toString());
    }

    // create the generic method minmax()
    public static <E extends Measurable> Pair<E, E> minmax(E[] arr)
    {
        if(arr.length > 0)
        {
            E min = arr[0];
            E max = arr[0];

            for(E element: arr)
            {
                if(min.isGreaterThan(element))
                    min = element;
                if(!max.isGreaterThan(element))
                    max = element;
            }
            return new Pair(min, max);
        }
        return new Pair(0, 0);
    }

    // create a generic class to implement the interface Measurable
    static class Measure<T> implements Measurable
    {
        private T value;

        public Measure(T tValue)
        {
            value = tValue;
        }

        @Override
        public double getMeasure()
        {
            return ((Number)value).doubleValue();
        }
    }

    // create the class Pair
    static class Pair<T, S>
    {
        private T first;
        private S second;

        public Pair(T tElement, S sElement)
        {
            first = tElement;
            second = sElement;
        }

        public T getFirst()
        {
            return first;
        }

        public S getSecond()
        {
            return second;
        }

        public String toString()
        {
            return "(" + (((Measurable)getFirst()).getMeasure() + ", " + ((Measurable)getSecond()).getMeasure()) + ")";
        }
    }

    // create the interface Measurable
    public interface Measurable
    {
        double getMeasure();

        default boolean isGreaterThan(Measurable other)
        {
            return this.getMeasure() > other.getMeasure();
        }
    }
}
