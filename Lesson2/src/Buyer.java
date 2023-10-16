package src;

public abstract class Buyer implements BuyerBehaviour {
    protected final String name;
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;

    public Buyer(String name) {
        this.name = name;
    }

    public abstract String getName();
}
