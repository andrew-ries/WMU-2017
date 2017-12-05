/** ***********************************
 * Programmer: Andrew Ries
 * classID: aries9242
 * Lab3: SalesTracker
 * CIS 2600: Business Application Programming
 * Fall 2017
 * Due date: 11/18/2017
 * Date completed: 11/19/2017
 **************************************
 * Program Explanation
 * HARD: Dynamic Object Array = java util arraylist
 * Nice
 *
 *This program allows a sales manager to add, edit, delete, and sort all of the
 * salesperson objects they want. This is all in a dynamic array called an 
 * arraylist rather than a regular array. 
 * 
 * This program has a main menu where add, edit, sort, delete, and quit are 
 * available as options via a switch
 * 
 * Add adds a new element to the array in order. 
 *  - Add checks to make sure there are no duplicates and exactly 8 characters.
 *  - We also check to make sure that client specified array size is 19 or less
 *    before input
 * 
 * 
 * Edit takes user input and changes the selected element with new input. 
 * Delete takes user input and removes the selected element with new input.
 * Sort takes user input for an attribute and sorts in ascending order.
 *  - Sort has nested switch
 * 
 * Quit is the only way out of the program because it is wrapped in an
 * inf while loop
 * 
 * At the end of every switch option you have the choice to display the array
 * 
 * 
 * Self Criticisms:
 * Sort uses lambda expressions that I need to revisit... and understand better 
 * Learn how to use methods..... ya i know...
 * Use multiple scanner objects to avoid having to flush buffer.
 ************************************* */
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator; No sort?

/**
 *
 * @author andrew-ries
 *
 */
public class CreateSalesperson {

