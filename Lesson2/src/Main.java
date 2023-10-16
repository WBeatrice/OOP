package src;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        People people1 = new People("Kate");
        People people2 = new People("Vlad");
        People people3 = new People("Jake");
        market.acceptToMarket(people1);
        market.acceptToMarket(people2);
        market.acceptToMarket(people3);
        market.update();
    }
}
