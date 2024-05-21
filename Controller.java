import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/***
 * Controls the interaction between the model and the view.
 * Takes input from the view and alerts the model
 */
public class Controller {

    private Model model;
    private View view;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
    }



    
}
