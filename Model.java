import java.util.LinkedList;
import java.util.ArrayList;

/***
 * Controls the business logic of the application.
 * It handles the expenses calculation
 */
public class Model {
    //I want this class to handle all the data and keep track of
    //the running expense
    //List for the expenses
    private ArrayList<Integer> expensesList = new ArrayList<>();
    private ArrayList<Integer> incomeList = new ArrayList<>();
    

    public void addToExpenses(int expense){
        expensesList.add(expense);
    }

    public void addToIncome(int income){
        incomeList.add(income);
    }

    public int caclulateTotal(){
        int totalExpenses = 0;
        int totalIncome = 0;
        for(int i =0; i < expensesList.size(); ++i){
            totalExpenses += expensesList.get(i);
        }
        for(int i =0; i < incomeList.size(); ++i){
            totalIncome += incomeList.get(i);
        }

        return totalIncome - totalExpenses;
    }
}
