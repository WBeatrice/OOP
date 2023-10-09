package src;

public class BottleOfWater extends Product {
    private int volune;

    public BottleOfWater(String name, double price, int volune) {
        super(name, price);
        this.volune = volune;
    }

    public int getVolune() {
        return volune;
    }

}
