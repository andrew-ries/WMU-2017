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
 * This subclass is the child of parent[Package]
 * 
 * This class inherits variables and methods from Package denoted by extends. 
 * It also has variables to calculate insurance cost that is not an attribute of
 * its parent. 
 * 
 * We also override the display method inherited from parent so that we can
 * output in a slightly different manner to include insurance parameters.
 * 
 ************************************* */


//=============================Watch the line==================================>
package lab4;

import javax.swing.JOptionPane;

/**
 *
 * @author andrew-ries
 *
 */
//tell InsuredPackage that Package is his father(superclass)
public class InsuredPackage extends Package {

    //Insurance cost amounts
    private final double LOWINSURE = 2.45;
    private final double MIDINSURE = 3.95;
    private final double HIGHINSURE = 5.55;
    //calculation vars
    private double insuranceCost = 0;
    private double totalCost = 0;

    //constuctor
    public InsuredPackage(String customerName,
            double packageWeight, String shippingType) {

        //inherits vars from superclass using super constuctor
        super(customerName, packageWeight, shippingType);

        
        //I decided against final vars for the range check limits here because 
        //it seems easier to read without referencing variables and 
        //because the length of code is short
        
        //Check Total Shipping cost before adding insurance. 
        
        //Cost is 0 to 0.999
        if (shippingCost > 0 && shippingCost <= 1) {

            totalCost = shippingCost + LOWINSURE;
            insuranceCost = LOWINSURE;
        } 

        //Cost is 1 to 3
        else if (shippingCost > 1 && shippingCost <= 3) {

            totalCost = shippingCost + MIDINSURE;
            insuranceCost = MIDINSURE;
        } 
        
        //Cost is greater than 3
        else {
            totalCost = shippingCost + HIGHINSURE;
            insuranceCost = HIGHINSURE;
        }

        
    }

    //method to display output in main 
    //override parent class so that we can use the same method but have 
    //different ouput
    @Override
    public void display() {

        JOptionPane.showMessageDialog(null,
                "=========================================================="
                + "\n~~~~~~~~~~~~~~~~~~~~ANDREW's COMPANY~~~~~~~~~~~~~~~~~~~~"
                + "\n=========================================================="
                + "\nThis package is for: " + customerName
                + "\nShipment Code: " + shippingType
                + "\nShipment Weight: " + packageWeight + " oz"
                + "\nShipment Cost: $" + String.format("%,.2f", shippingCost)
                + "\nInsurance Cost: $" + String.format("%,.2f", insuranceCost)
                + "\nThe total cost of shipping comes to: $"
                + String.format("%,.2f", totalCost));
    }

}
