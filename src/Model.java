import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

/***
 * Controls the business logic of the application.
 * It handles the expenses calculation
 */
public class Model {
    // I want this class to handle all the data and keep track of
    // the running expense
    // List for the expenses
    private ArrayList<String> expensesList;
    private ArrayList<String> incomeList;
    private String previousTotal = "0";

    public Model() {
        expensesList = new ArrayList<>();
        incomeList = new ArrayList<>();
        getFiledata();

    }

    public void getFiledata() {
        File data = new File("data.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                previousTotal = scanner.next();
                System.out.println(previousTotal);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

    }

    public void writeData(String data) {
        String file = "data.txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error closing FileWriter: " + e.getMessage());
                }
            }
        }
    }

    public void addToExpenses(String expense) {
        expensesList.add(expense);
    }

    public void addToIncome(String income) {
        incomeList.add(income);
    }

    public int caclulateTotal() {
        int totalExpenses = 0;
        int totalIncome = 0;
        for (int i = 0; i < expensesList.size(); ++i) {
            totalExpenses += Integer.valueOf(expensesList.get((i)));
        }
        for (int i = 0; i < incomeList.size(); ++i) {
            totalIncome += Integer.valueOf(incomeList.get((i)));
        }
        int total = totalIncome - totalExpenses + Integer.valueOf(previousTotal);

        writeData(String.valueOf(total));
        return total;
    }

    public void resetAll(){
        incomeList.clear();
        expensesList.clear();
        previousTotal = "0";
        writeData(previousTotal);
    }
}
