package src;

public interface QueueBehaviour {
    void takeInQueue(Buyer buyer);

    void takeOrders();

    void giveOrders();

    void releaseFromQueue();
}
