import java.awt.Label;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View {

    private JFrame frame;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;


    public View(){
        frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        button1 = new JButton("Add Expense");
        button2 = new JButton("Add Income");
        label1 = new JLabel("Expense List");
        label2 = new JLabel("Income List");

        frame.setLayout(new java.awt.BorderLayout());
        frame.add(button1, java.awt.BorderLayout.SOUTH);
        frame.add(button2, java.awt.BorderLayout.SOUTH);
        frame.add(label1, java.awt.BorderLayout.CENTER);
        frame.add(label2, java.awt.BorderLayout.CENTER);

        frame.setVisible(true);

    }

    public void setButtonActionListeners(ActionListener actionListener){
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }

    public void addLabel(String text){
        label1.se
    }

}
