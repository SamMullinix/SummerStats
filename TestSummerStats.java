/* Class:         CS1301
 * Section:       8
 * Term:          Fall 2015
 * Name:          Sam Mullinix
 * Instructor:    Mr. Robert Thorsen
 * Assignment:    12
 * Program:       4
 * ProgramName:   TestSummerStats
 * Purpose:       To test the program Summer stats by evnoking methods and creating objects, then printing the results..
 * Operation:     Program prompts for program SummerStats to create a two dimmensional array object, then method calls
 *                return numbers and these numbers are printed accordingly to the user.  
 * Input(s):      The number of people in the group, the number of years worked, employee number's salary to check,
 *                and the year to check for highest employee salary.
 * Output(s):     Statment about the original array output table, the employee made the most money in a specified year
 *                the employee that made the most money, the most profitable year, sum of income for all employees
 *                the salary for a specified employee, a table with the averages for each year, and print the 2
 *                dimensional array that contains the sorted salaries and employees.
 * Methodology:   The program prompts for the creation of the one SummerStock object, then asks for the inputs to 
 *                create the array in the test program. Then all of the calls needed for printing and filling the
 *                average and sorted array and called in the calculation section, then each variable is recivede with
 *                a getter method, or printed using a printing method within the test program. Then all these results 
 *                are printed to the user.
 *                
 */  
 
/*******************************************************
//  Import the java utility; Scanner and NumberFormat //
*******************************************************/

import java.util.Scanner;
import java.text.NumberFormat;
  
public class TestSummerStats
{
   public static void main (String[] args)
   {
      /********************************************
      //    Create new Scanner/Currency items    //
      ********************************************/
                   
      Scanner input = new Scanner(System.in);
      NumberFormat fmt = NumberFormat.getCurrencyInstance();
      
      /******************************************************************************
      *                             Declare Arrays                                  *
      ******************************************************************************/
      
      double[] averageArray;
      double[][] sortArray;
      
      /******************************************************************************
      *                        Declare/Initialize Variables                         *
      ******************************************************************************/
      
      int people = 0;
      int years = 0;
      int row = 0;
      int column = 0;
      int employeeNumber = 0;
      int checkYear = 0;
      
      /******************************************************************************
      *                                Input Section                                *
      ******************************************************************************/
      
      System.out.print("Enter the number of people in the group:\t");
      people = input.nextInt();  // Input.
      
      System.out.print("Enter the number of years worked:\t\t");
      years = input.nextInt();   // Input.
      
      System.out.print("\nWhat employee's total salary\nwould you like to check?:\t\t\t");
      employeeNumber = input.nextInt();   // Input.
      
      System.out.print("\nWhat year would you like to check \nfor highest employee salary?:\t\t\t");
      checkYear = input.nextInt();  // Input.
      
      /******************************************************************************
      *                   Create Object and Array based on input                    *
      ******************************************************************************/
      
      SummerStats Stat1 = new SummerStats(people, years);   // Create an object, stat1.
      averageArray = new double[years];                     // Create size of the average aray.
      sortArray = new double[people][years];                // Create the sorted array size.
      
      /******************************************************************************
      *                            Calculation Section                              *
      ******************************************************************************/
      
      Stat1.fillAverage();                      // Fill both the average and sorted array.
      Stat1.sortArray();
      averageArray = Stat1.getAverageArray();   // Import the filled arrays into this program.
      sortArray = Stat1.getSortedArray();
      
      /******************************************************************************
      *                                 Output Section                              *
      ******************************************************************************/
      
      System.out.println("\nTable with employees starting at number 0 and increasing going down\nand years starting at 0 and increasing to the right.\n");
      Stat1.printSummerStats();  // Print the original randomly filled array.
      
      // Purpose of each output below is obvious based on the prompt following:
      System.out.print("\nThe employee made the most money in year " + checkYear + " is:\t" + (int)Stat1.individualYear(checkYear));
      System.out.print("\nThe employee that made the most money is:\t" + Stat1.highestPaid());
      System.out.print("\nThe most profitable year was:\t\t\t" + Stat1.profitableYear());
      System.out.print("\nSum of income for all employees:\t\t" + fmt.format(Stat1.statSum()));
      System.out.println("\nSalary for Employee " + employeeNumber + ":\t\t\t\t" + fmt.format(Stat1.individualSalary(employeeNumber)));
      
      System.out.println("\nYearly Averages:\n___________________________");  // Print table for yearly averages.
      for (column = 0; column < averageArray.length; column++) 
      { 
         System.out.print("Year: " + column + "\t\t");   // Print each year.
      } 
      
      System.out.println();   // Space inbetween.
      
      for (column = 0; column < averageArray.length; column++) 
      { 
         System.out.print(fmt.format(averageArray[column]) + "\t"); // Print contents of the average array.
      } 
      
      System.out.println("\n\nSorted Array:\n___________________________");   // Sorted array header.
      for (row = 0; row < sortArray.length; row++) 
      {
         for (column = 0; column < sortArray[row].length; column++) 
         { 
            System.out.print(fmt.format(sortArray[row][column]) + " "); // Print contents of the sorted array.
         } 
         System.out.println();
      }
      
   
      
   }
}