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
 *
 * This is the Salesperson object class used with CreateSalesperson Main Class.
 * This object class creates a public Salesperson object with 3 strings. The
 * string are then defined by userinput using getters and setters to the main
 * class.
 ************************************* */

package lab3;

/**
 *
 * @author andrew-ries
 *
 */
public class Salesperson {

    private String userID = " ";
    private String userName = " ";
    private String userSales = " ";

    //OK. So a constructor requiring all data.
    public Salesperson(String userID, String userName, String userSales) {
        this.userID = userID;
        this.userName = userName;
        this.userSales = userSales;
    }

    public void setUserID(String idnum) {
        this.userID = idnum;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return this.userName;
    }

    //Technically the only one we need here, but the others are
    //OK to include.
    public void setUserSales(String amount) {
        this.userSales = amount;
    }

    public String getUserSales() {
        return this.userSales;
    }

    /*
   public void display() {
        Salesperson Person;
        System.out.println("UID " + "Name " + "Sales_Amount ");
        for (int count = 0; count < salespeopleList.size(); count++) {
            Person = salespeopleList.get(count);
            System.out.println(Person.getUserID() + " "
                    + Person.getUserName() + " "
                    + Person.getUserSales());
        }
    }
     */
}
