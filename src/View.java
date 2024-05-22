import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class View {

    private JFrame frame;
    private JPanel incomePanel;
    private JPanel expensePanel;
    private JPanel totalPanel;
    private JButton incomeButton;
    private JButton expenseButton;
    private JTextField incomes;
    private JTextField expenses;
    private JLabel runningTotal;
    private JScrollPane expenseScrollPane;
    private JScrollPane incomeScrollPane;
    private JButton totalButton;
    private JScrollPane totalScrollPane;
    private JButton resetButton;

    public View(){
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 400);
        frame.setLayout(new GridLayout(1, 2));

        //Panel setups
        expensePanel = new JPanel();
        expensePanel.setLayout(new BoxLayout(expensePanel, BoxLayout.Y_AXIS));
        incomePanel = new JPanel();
        incomePanel.setLayout(new BoxLayout(incomePanel, BoxLayout.Y_AXIS));
        totalPanel = new JPanel();
        totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));
       
        //Button Setup
        incomeButton = new JButton("Add income");
        expenseButton = new JButton("Add expense");
        totalButton = new JButton("Calculate Total");
        resetButton = new JButton("Reset to Default");

        //Text Field Setup
        incomes = new JTextField(15);
        expenses = new JTextField(15);
        runningTotal = new JLabel("Current Total: " + getFiledata());

        
        //Scroll Pane Setup
        expenseScrollPane = new JScrollPane(expensePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        incomeScrollPane = new JScrollPane(incomePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        totalScrollPane = new JScrollPane(totalPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        // Set borders with titles
        expenseScrollPane.setBorder(BorderFactory.createTitledBorder("Expenses"));
        incomeScrollPane.setBorder(BorderFactory.createTitledBorder("Income"));
        totalScrollPane.setBorder(BorderFactory.createTitledBorder("Running total"));


        JPanel expenseWrapperPanel = new JPanel();
        expenseWrapperPanel.add(expenses);
        expenseWrapperPanel.add(expenseButton);

        JPanel incomeWrapperPanel = new JPanel();
        incomeWrapperPanel.add(incomes);
        incomeWrapperPanel.add(incomeButton);

        JPanel buttonLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonLabelPanel.add(totalButton);
        buttonLabelPanel.add(runningTotal);

        JPanel totalWrapperPanel = new JPanel();
        JPanel resetButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resetButtonPanel.add(resetButton);
        totalWrapperPanel.setLayout(new BoxLayout(totalWrapperPanel, BoxLayout.Y_AXIS));
        totalWrapperPanel.add(buttonLabelPanel);
        totalWrapperPanel.add(resetButtonPanel);

        



        totalPanel.add(totalWrapperPanel);
        incomePanel.add(incomeWrapperPanel);
        expensePanel.add(expenseWrapperPanel);
        // Add scroll panes to the main frame
        frame.add(expenseScrollPane);
        frame.add(incomeScrollPane);
        frame.add(totalScrollPane);

        frame.setVisible(true);

    }

    public String getFiledata() {
        File data = new File("data.txt");
        Scanner scanner = null;
        String previousTotal = "";
        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                previousTotal = scanner.next();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return previousTotal;

    }

    public void setIncomeButtonActionListener(ActionListener actionListener){
        incomeButton.addActionListener(actionListener);
    }
    public void setExpenseButtonActionListener(ActionListener actionListener){
        expenseButton.addActionListener(actionListener);
    }
    public void setTotalButtonActionListener(ActionListener actionListener){
        totalButton.addActionListener(actionListener);
    }
    public void setResetButtonActionListener(ActionListener actionListener){
        resetButton.addActionListener(actionListener);
    }

    public String getCurrentExpense(){
        return expenses.getText();
    }

    public String getCurrentIncome(){
        return incomes.getText();
    }

    public void clearIncomes(){
        incomes.setText("");
    }

    public void clearExpenses(){
        expenses.setText("");
    }

    public void addExpense(String expense){
        expensePanel.add(new JLabel(expense));
        frame.revalidate();
        frame.repaint();
    }

    public void getRunningTotal(String total){
        runningTotal.setText(total);
    }

    public void addIncome(String income){
        incomePanel.add(new JLabel(income));
        frame.revalidate();
        frame.repaint();
    }

    public void resetAll() {
        clearIncomes();
        clearExpenses();
    
        incomePanel.removeAll();
        expensePanel.removeAll();
    
        // Add the input fields and buttons back to the panels
        JPanel incomeWrapperPanel = new JPanel();
        incomeWrapperPanel.add(incomes);
        incomeWrapperPanel.add(incomeButton);
        incomePanel.add(incomeWrapperPanel);
    
        JPanel expenseWrapperPanel = new JPanel();
        expenseWrapperPanel.add(expenses);
        expenseWrapperPanel.add(expenseButton);
        expensePanel.add(expenseWrapperPanel);
    
        // Reset the running total label
        runningTotal.setText("Current Total: 0");
    
        frame.revalidate();
        frame.repaint();
    }
    
}
