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
 * This IS MAIN!
 * 
 * The main function of this application is to take user input for a package 
 * shipment. First we ask the user a series of questions to determine the
 * customer name, package weight, ship type, and insurance choice. 
 * 
 * We then create either a Package(superclass) object,
 * or an InsuredPackage(subclass) object based on the user selection. Using
 * the respective class files included.
 * 
 * Another part of this application is Exception handling. When we ask for 
 * weight input the user can potentially input non-digits. This throws an input
 * exception when the complier realizes that you cannot convert letters into a 
 * double. To resolve this without our application crashing, we encase the code
 * in a try block. After the try block we attempt to catch the specific 
 * exception and output a message of our own. 
 * 
 * This is again encased in a do...while loop so that we keep trying and 
 * catching the error until only a number is correctly entered. 
 * 
 * I do not think it was part of the assignment?... but non-input will crash
 * the application on the switches that require substring. This is because on
 * non-entry substring has no value to check. The Exception is
 * StringIndexOutOfBoundsException but I am not sure if wrapping all of those
 * in a try-catch would be better than just using radio buttons or 
 * checkboxes rather than input, so I didn't. 
 * 
 * PS: Would Enumerators be the most professional way to control user input? 
 ************************************* */

//=============================Watch the line==================================>
package lab4;

/**
 *
 * @author andrew-ries
 *
 */
import javax.swing.JOptionPane;


public class UsePackage {

    public static void main(String[] args) {

        String inputCustomer = " ";

        String inputWeight = " ";
        double packageWeight = 0;

        String inputShipChoice = " ";
        String shipSelect = " ";

        String inputInsureChoice = " ";
        String insureSelect = " ";

        
        //NAME INPUT
        inputCustomer = JOptionPane.showInputDialog(null,
                "Enter your customer's name",
                "Customer Name", JOptionPane.QUESTION_MESSAGE);

        
        //WEIGHT INPUT w/ TryCatch Exception 
        //Run once
        do {
            
            //try code in blocks for potential error to be caught by catch
            try {
                
                inputWeight = JOptionPane.showInputDialog(null,
                        "Enter the package weight (oz)",
                        "Package Weight", JOptionPane.QUESTION_MESSAGE);
                //convert string to integer
                packageWeight = Double.parseDouble(inputWeight);
                
                
                //it is not defined what to do with packages less than 1oz
                //so we do not allow them
                while (packageWeight < 1)
                {
                    JOptionPane.showMessageDialog(null, 
                            "Your Package is too light to ship!",
                                    "Too Light", JOptionPane.ERROR_MESSAGE);
                inputWeight = JOptionPane.showInputDialog(null,
                        "Enter the package weight (oz)",
                        "Package Weight", JOptionPane.QUESTION_MESSAGE);
                //convert string to integer
                packageWeight = Double.parseDouble(inputWeight);    
                }
                
                
                
                
            //catch block to catch Specified NumberFormatException
            } catch (NumberFormatException formatException) {
                //output error window if exception is caught
                JOptionPane.showMessageDialog(null, 
                        "You entered a character other than digits!", 
                        "Invaid Input", JOptionPane.ERROR_MESSAGE);

            }//end catch

            //repeat while....
            //Double.parseDouble returns a 0 if non-digit is entered
            //we also catch any negatives here for fun but dont tell the user
        } while (packageWeight == 0 || packageWeight < 0);

          

        //SHIPPING CHOICE
        inputShipChoice = JOptionPane.showInputDialog(null,
                "Please select a method of shipment"
                + "\n(A)ir "
                + "\n(T)ruck "
                + "\n(M)ail ",
                "Shipping Selection", JOptionPane.QUESTION_MESSAGE);

        //substring+uppercase to get first single letter for switch 
        //while also allowing the full word to be spelled and to standardize 
        //case
        shipSelect = inputShipChoice.substring(0, 1).toUpperCase();

        //Force user to enter correct input
        //while A, T, or M are not selected, ask again
        //ignorecase is not needed but im doubling down
        while (!(shipSelect.equalsIgnoreCase("A")
                || shipSelect.equalsIgnoreCase("T")
                || shipSelect.equalsIgnoreCase("M"))) {

            //notification of invalid input
            JOptionPane.showMessageDialog(null,
                    "Incorrect shipping type!", "OH NO",
                    JOptionPane.WARNING_MESSAGE);

            //ask again
            inputShipChoice = JOptionPane.showInputDialog(null,
                    "Please enter either A, T, or M"
                    + "\n(A)ir "
                    + "\n(T)ruck "
                    + "\n(M)ail ",
                    "Incorrect Input", JOptionPane.WARNING_MESSAGE);
            shipSelect = inputShipChoice.substring(0, 1).toUpperCase();

        }


     
        
        //INSURANCE CHOICE
        inputInsureChoice = JOptionPane.showInputDialog(null,
                "Would you like to add Insurance?"
                + "\n(Y)es "
                + "\n(N)o ",
                "Insurance Selection", JOptionPane.QUESTION_MESSAGE);
        //substring+uppercase to get first single letter for switch
        insureSelect = inputInsureChoice.substring(0, 1).toUpperCase();

        //force user to enter correct input
        //while Y or N are not selected, ask again
        while (!(insureSelect.equalsIgnoreCase("Y")
                || insureSelect.equalsIgnoreCase("N"))) {

            //ask again
            inputInsureChoice = JOptionPane.showInputDialog(null,
                    "Please enter either Y or N"
                    + "\n(Y)es "
                    + "\n(N)o ",
                    "Incorrect Input", JOptionPane.WARNING_MESSAGE);
            insureSelect = inputInsureChoice.substring(0, 1).toUpperCase();

        }

        
        //CREATE PACKAGE or INSURED PACKAGE based on user input
        switch (insureSelect) {
            case "N":
                //create no-insurance package
                Package packobj = new Package(inputCustomer,
                        packageWeight, shipSelect);
                
                //setters to package class
                packobj.setCustomerName(inputCustomer);
                packobj.setPackageWeight(packageWeight);
                packobj.setShippingType(shipSelect);

                //parent display
                packobj.display();

                break;

            case "Y":
                //create insurance package
                InsuredPackage inspack = new InsuredPackage(inputCustomer,
                        packageWeight, shipSelect);

                //setters to insured package class
                inspack.setCustomerName(inputCustomer);
                inspack.setPackageWeight(packageWeight);
                inspack.setShippingType(shipSelect);

                //overridden child method [see InsuredPackage.class]
                inspack.display();

                break;

        }

    }

}
