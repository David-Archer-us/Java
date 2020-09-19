package com.sjsu;

/**
 * This is a class for improved studentGrades using class Student
 * Author: David Zhang
 * Course: cs49j
 * Instructor: Dr. Ramin Moazeni
 * Teacher Assistant: Yan Chen
 * Date: 11/2/19
 */

import java.util.*;

public class P15_2
{
    // create an attribute map studentGrades
    private static Map<Student, String> studentGrades = new HashMap<>();

    // create a main method
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        System.out.println("\nWelcome. Please select your option by input a number, " +
                "\n1 for adding, 2 for removing, 3 for modifying, 4 for printing, 5 for quit: ");
        if(in.hasNextInt())
            choice = Integer.parseInt(in.next());

        while(true)
        {
            switch (choice)
            {
                case 1:
                {
                    System.out.println("Please enter the student's first name: ");
                    String fName = in.next();
                    System.out.println("please enter the student's last name: ");
                    String lName = in.next();
                    System.out.println("Please enter the student's ID: ");
                    int iID = 0;
                    if(in.hasNextInt())
                    {
                        iID = Integer.parseInt(in.next());
                    }
                    System.out.println("please enter the grade of " + fName + " " + lName + ":");
                    String sGrade = in.next();
                    adding(fName, lName, iID, sGrade);
                    break;
                }

                case 2:
                {
                    System.out.println("Please enter the student's ID number: ");
                    int iID = in.nextInt();
                    removing(iID);
                    break;
                }

                case 3:
                {
                    System.out.println("Please enter the student's ID number: ");
                    int iID = in.nextInt();
                    System.out.println("please enter the new grade: ");
                    String grade = in.next();
                    modifying(iID, grade);
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
     * create the method adding for adding a new student
     * @param fName the new student's first name
     * @param lName the new student's last name
     * @param iID the new student's ID number
     * @param sGrade the new student's grade string
     */
    public static void adding(String fName, String lName, int iID,  String sGrade)
    {
        Student newStudent = new Student(fName, lName, iID);
        studentGrades.put(newStudent, sGrade);
    }

    /**
     * create the method for removing a student
     * @param iID the id of the student to be removed
     */
    public static void removing(int iID)
    {
        Iterator<Student> it = studentGrades.keySet().iterator();
        while(it.hasNext())
        {
            Student theStudent = it.next();
            if(theStudent.getID() == iID)
                it.remove();
        }
    }

    /**
     * create the method for modifying the student's grade
     * @param iID the id of the student to be modified
     * @param sGrade the new grade of the student
     */
    public static void modifying(int iID, String sGrade)
    {
        for (Student stu: studentGrades.keySet())
        {
            if(stu.getID() == iID)
                studentGrades.put(stu, sGrade);
        }
    }

    /**
     * create the getter method for printing out the whole map ordered
     */
    public static void printing()
    {
        if(!studentGrades.isEmpty())
        {
            studentGrades = new TreeMap<Student, String>(studentGrades);
            for(Student key: studentGrades.keySet())
            {
                System.out.println("     " + key.toString() + ": " + studentGrades.get(key));
            }
        }
        else
        {
            System.out.println("The database is empty!");
        }
    }
}
