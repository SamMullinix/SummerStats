/* Class:         CS1301
 * Section:       8
 * Term:          Fall 2015
 * Name:          Sam Mullinix
 * Instructor:    Mr. Robert Thorsen
 * Assignment:    12
 * Program:       4
 * ProgramName:   SummerStats
 * Purpose:       To construct a summer statistics array and make methods as needed to
 *                derive certain data from the statistics
 * Operation:     Program a constructor and methods that perform given functions as specified  
 * Input(s):      None.
 * Output(s):     Print the randomly generated array when called.
 * Methodology:   Program is used to be implemented by a test program. Contains constructors and
 *                methods to be implemented.
 *                
 */

/*******************************************************
//         Import the java utility NumberFormat       //
*******************************************************/

import java.text.NumberFormat;

public class SummerStats
{

   /********************************************
   //         Create new Currency item        //
   ********************************************/
      
   NumberFormat fmt = NumberFormat.getCurrencyInstance();
   
   /******************************************************************************
   *                        Declare all the arrays to be used                    *
   ******************************************************************************/
   
   double[][] stats;
   double[][] sortedArray;
   double[] averageSalary;
   
   /******************************************************************************
   *                                 Constructor                                 *
   ******************************************************************************/

   SummerStats(int a, int b)    // Constuctor 
   {
      stats = new double[a][b];     // Create arrays of the size that adheres to user specifications.
      sortedArray = new double[a][b];
      averageSalary = new double[b];
      fillArray(a,b);   // Randomly fill the array of size a and b.
      fillSort();       // Fill the sorted array as a clone of array stats.
   }
   
   /******************************************************************************
   *                                    Methods                                  *
   ******************************************************************************/
   
   // Finds the total amount an employee made, given employee ID.
   public double individualSalary(int employee)
   {
      int count = 0;
      int column = 0;
      double total = 0;
      for (column = 0; column < stats[0].length; column++)
      {
         total = total + stats[employee][column];
      }
      return total;
   }
   
   // Returns the employee I.D that made the most money in a given year.
   public double individualYear(int year)
   {
      int count = 0;
      int column = 0;
      int employee = 0;
      int row = 0;
      double max = 0;
      
      for (row = 0; row < stats.length; row++)
      {
         if (max < stats[row][year])
         {
            employee = row;
            max = stats[row][year];
         }
            
      }
      return employee;
   }
   
   // Returns the employee ID of the highest paid employee.
   public int highestPaid()
   {
      int count = 0;
      int row = 0;
      int column = 0;
      int employee = 0;
      double rowSum = 0;
      double max = 0;
   
      for (row = 0; row < stats.length; row++) 
      {
         rowSum = 0;
         for (column = 0; column < stats[row].length; column++) 
         { 
            rowSum = rowSum + stats[row][column]; 
         } 
         if (rowSum > max)
         {
            max = rowSum;
            employee = row;
         } 
      }
      
      return employee;
   }
   
   // Returns the year in which the most money was made.
   public int profitableYear()
   {
      int count = 0;
      int row = 0;
      int column = 0;
      int year = 0;
      double columnSum = 0;
      double max = 0;
   
      for (column = 0; column < stats[0].length; column++) 
      {
         columnSum = 0;
         for (row = 0; row < stats.length; row++)
         { 
            columnSum = columnSum + stats[row][column]; 
         } 
         if (columnSum > max)
         {
            max = columnSum;
            year = column;
         } 
      }
      
      return year;
   }
   
   // Prints the randomly generated array when called.
   public void printSummerStats()
   {
      int count = 0;
      int row = 0;
      int column = 0;
      for (row = 0; row < stats.length; row++) 
      {
         for (column = 0; column < stats[row].length; column++) 
         { 
            System.out.print(fmt.format(stats[row][column]) + " "); 
         } 
         System.out.println();
      }
   }
   
   // Sums every variable in the stat array and returns it.
   public double statSum()
   {
      double sum = 0;
      int row = 0;
      int column = 0;
   
      for (row = 0; row < stats.length; row++) 
      {
         for (column = 0; column < stats[row].length; column++) 
         { 
            sum = sum + stats[row][column]; 
         } 
      }
      return sum;
   }
   
   // Fill the array with random numbers up to a reasonable amount for yearly earnings.
   public void fillArray(int row, int column)
   {
      int count = 0;
      for (row = 0; row < stats.length; row++) 
      {
         for (column = 0; column < stats[row].length; column++) 
         { 
            stats[row][column] = Math.random() * 250000; 
         } 
      }
   }
   
   // Fills the soon to be sorted array with every variable in array stat.
   public void fillSort()
   {
      int row = 0;
      int column = 0;
      int count = 0;
      for (row = 0; row < sortedArray.length; row++) 
      {
         for (column = 0; column < sortedArray[row].length; column++) 
         { 
            sortedArray[row][column] = stats[row][column]; 
         } 
      }
   }
   
   // Fills the one dimensional average array with the average of each year.
   public void fillAverage()
   {
      int count = 0;
      int row = 0;
      int column = 0;
      int year = 0;
      double columnSum = 0;
      double average = 0;
   
      for (column = 0; column < stats[0].length; column++) 
      {
         for (row = 0; row < stats.length; row++)
         { 
            columnSum = columnSum + stats[row][column];
         } 
         average = columnSum / stats.length;
         averageSalary[column] = average;
         columnSum = 0;
      }
   }
   
   // Sorts the array by placing the employee who made the most at the top
   // with all their statistics and all other employees below in numerical order
   // by the amount of money they made.
   public void sortArray()
   {
      int count = 0;
      int row = 0;
      int column = 0;
      double rowSum = 0;
      double rowSum2 = 0;
      boolean swapped = true;
      
      double[][] tempArray = new double[1][1]; // Temp array
      
      
      while(swapped)
      {
         swapped = false;
         for (row = 0; row < sortedArray.length - 1; row++) // Go through each row.
         {
            rowSum = 0;
            rowSum2 = 0;   // Reset sums.
            for (column = 0; column < sortedArray[row].length; column++) 
            { // Sum the row, and the row below it.
               rowSum = rowSum + sortedArray[row][column];
               rowSum2 = rowSum2 + sortedArray[row + 1][column];
            } 
            if (rowSum2 > rowSum)   // If the sum of the row below is bigger....
            {
               for (column = 0; column < sortedArray[row].length; column++) 
               {  // Then swap the second row with the first, repeat until in order
                  // the variable swap is false because nothing swapped and method ends.
                  tempArray[0][0] = sortedArray[row][column];
                  sortedArray[row][column] = sortedArray[row + 1][column];
                  sortedArray[row + 1][column] = tempArray[0][0];
                  swapped = true;
               }
            }
         }
      }
   }
   
   // Return the sorted array.
   public double[][] getSortedArray()
   {
      return sortedArray;
   }
   
   // Returns the average array.
   public double[] getAverageArray()
   {
      return averageSalary;
   }
}

