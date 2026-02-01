package org.example.restaurant_final;

public class TDrinkMachine extends TProcessingUnit {

    public TDrinkMachine() {
        super("Напитки", 2);
    }

    @Override
    public void process(TOrder order) {
        if (!order.needDrink()) return;

        int time = baseTime;

        if (random.nextInt(100) < 5) {
            order.addLog("Напитки: замена сиропа (+1 мин)");
            time += 1;
        }

        order.addTime(time);
        order.addStage("Напитки");
    }
}
