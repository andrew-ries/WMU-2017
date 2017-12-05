/** ***********************************
 * Programmer: Andrew Ries
 * classID: aries9242
 * Lab4: You Ship
 * CIS 2600: Business Application Programming
 * Fall 2017
 * Due date: 12/01/2017
 * Date completed: 12/02/2017
 **************************************
 * Program Explanation
 *
 * This superclass is the parent of child[InsuredPackage]
 * 
 * The main function of this class is to define methods to set user input, 
 * define the object constructor, 
 * define what the shipping cost is, and display the output of a 
 * non-insured package selection. 
 * 
 * This class also contains variables and data 
 * used by the InsuredPackage child. So if InsuredPackage is selected in main, 
 * when the InsuredPackage object is created, 
 * it uses this class first(defined by super in InsuredPackage.class), 
 * including the calculate cost method, then continues to run code specific to
 * it, in its own constructor and class file.
 * 
 ************************************* */

//=============================Watch the line==================================>
package lab4;

/**
 *
 * @author andrew-ries
 *
 */
import javax.swing.JOptionPane;

public class Package {

    //protected so child class can access
    protected String customerName = " ";
    protected double packageWeight = 0;
    protected String shippingType = " ";
    protected double shippingCost = 0;
    

    //Package Weight Bounds Constants
    private final double SMALLWEIGHTLL = 1;
    private final double SMALLWEIGHTUL = 9;
    private final double LARGEWEIGHTUL = 17;

    //Package Shipping Cost Constants
    private final double AIRSHIPLOW = 2.00;
    private final double AIRSHIPMID = 3.00;
    private final double AIRSHIPHIGH = 4.50;

    private final double TRUCKSHIPLOW = 1.50;
    private final double TRUCKSHIPMID = 2.35;
    private final double TRUCKSHIPHIGH = 3.25;

    private final double MAILSHIPLOW = .50;
    private final double MAILSHIPMID = 1.50;
    private final double MAILSHIPHIGH = 2.15;

    //Package constructor
    public Package(String customerName, double packageWeight, 
            String shippingType) {
        
        //define as superclass to be used with a subclass[InsuredPackage]
        super();
        this.customerName = customerName;
        this.packageWeight = packageWeight;
        this.shippingType = shippingType;
        //run calculate cost when constructed
        calculateCost();

    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setPackageWeight(double weight) {
        this.packageWeight = weight;
    }

    public void setShippingType(String type) {
        this.shippingType = type;
    }


    //CalculateCost Method
    //First this method checks the range of the weight provided by the user
    //to decide what switch block to use
    //Then shippingCost is selected based on shippingType input
    public void calculateCost() {
        //Package weight is between 1-8.999
        if (packageWeight < SMALLWEIGHTUL && packageWeight >= SMALLWEIGHTLL) {

            switch (shippingType) {
                case "A":
                    shippingCost = AIRSHIPLOW;
                    break;

                case "T":
                    shippingCost = TRUCKSHIPLOW;
                    break;

                case "M":
                    shippingCost = MAILSHIPLOW;
                    break;
            }

        } //Large Sized
        //Package weight is 17 or greater 
        else if (packageWeight >= LARGEWEIGHTUL) {
            switch (shippingType) {
                case "A":
                    shippingCost = AIRSHIPHIGH;
                    break;

                case "T":
                    shippingCost = TRUCKSHIPHIGH;
                    break;

                case "M":
                    shippingCost = MAILSHIPHIGH;
                    break;
            }
        } //Mid Sized
        //Package weight is between 9-16.999
        else if (packageWeight >= SMALLWEIGHTUL 
                && packageWeight < LARGEWEIGHTUL) {
            switch (shippingType) {
                case "A":
                    shippingCost = AIRSHIPMID;
                    break;

                case "T":
                    shippingCost = TRUCKSHIPMID;
                    break;

                case "M":
                    shippingCost = MAILSHIPMID;
                    break;
                    
            }
            
        }
        
        
        
        //NOT IN USE package is less than 1 
        else {
                    }
    }//end calculatecost

    //method to display output in main ...  note: insurance not included
    public void display() {
        JOptionPane.showMessageDialog(null,
                "=========================================================="
                + "\n~~~~~~~~~~~~~~~~~~~~ANDREW's COMPANY~~~~~~~~~~~~~~~~~~~~"
                + "\n=========================================================="
                + "\nThis package is for: " + customerName
                + "\nShipment Code: " + shippingType
                + "\nShipment Weight: " + packageWeight + " oz"
                + "\nThe total cost of shipping comes to: $"
                + String.format("%,.2f", shippingCost));
    }

}
