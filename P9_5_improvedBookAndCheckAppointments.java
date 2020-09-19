package com.sjsu;


/**
 * This program is an improved version of booking and checking appointments
 * Author: David Zhang
 * Course: cs49j
 * Instructor: Dr. Ramin Moazeni
 * Teacher Assistant: Yan Chen
 * Date: 10/5/19
 */

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
public class P9_5_improvedBookAndCheckAppointments
{
    /**
     * method save() for save appointments to file appointment.txt
     * @param inType the type of the appointment
     * @param sDescription the description of the appointment
     * @param inYear the year of the data
     * @param inMonth the month of the date
     * @param inDay the day of the date
     * @throws IOException
     */
    public static void save(String fileName, int inType, String sDescription, int inYear, int inMonth, int inDay) throws IOException
    {
        FileWriter fw = new FileWriter(fileName, true);
        PrintWriter apw = new PrintWriter(fw);
        String type = Integer.toString(inType);
        apw.println(type + " " + inYear + " " + inMonth + " " + inDay + " " + sDescription);
        apw.close();
    }

    /**
     * the method load() for load data from the file
     * @param data a line of the file
     * @return return an object of class Appointment
     */
    public static Appointment load(String data)
    {
        String[] detail = data.split(" ");
        if (detail[0].equals("1"))
        {
            return new Onetime(detail[4], Integer.parseInt(detail[1]), Integer.parseInt(detail[2]), Integer.parseInt(detail[3]));
        }
        if(detail[0].equals("2"))
        {
            return new Daily(detail[4], Integer.parseInt(detail[1]), Integer.parseInt(detail[2]), Integer.parseInt(detail[3]));
        }
        if(detail[0].equals("3"))
        {
            return new Monthly(detail[4], Integer.parseInt(detail[1]), Integer.parseInt(detail[2]), Integer.parseInt(detail[3]));
        }
        return new Appointment("", 0, 0, 0);
    }

    public static void main(String[] args) throws IOException
    {
        // create 4 vars for 4 attributes of the class Appointment
        int year, month, day;
        String description;
        String appFile = "appointments.txt";

        // create a file to store the appointments
        PrintWriter pw = new PrintWriter(appFile);
        pw.close();

        // get the input from the user
        Scanner in = new Scanner(System.in);
        System.out.println("\nPlease enter '1' for booking appointments or '2' for checking appointments, '3' for quit: ");
        int choice = in.nextInt();
        while(true)
        {
            if (choice == 1)
            {
                System.out.println("Please enter the type number of your appointment " +
                        "('1' for onetime, '2' for daily, '3' for monthly): ");
                int type = in.nextInt();
                System.out.println("Please enter the date (year month day) for booking appointments: ");
                year = in.nextInt();
                month = in.nextInt();
                day = in.nextInt();
                System.out.println("Please enter the description of your appointment: ");
                description = in.nextLine();

                if(type == 1)
                {
                    save( appFile, 1,description, year, month, day);
                }
                if(type == 2)
                {
                    save( appFile,2,description, year, month, day);
                }
                if(type == 3)
                {
                    save(appFile,3,description, year, month, day);
                }
            }

            if(choice == 2)
            {
                System.out.println("Please enter the date (year month day) for checking appointments: ");
                year = in.nextInt();
                month = in.nextInt();
                day = in.nextInt();

                // check the array and print out the results
                System.out.print("\nYour appointments: ");

                // read the appointments file
                Scanner sc = new Scanner(new File(appFile));
                while(sc.hasNextLine())
                {
                    Appointment app = load(sc.nextLine());
                    if(app.occursOn(year, month, day))
                    {
                        System.out.print(app.getDescription() + ". ");
                    }
                }
                sc.close();
            }
            if(choice == 3)
            {
                System.out.println("Thanks for using the program.");
                break;
            }
            System.out.println("\n\nPlease enter '1' for booking appointments or '2' for checking appointments, '3' for quit: ");
            choice = in.nextInt();
        }

    }
}
