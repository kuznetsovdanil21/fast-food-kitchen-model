package org.example.restaurant_final;

import java.util.Random;

public abstract class TProcessingUnit {

    protected String name;
    protected int baseTime;
    protected boolean busy = false;
    protected int backlogTime = 0;

    protected Random random = new Random();

    public TProcessingUnit(String name, int baseTime) {
        this.name = name;
        this.baseTime = baseTime;
    }

    protected int calculateProcessingTime(TOrder order) {
        int time = baseTime;

        // если агрегат был занят предыдущим заказом
        if (busy) {
            order.addLog(name + ": занят предыдущим заказом (+"
                    + backlogTime + " мин)");
            time += backlogTime;
        }

        // 15% вероятность чистки оборудования
        if (random.nextInt(100) < 15) {
            order.addLog(name + ": требуется чистка оборудования (+3 мин)");
            time += 3;
        }

        // агрегат становится занятым
        busy = true;
        backlogTime = time / 2; // часть времени переносится на следующий заказ

        return time;
    }

    protected void release() {
        busy = false;
    }

    public abstract void process(TOrder order);
}
