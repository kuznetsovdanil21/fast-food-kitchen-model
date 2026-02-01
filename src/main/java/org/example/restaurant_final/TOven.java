package org.example.restaurant_final;

public class TOven extends TProcessingUnit {

    public TOven() {
        super("Печь", 6);
    }

    @Override
    public void process(TOrder order) {
        if (!order.needOven()) return;

        int time = calculateProcessingTime(order);

        order.addLog("Печь: длительный цикл запекания");
        order.addTime(time);
        order.addStage("Печь");

        release();
    }
}
