public class hot_drink {
    private String nameDrink;
    private int volume;

    public hot_drink(String nameDrink, int volume) {
        this.nameDrink = nameDrink;
        this.volume = volume;
    }

    public String getNameDrink() {
        return nameDrink;
    }

    public void setNameDrink(String nameDrink) {
        this.nameDrink = nameDrink;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}