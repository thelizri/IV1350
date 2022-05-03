package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        runProgram();
    }

    private void runProgram(){
        controller.createNewSale();
        controller.scanItem(3,2); //2 bacon
        controller.scanItem(1,2); //2 milk
        controller.scanItem(1,1); //1 pack of eggs
        controller.discountRequest(5);
        boolean notPaid = true;
        while (notPaid){
            if(controller.pay(1)){
                notPaid=false;
            }
        }
        controller.endSale();
    }
}
