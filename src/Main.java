/**
 * The Main class is the entry point for the Expense Tracker application.
 * It allows users to add new expenses, view existing expenses, and exit the program.
 *
 * The application loads existing expenses from a text file and saves new expenses
 * to the same file, providing persistence across program runs.
 */
import java.util.Scanner;
import com.Expense.java.Expense;
import com.Expense.java.ExpenseTracker;
import java.util.ArrayList;
public class Main {

    /**
     * The main method is the entry point of the application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Load existing expenses from the text file
        ArrayList<Expense> expenses = ExpenseTracker.loadExpenses();

        // Main menu loop
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Expense
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    scanner.nextLine(); // Consume newline left over
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(date, desc, amount));
                    // Save the updated expenses to the text file
                    ExpenseTracker.saveExpenses(expenses);
                    break;
                case 2:
                    // View Expenses
                    for (Expense e : expenses) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    // Exit the program
                    System.out.println("Goodbye!");
                    return;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        }
    }
}
