public class Leg extends Human {
    double length;

    public Leg(double weight, double length) {
        super(weight);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "length=" + length +
                ", weight=" + weight +
                '}';
    }
}
