public class Hand {
    int fingers;

    public Hand(int fingers) {
        this.fingers = fingers;
    }

    public int getFingers() {
        return fingers;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Hand{" +
                "fingers=" + fingers +
                '}';
    }
}
