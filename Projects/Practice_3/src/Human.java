public class Human {
    double weight;

    public Human(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "weight=" + getWeight() +
                '}';
    }
}
