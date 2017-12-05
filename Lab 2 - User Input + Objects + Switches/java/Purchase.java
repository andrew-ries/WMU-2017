 /*************************************
 * Programmer: Andrew Ries
 * classID: aries9242
 * Lab2: Sell-O-Tron
 * CIS 2600: Business Application Programming
 * Fall 2017
 * Due date: 10/30/2017
 * Date completed: 10/30/2017
 **************************************
 * Program Description:
 * !!For use with CreatePurchase.java - the main class.!! 
 * Please see CreatePurchase.java for Program Description
 *
 * LAB2 Requirements:
 * OBJECT-purchase.java: Each purchase contains an invoice number, amount of 
 * sale, and amount of sales tax. Include set methods for the invoice number 
 * and sale amount. 
 *  
 * Within the set() method for the sale amount, calculate the sales tax as 5% 
 * the sale amount. Also include a display method that displays a purchases 
 * details. 
 * 
 * 
 * This is the object class!
 * 
 * I am excited about it as well ;}
 ************************************* */

package lab2;

/**
 *
 * @author andrew-ries
 */
public class Purchase {
    //good.
    //Initialize variables
    public String itemName = " ";
    private int invoiceNumber = 0;
    private double saleAmount = 0;
    //Equation variables
    private double taxSubtotal = 0; //Tax Subtotal
    private double finalTotal = 0;
    private double shipAmount = 0;
    //Constants
    final private double SALESTAXRATE = .05; //5% of total = tax
    final private double SHIPPINGCOST = 14; //Edit Me For Shipping Change

    //Method to set the field value of integer invoice number
    public void setInvoiceNumber(int invoicenum) {
        invoiceNumber = invoicenum;
    }

    //Method to retrieve the field value of integer invoice number from main
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    
    //Method to set the field value of item name
    public void setItemName(String product) {
        itemName = product;
    }
    //Method to retrieve the field value of item name from main

    public String getItemName() {
        return itemName;
    }

    
    //Method to set the field value of double sales amount 
    public void setSaleAmount(double amount) {
        saleAmount = amount;
    }

    //Method to retrieve the field value of double sales amount from main
    public double getSaleAmount() {
        return saleAmount;
    }

    

    //method used to calculate tax. Base rate of 5% of item cost. 
    public double calculateTax() {
        taxSubtotal = (saleAmount * SALESTAXRATE);

        return taxSubtotal;
    }

    //Current shipping calculation is just a constant, but method can be 
    //used with more complicated shipping calculation
    
    //OK. Good addition.
    public double calculateShipping() {
        shipAmount = (SHIPPINGCOST);

        return shipAmount;
    }

    //Method to calculate the total
    //Total is calculated as User input sales amount + 5% tax + shipping
    public double calculateTotalCost() {
        finalTotal = (saleAmount + taxSubtotal + SHIPPINGCOST);

        return finalTotal;
    }

}

//This would have required an object array...


  /* For use with hard challenge

    //private double salesTax;
    //private double lineSubtotal = 0;

    public double calculateSubtotal() {
        lineSubtotal = (saleAmount);

        return lineSubtotal;
    }
    */
/*

Good object. Perhaps 
*/