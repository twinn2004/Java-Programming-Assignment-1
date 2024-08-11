/*
 * Taylor Winn
 * June 5th, 2024
 * Programming Assignment 1
 * Generating a mock reciept
 */

package assignment1;

import java.util.Random;
import java.util.Scanner;

public class Winn_Taylor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);   // creating scanner to scan input from command line
        Random rand = new Random(); // creating random to generate random numbers for dates and receipt ID

        int receiptNum = rand.nextInt(1000, 2000);  // random receipt number (1000 included, 2000 excluded from range)
        int randomMonth = rand.nextInt(1, 13);  // random month (1-12)
        int randomDay = rand.nextInt(1, 29);    // random day
        int randomYear = rand.nextInt(1900, 2100);  // random year (1900-2199)

        String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October",
        "November", "December"};    // array of strings to store the months of the year (for the random date)

        String[] items = new String[10];    // array to contain the items on the list (starting with a max of 10 items) 
        double[] itemPrices = new double[10];   // same for the prices, stored as doubles

        int count = 0;
        double total = 0;

        System.out.println("******************************");
        System.out.println("****** S store ***************");
        System.out.println("******************************");   // formating the receipt 
        System.out.println("receipt number      " + receiptNum);
        System.out.println(months[randomMonth-1] + " " + randomDay + " " + randomYear);

        System.out.print("Write item name ");   // prompting user input
        String tempItem = scanner.nextLine();   // scanning the input and storing it in a temp variable
        while(!tempItem.equalsIgnoreCase("done")){  // while loop to terminate when the "done" keyword is encountered

            if(count == items.length){  // if the number of items is going to exceed the array's space, we need to increase the size
                String[] moreItems = new String[items.length * 2];  // doubling the array size
                System.arraycopy(items, 0, moreItems, 0, items.length); // copying the values from the array without forloop using arraycopy
                items = moreItems;  // assigning the old array to the new one to reduce confusion

                double[] morePrice = new double[itemPrices.length * 2]; // doing the same for the array storing the item's prices
                System.arraycopy(itemPrices, 0, morePrice, 0, itemPrices.length);
                itemPrices = morePrice;
            }

            items[count] = tempItem.substring(0,1).toUpperCase() + tempItem.substring(1);   // storing the item in the item array with the first letter capitalized
            System.out.print("Write price ");
            double tempPrice = scanner.nextDouble();    // storing double input in variable

            if(!tempItem.equalsIgnoreCase("food")){ // tax calculations
                tempPrice = tempPrice * 1.3;    // adding on the additional 30 percent of price by multiplying by 130 percent
            }

            itemPrices[count] = Math.round(tempPrice); // rounding to the nearest whole number
            System.out.println("item number " + (count + 1) + " " + items[count] + " " + itemPrices[count]);
            total += Math.round(tempPrice); // incrimenting the total
            scanner.nextLine();
            count++;    // incrimenting the count once all operations have finished

            System.out.print("Write item name ");
            tempItem = scanner.nextLine();  // continuing the loop
        }
        System.out.println(count + " items      total " + total);   // final output and general formatting 
        System.out.println("******************************\n******************************\n******************************");
        
        scanner.close();
    }
}