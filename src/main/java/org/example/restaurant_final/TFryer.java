package org.example.restaurant_final;

public class TFryer extends TProcessingUnit {

    private static int queue = 0;

    public TFryer() {
        super("Фритюрница", 4);
    }

    @Override
    public void process(TOrder order) {
        if (!order.needFryer()) return;

        queue++;

        int time = calculateProcessingTime(order);
        time += queue; // очередь усиливает задержку

        order.addLog("Фритюрница: очередь = " + queue);
        order.addTime(time);
        order.addStage("Фритюрница");

        queue--;
        release();
    }
}
