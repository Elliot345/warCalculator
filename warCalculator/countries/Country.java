package warCalculator.countries;

import warCalculator.armies.Army;

public abstract class Country {
    private double gold;
    private String displayName;

    public Country(String displayName) {
        this.displayName = displayName;
    }

    public void setGold(double amount) {
        gold = amount;
    }
    public double getGold() {
        return gold;
    }
    public abstract void addGold(double amount);
    public abstract double getCost(Army army, byte amount);

    public boolean canBuy(Army army, byte amount) {
        return getCost(army, amount) <= getGold();
    }
    public String getDisplayName() {
        return displayName;
    }
}
