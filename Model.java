import java.util.ArrayList;

/***
 * Controls the business logic of the application.
 * It handles the expenses calculation
 */
public class Model {
    //I want this class to handle all the data and keep track of
    //the running expense
    //List for the expenses
    private ArrayList<String> expensesList;
    private ArrayList<String> incomeList;

    public Model(){
        expensesList = new ArrayList<>();
        incomeList = new ArrayList<>();
    }
    

    public void addToExpenses(String expense){
        expensesList.add(expense);
    }

    public void addToIncome(String income){
        incomeList.add(income);
    }

    public int caclulateTotal(){
        int totalExpenses = 0;
        int totalIncome = 0;
        for(int i =0; i < expensesList.size(); ++i){
            totalExpenses += Integer.valueOf(expensesList.get((i)));
        }
        for(int i =0; i < incomeList.size(); ++i){
            totalIncome += Integer.valueOf(incomeList.get((i)));
        }

        return totalIncome - totalExpenses;
    }
}
