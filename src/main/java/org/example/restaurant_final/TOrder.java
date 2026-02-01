package org.example.restaurant_final;

import java.util.ArrayList;
import java.util.List;

public class TOrder {

    private int id;
    private int totalTime = 0;

    private boolean grill;
    private boolean fryer;
    private boolean oven;
    private boolean drink;

    private List<String> completedStages = new ArrayList<>();
    private List<String> log = new ArrayList<>();

    public TOrder(int id, boolean grill, boolean fryer,
                  boolean oven, boolean drink) {
        this.id = id;
        this.grill = grill;
        this.fryer = fryer;
        this.oven = oven;
        this.drink = drink;
    }

    public void addTime(int t) {
        totalTime += t;
    }

    public void addStage(String stage) {
        completedStages.add(stage);
    }

    public void addLog(String s) {
        log.add(s);
    }

    public int getTotalTime() {
        return totalTime;
    }

    public List<String> getLog() {
        return log;
    }

    public int getId() {
        return id;
    }

    public boolean needGrill() { return grill; }
    public boolean needFryer() { return fryer; }
    public boolean needOven() { return oven; }
    public boolean needDrink() { return drink; }
}
