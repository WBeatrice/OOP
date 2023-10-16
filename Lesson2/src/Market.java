package src;

import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Buyer> queue;

    public Market() {
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Buyer buyer) {
        System.out.println(buyer.getName() + " пришел в магазин");
        takeInQueue(buyer);
    }

    @Override
    public void takeInQueue(Buyer buyer) {
        System.out.println(buyer.getName() + " встал в очередь");
        this.queue.add(buyer);
    }

    @Override
    public void takeOrders() {
        for (Buyer buyer : queue) {
            if (!buyer.isMakeOrder()) {
                buyer.setMakeOrder(true);
                System.out.println(buyer.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void giveOrders() {
        for (Buyer buyer : queue) {
            if (buyer.isMakeOrder()) {
                buyer.setTakeOrder(true);
                System.out.println(buyer.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Buyer> releasedActors = new ArrayList<>();
        for (Buyer buyer : queue) {
            if (buyer.isTakeOrder()) {
                releasedActors.add(buyer);
                System.out.println(buyer.getName() + " вышел из очереди и готов уходить");
            }
        }
        releaseFromMarket(releasedActors);
    }

    @Override
    public void releaseFromMarket(List<Buyer> actors) {
        for (Buyer actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}
