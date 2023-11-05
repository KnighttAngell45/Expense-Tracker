package com.Expense.java;
// code intends to represent the individual expenses
public class Expense {   // creates objects that will represent the expenses


    private String date; // stores date of expense
    private String description;  // stores desp. of expense
    private double amount; // a double that stores monetary amount of expense

    // The above variables are pvt hence can only be accessed under variable class

    // The below is the CONSTRUCTOR , it initializes the instance variables.
    public Expense(String date, String description , double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }


    // These are getter methods that allow other classes to access the private instance variables. They provide read-only access to the date, description, and amount attributes of an Expense
    public String getDate(){
        return date;
    }

    public String getDescription(){
        return description;
    }

    public double getAmount(){
        return amount;
    }


    // This method overrides the toString method from the Object class.
    // It returns a string representation of the Expense object.
    // The returned string includes the values of the date, description,
    // and amount instance variables, making it easier to display the content
    // of an Expense object in a human-readable format.
 @Override
    public String toString(){
        return "Expense(date=" +date +", despcription=" + description + " , amount=" + amount + ")";
 }

}
