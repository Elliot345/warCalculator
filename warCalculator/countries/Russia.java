package warCalculator.countries;

import warCalculator.armies.Army;

/**
 * Buff:       Cheap Labor  :       Russia buys scouts, military, and legions for half-price
 * Negative:   Bad R&D      :    Russia buys anything else for double-price
 */
public class Russia extends Country {

    public Russia() {
        super("Russia");
    }

    @Override
    public void addGold(double amount) {
        setGold(getGold() + amount);
    }
    public double getCost(Army army, byte amount) {
        if (army.getName() == "Military" || army.getName() == "Legion") {
            return army.getCost() * amount * 0.75;
        } else {
            return army.getCost() * amount * 2;
        }
    }
}
