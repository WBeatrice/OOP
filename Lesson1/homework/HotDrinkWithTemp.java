public class HotDrinkWithTemp {
    private int temperature;

    public HotDrinkWithTemp(String nemeDrink, int volume, int temperature) {
        super(nemeDrink, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
