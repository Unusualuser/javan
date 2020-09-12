public class Hand extends Human {
    int fingers;

    public Hand(double weight, int fingers) {
        super(weight);
        this.fingers = fingers;
    }

    public int getFingers() {
        return fingers;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "fingers=" + fingers +
                ", weight=" + weight +
                '}';
    }
}
