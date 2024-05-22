import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/***
 * Controls the interaction between the model and the view.
 * Takes input from the view and alerts the model
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;

        this.view.setIncomeButtonActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addToIncome();
            }
        });

        this.view.setExpenseButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToExpenses();
            }
        });

        this.view.setTotalButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        this.view.setResetButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAll();
            }
        });
    }

    private void addToIncome() {
        String income = view.getCurrentIncome();
        model.addToIncome(income);
        view.addIncome(income);
        view.clearIncomes();

    }

    private void addToExpenses(){
        String expense = view.getCurrentExpense();
        model.addToExpenses(expense);
        view.addExpense(expense);
        view.clearExpenses();
    }

    private void calculateTotal(){
        String total = String.valueOf(model.caclulateTotal());
        view.getRunningTotal(total);

    }

    private void resetAll(){
        model.resetAll();
        view.resetAll();
    }
}

