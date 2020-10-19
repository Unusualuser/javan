package Practice_13;

public class Human {
    private int height;
    private int weight;
    private String name;

    public void setHeight(int height) throws Exception {
        if (height < 30 || height > 300) {
            throw new Exception();
        }
        this.height = height;
    }

    public void setWeight(int weight) throws HumanStatsException {
        if (weight < 2 || weight > 300) {
            throw new HumanStatsException();
        }
        this.weight = weight;
    }

    public void setName(String name) throws  MyNewException{
        if (name.length() > 10)  {
            throw new MyNewException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
