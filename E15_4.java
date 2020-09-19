package com.sjsu;
/**
 * This is a class for managing the students' grades
 * Author: David Zhang
 * Course: cs49j
 * Instructor: Dr. Ramin Moazeni
 * Teacher Assistant: Yan Chen
 * Date: 11/2/19
 */

import java.util.*;

public class E15_4
{
    // create an attribute map studentGrades
    private static Map<String, String> studentGrades = new HashMap<>();

    // create a main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        System.out.println("\nWelcome. Please select your option by input a number, " +
                "\n1 for adding, 2 for removing, 3 for modifying grade, 4 for printing, 5 for quit: ");
        if(in.hasNextInt())
            choice = Integer.parseInt(in.next());

        while(true)
        {
            switch (choice)
            {
                case 1:
                {
                    System.out.println("Please enter the student's name: ");
                    String name = in.next();
                    System.out.println("please enter the grade of " + name + ":");
                    String grade = in.next();
                    adding(name, grade);
                    break;
                }

                case 2:
                {
                    System.out.println("Please enter the student's name: ");
                    String name = in.next();
                    removing(name);
                    break;
                }

                case 3:
                {
                    System.out.println("Please enter the student's name: ");
                    String name = in.next();
                    System.out.println("please enter the new grade of " + name + ":");
                    String grade = in.next();
                    modifying(name, grade);
                    break;
                }

                case 4:
                {
                    printing();
                    break;
                }

                default:
                {
                    System.out.println("Thank you. Bye!");
                    return;
                }
            }
            System.out.println("\nwWelcome. Please select your option by input a number, " +
                    "\n1 for adding, 2 for removing, 3 for modifying, 4 for printing, 5 for quit: ");
            if(in.hasNextInt())
                choice = Integer.parseInt(in.next());
        }
    }

    /**
     * create the method adding for adding some new elements into the map
     * @param name the name of the new student
     * @param grade the grade of the new student
     */
    public static void adding(String name, String grade)
    {
        studentGrades.put(name, grade);
    }

    /**
     * create the method removing to delete some unwanted elements
     * @param name the name of the student to be removed
     */
    public static void removing(String name)
    {
        studentGrades.remove(name);
    }

    /**
     * create the getter method for printing out the whole map ordered
     */
    public static void printing()
    {
        if(!studentGrades.isEmpty())
        {
            studentGrades = new TreeMap<String, String>(studentGrades);
            for(String key: studentGrades.keySet())
            {
                System.out.println("     " + key + ": " + studentGrades.get(key));
            }
        }
        else
        {
            System.out.println("The database is empty!");
        }

    }

    public static void modifying(String sName, String sGrade)
    {
        studentGrades.put(sName, sGrade);
    }
}
