package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;

/**
 * The view. It controls what is being outputted to the screen.
 */
public class View {
    private Controller controller;

    /**
     * Creates an instance of <code>View<code/>.
     * @param controller The controller class.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Runs a dummy program with calls to different classes and functions; to see that they work.
     */
    public void runDummyProgram(){
        System.out.println("View class calling createNewSale() method belonging to Controller class\n");
        controller.createNewSale();
        System.out.println("View class calling scanItem(3,2) method with parameters belonging to Controller class\n");
        controller.scanItem(3,2); //2 bacon
        System.out.println("View class calling scanItem(1,2) method with parameters belonging to Controller class\n");
        controller.scanItem(1,2); //2 milk
        System.out.println("View class calling scanItem(1,1) method with parameters belonging to Controller class\n");
        controller.scanItem(1,1); //1 pack of eggs
        System.out.println("View class calling discountRequest(5) method with parameters belonging to Controller class\n");
        controller.discountRequest(5);
        boolean notPaid = true;
        System.out.println("View class calling pay() method with parameters belonging to Controller class\n");
        while (notPaid){
            if(controller.pay(1)){
                notPaid=false;
            }
        }
        System.out.println("View class calling endSale() method belonging to Controller class\n");
        controller.endSale();
    }
}
