package src;

import java.util.List;

public interface MarketBehaviour {
    void acceptToMarket(Buyer buyer);

    void releaseFromMarket(List<Buyer> buyers);

    void update();
}
