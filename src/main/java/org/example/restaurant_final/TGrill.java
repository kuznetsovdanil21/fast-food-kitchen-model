package org.example.restaurant_final;

public class TGrill extends TProcessingUnit {

    public TGrill() {
        super("Гриль", 5);
    }

    @Override
    public void process(TOrder order) {
        if (!order.needGrill()) return;

        int time = calculateProcessingTime(order);


        if (random.nextInt(100) < 20) {
            order.addLog("Гриль: котлета подгорела (+2 мин)");
            time += 2;
        }

        order.addTime(time);
        order.addStage("Гриль");

        release();
    }
}
