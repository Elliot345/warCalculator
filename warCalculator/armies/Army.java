package warCalculator.armies;

public abstract class Army {
    private int strength;
    private double cost;
    private String name;

    public Army(int cost, int strength, String name) {
        this.cost = cost;
        this.strength = strength;
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }
    public double getCost() {
        return cost;
    }
    public String getName() {
        return name;
    }
}