    public static void main(String[] args) {

        //vars
        //MENU Nav
        String menuSelect = " ";
        String listSelect = " ";

        //ADD
        String userIdString = " ";
        String userName = " ";
        String userSales = " ";
        //We do not want to go over 20 objects for assignment
        final int ARRAYCAP = 20;

        //EDIT
        int userEdit = 0;
        String userEditID = " ";
        String userEditName = " ";
        String userEditAmount = " ";

        //DELETE
        int userDelete = 0;
        String confirmDelete = " ";

        //SORT
        String sortSelect = " ";

        //LOOP default is false
        boolean reLoop = true;

        //create scanner object to obtain input using inputDevice
        Scanner inputDevice = new Scanner(System.in);
        //Creates an array list (named salespeopleList
        //to store objects(Salesperson)
        
        //Good
        ArrayList<Salesperson> salespeopleList = new ArrayList<>(ARRAYCAP);

        //Container Loop for entire program, infinite - only way out is sys.exit
        while (reLoop = true) {

            //MAIN MENU---------------------------------------------------------
            System.out.println("\nWhat would you like to do today?");
            System.out.println("(A)dd a Record");
            System.out.println("(E)dit a Record");
            System.out.println("(D)elete a Record");
            System.out.println("(S)ort the List");
            System.out.println("(Q)uit");
            System.out.print("Please enter in your choice: ");
            //toUpperCase so that lowercase input still works
            menuSelect = inputDevice.nextLine().toUpperCase();

            //While not any of the "correct input", ask again. 
            
            //OK
            while (!(menuSelect.equalsIgnoreCase("A")
                    || menuSelect.equalsIgnoreCase("E")
                    || menuSelect.equalsIgnoreCase("D")
                    || menuSelect.equalsIgnoreCase("S")
                    || menuSelect.equalsIgnoreCase("Q"))) {

                System.out.println("\nYou entered an incorrect value!\n "
                        + "\nPlease try again using the corresponding "
                        + "letter in parentheses: ");
                System.out.println("(A)dd a Record");
                System.out.println("(E)dit a Record");
                System.out.println("(D)elete a Record");
                System.out.println("(S)ort the List");
                System.out.println("(Q)uit");
                System.out.print("Please enter in your choice: ");
                menuSelect = inputDevice.nextLine().toUpperCase();

            }
            //MAIN MENU---------------------------------------------------------
            //SWITCH FOR OPTIONS------------------------------------------------
            switch (menuSelect) {
                //ADD-----------------------------------------------------------
                case "A": //Why not call a method here?

                    //While Array is less than 20, you can add
                    if (salespeopleList.size() < ARRAYCAP) {

                        System.out.print("\nPlease enter your UID: ");
                        userIdString = inputDevice.nextLine();

                        //------------------------------------------------------
                        //ask again while length is anything but 8 characters
                        //I assume digits but you did say characters in handout
                        while ((userIdString.length() != 8)) { //constant
                            System.out.print("\nPlease enter 8 digits for "
                                    + "your UID: ");
                            userIdString = inputDevice.nextLine();

                            //foreach objectclass obj in arraylist....
                            //this iterates through each obj in arraylist
                            for (Salesperson sp : salespeopleList) {
                                //while obj UserID equals user input...
                                //tell them they entered a duplicate and ask 
                                //again
                                while (sp.getUserID().equals(userIdString)) {

                                    System.out.println("\nYou entered a "
                                            + "duplicate ID! That's no good. "
                                            + "Let try again with a different "
                                            + "one. ");
                                    System.out.print("\nPlease enter "
                                            + "your UID: ");
                                    userIdString = inputDevice.nextLine();

                                }
                            }

                            //--------------------------------------------------
                        }

                        //Repeat again in reverse order
                        //because this works and I dont know how 
                        //to use catch yet
                        //this prevents less than 8 digits after duplicate check
                        //or entering a duplicate after 8 digits check
                        //Fair enough.
                        for (Salesperson sp : salespeopleList) {

                            while (sp.getUserID().equals(userIdString)) { //OK

                                System.out.println("\nYou entered a duplicate "
                                        + "ID! That's no good. Let try again "
                                        + "with a different one. ");
                                System.out.print("\nPlease enter your UID: ");
                                userIdString = inputDevice.nextLine();

                            }

                            while ((userIdString.length() != 8)) {
                                System.out.print("\nPlease enter 8 digits for "
                                        + "your UID: ");
                                userIdString = inputDevice.nextLine();
                            }
                        }

                        //------------------------------------------------------
                        //Ask for name
                        System.out.print("\nPlease enter your name: ");
                        userName = inputDevice.nextLine();
                        //Ask for sales
                        System.out.print("\nPlease enter your sales amount: $");
                        userSales = inputDevice.nextLine();

                        //
                        //Leave this here for testing 20 
                        //for (int count = 0; count < 20; ++count) {
                        //
                        //Here we create a new object from the salesperson class
                        //with the user input
                        Salesperson addPerson = new Salesperson(userIdString,
                                userName, userSales);
                        addPerson.setUserID(userIdString);
                        addPerson.setUserName(userName);
                        addPerson.setUserSales(userSales);

                        //ADD TO NEXT ELEMENT IN ARRAY
                        salespeopleList.add(addPerson);
                        //}

                    }//End If Checking for less than 20 
                    //else array is less than 20
                    else {
                        System.out.println("\nThe list has reached its capacity"
                                + " of 20 set by the department manager. If you"
                                + " would like to change the size of this list,"
                                + " adjust the constant.");
                    }

                    break;//End case A
                //ADD-----------------------------------------------------------

                //EDIT----------------------------------------------------------
                case "E":

                    System.out.print("\nPlease enter the element in the list "
                            + "you would like to change: ");
                    //Perhaps note the numbers again. It's not clear from the
                    //interface.
                    userEdit = inputDevice.nextInt();

                    //Here we call the arraylist and set it to editPerson
                    //Then user input dictates what row is selected
                    //-1 because java starts inded at 0
                    //Good, but it needs to be clearer in the prompt you want
                    //a number of the array element.
                    Salesperson editPerson = salespeopleList.get(userEdit - 1);

                    //Reminder
                    System.out.println("You are about to edit: "
                            + editPerson.getUserID() + " "
                            + editPerson.getUserName() + " "
                            + editPerson.getUserSales());

                    //
                    //I realize I need to check again here but im running out of
                    //space because idk how to method.
                    //
                    System.out.println("\nPlease enter new ID: ");
                    //flush buffer
                    inputDevice.nextLine();
                    userEditID = inputDevice.nextLine();

                    System.out.println("\nPlease enter new Name: ");
                    userEditName = inputDevice.nextLine();

                    System.out.println("\nPlease enter new Amount: ");
                    userEditAmount = inputDevice.nextLine();

                    salespeopleList.get(userEdit - 1).setUserID(userEditID);
                    salespeopleList.get(userEdit - 1).setUserName(userEditName);
                    salespeopleList.get(userEdit - 1)
                            .setUserSales(userEditAmount);

                    break;
                //EDIT----------------------------------------------------------   

                //DELETE--------------------------------------------------------  
                case "D":
                    //Nice addition.
                    System.out.print("\nPlease enter the element in the List "
                            + "you would like to delete: ");
                    userDelete = inputDevice.nextInt();

                    Salesperson deletePerson = salespeopleList
                            .get(userDelete - 1);

                    System.out.println("\nYou are about to delete: "
                            + deletePerson.getUserID() + " "
                            + deletePerson.getUserName() + " "
                            + deletePerson.getUserSales());

                    System.out.println("Are you sure you want to delete this "
                            + "record? (Y/N): ");
                    //flush buffer
                    inputDevice.nextLine();
                    confirmDelete = inputDevice.nextLine().toUpperCase();

                    if (confirmDelete.equals("Y")) {
                        salespeopleList.remove(userDelete - 1);
                        System.out.println("Successfully Deleted");
                    }

                    break;
                //DELETE--------------------------------------------------------  

                //SORT----------------------------------------------------------  
                case "S":
                    System.out.println("\nWelcome to the sorter!\n");

                    Salesperson Person;

                    //display table before selection
                    System.out.println("UID " + "Name " + "Sales_Amount ");
                    for (int count = 0; count < salespeopleList.size();
                            count++) {
                        Person = salespeopleList.get(count);
                        System.out.println(Person.getUserID() + " "
                                + Person.getUserName() + " "
                                + Person.getUserSales());

                    }

                    System.out.println("\nHow would you like to sort today?: ");

                    System.out.println("(U)ser ID Sort");
                    System.out.println("(N)ame Sort");
                    System.out.println("(S)ales Sort");
                    System.out.print("Please enter in your choice: ");
                    //toUpperCase so that lowercase input still works
                    sortSelect = inputDevice.nextLine().toUpperCase();

                    //While not any of the "correct input", ask again. 
                    while (!(sortSelect.equalsIgnoreCase("U")
                            || sortSelect.equalsIgnoreCase("N")
                            || sortSelect.equalsIgnoreCase("S"))) {

                        System.out.println("\nYou entered an incorrect value!\n"
                                + " \nPlease try again using the corresponding "
                                + "letter in parentheses: ");
                        System.out.println("(U)ser ID Sort");
                        System.out.println("(N)ame Sort");
                        System.out.println("(S)ales Sort");
                        System.out.print("Please enter in your choice: ");
                        sortSelect = inputDevice.nextLine().toUpperCase();

                    }
                    //MAIN MENU-------------------------------------------------
                    //SWITCH FOR OPTIONS----------------------------------------
                    switch (sortSelect) {
                        //ADD---------------------------------------------------
                        case "U":

                           
                            /*
                            Collections.sort is a util. class used to sort lists
                            and arraylists. 
                            
                            A lambda expression is a function that can exist 
                            without a class. It can be passed as if it were an 
                            object. This is useful so you do not have to create
                            a Compartaor object and then override the compare 
                            method to take 2 objects... all while inside  
                            Collections.sort
                            
                            You apparently do not need to import the comparator
                            class for this, so I will admit I still dont 
                            completely understand how it works. 
                            
                            But I do know that it compares both object strings
                            that the user specifies and then that compare 
                            iterates through each element sorting the array 
                            (and its objects) in
                            ascending order. 
                             */
                            Collections.sort(salespeopleList, (obj1, obj2) 
                                    -> obj1.getUserID()
                                            .compareTo(obj2.getUserID()));
                            System.out.println("Successfully Sorted!");
                            break;

                        case "N":
                            Collections.sort(salespeopleList, (obj1, obj2) 
                                    -> obj1.getUserName()
                                            .compareTo(obj2.getUserName()));
                            System.out.println("Successfully Sorted!");

                            break;

                        case "S":
                            Collections.sort(salespeopleList, (obj1, obj2) 
                                    -> obj1.getUserSales()
                                            .compareTo(obj2.getUserSales()));
                            System.out.println("Successfully Sorted!");

                            break;
                        default:

                    }//END SORT SWITCH   
                    break;
                //SORT----------------------------------------------------------

                //QUIT----------------------------------------------------------   
                case "Q":
                    System.out.println("\nYou are now exiting the program."
                            + " Goodbye.");
                    //exit argument 0 non-error exit
                    System.exit(0);
                //QUIT----------------------------------------------------------
                default:

            }//END SWITCH 

            //DISPLAY-----------------------------------------------------------
            System.out.println("\nWould you like to "
                    + "display your list? (Y/N): ");
            listSelect = inputDevice.nextLine().toUpperCase();

            if (listSelect.equals("Y")) {

                Salesperson Person;

                System.out.println("UID " + "Name " + "Sales_Amount ");
                for (int count = 0; count < salespeopleList.size(); count++) {
                    Person = salespeopleList.get(count);
                    System.out.println(Person.getUserID() + " "
                            + Person.getUserName() + " "
                            + Person.getUserSales());

                }

                System.out.print("\nPress enter to return to main menu");
                inputDevice.nextLine();//
            }
            //DISPLAY-----------------------------------------------------------

        }//RELOOP. GO BACK TO START.

    }//END MAIN

}//END CLASS

