package com.sjsu;

/**
 * This is a class for using a generic method print()
 * Author: David Zhang
 * Course: cs49j
 * Instructor: Dr. Ramin Moazeni
 * Teacher Assistant: Yan Chen
 * Date: 11/28/19
 */

import java.util.ArrayList;

public class E18_12
{
    public static <E, I extends Iterable<E>> void print(I iterable)
    {
        if(iterable.iterator().hasNext())
        {
            ArrayList<String> stringList = new ArrayList<>();
            for(E element: iterable) {
                stringList.add(element.toString());
            }
            String result = String.join(",", stringList);
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(8);
        arr.add(10);
        E18_12.print(arr);
    }
}
