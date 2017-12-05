 /**************************************
 * Programmer: Andrew Ries
 * classID: aries9242
 * Lab2: Sell-O-Tron
 * CIS 2600: Business Application Programming
 * Fall 2017
 * Due date: 10/30/2017
 * Date completed: 10/30/2017
 **************************************
 * Program Description:
 * This program is for a manager to create invoices. This program starts by 
 * creating a new Object called product1. After this we "wrap" the rest of the 
 * program in a while loop for the medium challenge functionality of asking 
 * for another invoice. 
 *
 * The program begins by outputting the 5 products that are available. We then 
 * prompt the user to input their selection. A while loop with a switch 
 * statement then controls what itemName will be sent to the object based on the 
 * corresponding number chosen. If an invalid number is chosen, we ask them to 
 * reinput a valid number, and circle back.
 *
 * Next the program asks the user for… and then performs a range check on 
 * invoice number. If an invalid range is entered, the user is asked to enter 
 * again, the while can only be left by entering a number within the 
 * range asked. 
 *
 * After that we ask the user to input the sales amount, and then send all the 
 * input to the object with "set" methods. A series of print statements are used
 * for both ascii design and to print out "getters" from the object. 3 methods 
 * from the object are also used to calculate tax, shipping, and total cost. 
 *
 * Finally, we ask the user if they want to generate another invoice. Another 
 * while/switch loop Is used for responses of "y","n", or invalid characters.
 * 
 *-> If y is selected, we reset the switch from earlier (since we will use it 
 * again), and break out… the wrapper while is still true, so we go start a 
 * new invoice. 
 *-> If "n" is selected, the first while wrapper is set to false and the program 
 * terminates. 
 *-> If anything else is entered, we reset the switch, tell them they entered 
 * incorrectly, and circle back.
 * 
 * !!For use with Purchase.java object class!!
 * 
 * This is an excellent explanation of the program logic and process.
 * 
 * 
 ************************************* */
package lab2;

//import scanner class
import java.util.Scanner;

/**
 *
 * @author andrew-ries
 */
public class CreatePurchase {

