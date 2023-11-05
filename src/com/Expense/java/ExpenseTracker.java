// This codee is responsible for saving and loading expenses to and from a text file.
// This class is designed to work in conjunction with the Expense class you previously defined.


package com.Expense.java;

import java.io.*;
import java.util.ArrayList;
// These import statements bring in necessary classes for file I/O and working with ArrayLists.
public class ExpenseTracker {

    private static final String FILENAME = "expenses.txt";
// This line declares a constant FILENAME that represents the name of the text file where expenses will be saved and loaded. In this case, it's set to "expenses.txt."


    public static void saveExpenses(ArrayList<Expense> expenses) {  // It takes an ArrayList of Expense objects as a parameter, representing the list of expenses to be saved.
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME)))  { // try specifies the FILENAME as suggested above using printwrite
            for (Expense e : expenses) {
                writer.println(e.getDate() + "," + e.getDescription() + "," + e.getAmount());
            }
        } catch(IOException e){
            System.out.println("Error saving expenses :" + e.getMessage());
        }

    }

    public static ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                expenses.add(new Expense(parts[0], parts[1], Double.parseDouble(parts[2])));
            }
        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }

        return expenses;

    }
}
