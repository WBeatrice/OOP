public class HotDrintMachine {
    @Override
    public void getProduct() {
    }

    public HotDrinkWithTemp getProduct(String nameDrink, int volume, int temperature) {
        return new HotDrinkWithTemp(nameDrink, volume, temperature);
    }
}
