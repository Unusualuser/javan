public class Head extends Human {
    boolean haired;

    public Head(double weight, boolean haired) {
        super(weight);
        this.haired = haired;
    }

    public boolean getHaired() {
        return haired;
    }

    public void setHaired(boolean haired) {
        this.haired = haired;
    }

    @Override
    public String toString() {
        return "Head{" +
                "haired=" + getHaired() +
                ", weight=" + getWeight() +
                '}';
    }
}
