package src;

public interface BuyerBehaviour {
    void setMakeOrder(boolean makeOrder);

    void setTakeOrder(boolean pickUpOrder);

    boolean isMakeOrder();

    boolean isTakeOrder();
}
