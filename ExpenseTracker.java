


public class ExpenseTracker{

    public static void main(String[] args){

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model); //Used to interact with both the view and model
    }
}