    public static void main(String[] args) {

        //initilize variables to be submitted by user
        String itemName = " ";
        int invoiceNumber = 0;
        double saleAmount = 0;
        //CONSTANT variables for Invoice Number Range Check
        final int INVOICELL = 1000; //good.
        final int INVOICEUL = 8000;
        //for Item Choice switch
        int itemChoice = 0;
        boolean switchLoop = true; //boolean flag, good.
        //for asking user to create another invoice or not while/switch
        String addInvoice = null;
        boolean anotherInvoice = true;
        boolean switchLoop2 = true;

        
        
        
        //create object called 'product1', using Purchase.java class 
        //new reserves memoryspace 
        //Purchase() is a constructor method -> creates object
        Purchase product1 = new Purchase(); //OK. 
        //create scanner object to obtain input using 'inputDevice'
        Scanner inputDevice = new Scanner(System.in);

        //While anotherInvoice is true...
        //for question at end of program, does user want another invoice?
        while (anotherInvoice) {
            //[ITEM SELECTION MODULE]------------------------------------------/
            //item list
            System.out.println("\nPlease choose an item: ");
            System.out.println("1. Xeon Phi 7290");
            System.out.println("2. Xeon E7-8894 v4");
            System.out.println("3. Churro");
            System.out.println("4. IDA Pro");
            System.out.println("5. Atari");
            System.out.print("Item Selection: ");
            //ask user for item selection choice
            itemChoice = inputDevice.nextInt();

            //While switchLoop is true...
            while (switchLoop) {
                //set to false so it only happens once
                switchLoop = false;
                //this one is already declared true though
                switchLoop2 = true; //for use with invoice switch-loop at end

                //case determined by itemChoice variable from user input above
                //or below if incorrectly entered the first time. 
                switch (itemChoice) {
                    case 1:
                        itemName = "Xeon Phi 7290";
                        break;

                    case 2:
                        itemName = "Xeon E7-8894 v4";
                        break;

                    case 3:
                        itemName = "Churro";
                        break;

                    case 4:
                        itemName = "IDA Pro";
                        break;

                    case 5:
                        itemName = "Atari";
                        break;

                    //if not 1,2,3,4, or 5... set switchloop back to true
                    //otherwise on input it will not jump back to top of switch
                        
                        //OK. This works. It might have been more
                        //self-documenting to test the range.
                    default:
                        switchLoop = true;
                        System.out.print("\nInvalid Product!\nPlease select a"
                                + " number between 1 and 5: ");
                        //send back to case
                        itemChoice = inputDevice.nextInt();
                        break;

                }
            }
            //-----------------------------------------------------------------/

            //[INVOICE - RANGE CHECK MODULE]-----------------------------------/
            System.out.print("\nPlease enter the invoice number: ");
            //ask for input
            invoiceNumber = inputDevice.nextInt();

            /*
            The range check is looking for the range that we want the invoice to
            be in. However we want to output something if it is not in range of
            the INVOICE LowerLimit and INVOICE UpperLimit.
            So... "while NOT(!) in this range". output invalid string to user.  
             */
            while (!(invoiceNumber >= INVOICELL && invoiceNumber <= INVOICEUL))
            {
                System.out.print("\nYou entered an invalid invoice number!\n"
                        + "Please enter a number between 1000-8000: ");
                //ask for input again after failed attempt
                invoiceNumber = inputDevice.nextInt();
            }
            //-----------------------------------------------------------------/   

            //[get sales amount from user + set input to object]---------------/   
            System.out.print("\nPlease enter the sales amount: $");
            saleAmount = inputDevice.nextDouble();

            //The first 3 lines take keyboard input from the user and, using set 
            //method, set it to the object.
            product1.setItemName(itemName);
            product1.setInvoiceNumber(invoiceNumber);
            product1.setSaleAmount(saleAmount);

            /* getItemName grabs the inputed name by user from the object.
               getInvoiceNumber grabs the inputed invoice number from the obj.
               getSaleAmount grabs the inputed sale mount from the obj.
               calculateTax, calculateShipping, and calculateTotalCost perform 
               the 3 calulation methods from the object. 
            
               NOTE: This could benifit from alignment formating
             */
            System.out.println("\n===============================");
            System.out.println("------------ Ries Co.----------");
            System.out.println("------------ Invoice ----------");
            System.out.println("===============================");
            //invoice header above
            System.out.println("Item: " + product1.getItemName());
            System.out.println("Invoice Number: "
                    + product1.getInvoiceNumber()); //good
            System.out.printf("Sales Amount: $%.2f\n",
                    product1.getSaleAmount());
            System.out.println("-----------------------------");
            System.out.printf("Sales Tax: $%.2f\n",
                    product1.calculateTax());
            System.out.printf("Shipping: $%.2f\n",
                    product1.calculateShipping()); //these could be get methods
            //as well so we know they are coming from the object.
            //gets do not always need an exact set match.
            System.out.println("-----------------------------");
            System.out.printf("Grand Total: $%.2f\n",
                    product1.calculateTotalCost());
            System.out.println("-----------------------------");

            //Ask user for another invoice? [While Loop 1]
            System.out.print("Generate another invoice? (y/n): ");
            //1st one eats the buffer
            inputDevice.nextLine();
            //trim and lower case input in case of whitespace and uppercase Y/N
            addInvoice = inputDevice.nextLine().trim().toLowerCase();

            while (switchLoop2) { //OK. Why not just test for y or n here?
                //set to false so it only happens once
                switchLoop2 = false;

                switch (addInvoice) {
                    case "y":
                        switchLoop = true;
                        break;

                    case "n":
                        anotherInvoice = false;
                        break;

                    default:
                        switchLoop2 = true;
                        System.out.print("\nOops! You inputed an invalid "
                                + "character! \nPlease answer only y or n: ");
                        //inputDevice.nextLine();
                        addInvoice = inputDevice.nextLine().trim().
                                toLowerCase();
                        break;
                }//end switch
            }//end addInvoice + error loop

        }//end anotherInvoice while 
    }//end main

}//end class

//Using boolean is OK in this one. It actually makes the logic a bit harder
//to follow rather than just using the range checks in the while loops or 
//testing for y/n in the repeat.






/* For use with hard challenge
            System.out.printf("Subtotal: $%.2f\n", 
                    product1.calculateSubtotal());
             */
