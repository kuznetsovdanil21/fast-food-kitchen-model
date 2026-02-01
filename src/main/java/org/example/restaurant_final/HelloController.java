package org.example.restaurant_final;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

public class HelloController {

    @FXML private CheckBox grillCheck;
    @FXML private CheckBox fryerCheck;
    @FXML private CheckBox ovenCheck;
    @FXML private CheckBox drinkCheck;

    @FXML private TextArea outputArea;

    private int orderCounter = 0;


    private final TProcessingUnit grill = new TGrill();
    private final TProcessingUnit fryer = new TFryer();
    private final TProcessingUnit oven = new TOven();
    private final TProcessingUnit drink = new TDrinkMachine();

    @FXML
    public void onCreateOrder() {

        TOrder order = new TOrder(
                ++orderCounter,
                grillCheck.isSelected(),
                fryerCheck.isSelected(),
                ovenCheck.isSelected(),
                drinkCheck.isSelected()
        );

        outputArea.appendText("Заказ №" + order.getId() + "\n");

        grill.process(order);
        fryer.process(order);
        oven.process(order);
        drink.process(order);

        TAssemblingTable table = new TAssemblingTable();
        table.assemble(order);

        for (String log : order.getLog()) {
            outputArea.appendText(" - " + log + "\n");
        }

        outputArea.appendText(
                "Общее время: " + order.getTotalTime() + " мин\n\n"
        );
    }
}
