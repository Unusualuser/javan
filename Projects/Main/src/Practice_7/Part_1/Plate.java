package Practice_7.Part_1;

public class Plate extends Dish {
    int height;

    public Plate(int height, String material, String type) {
        this.height = height;
        this.material = material;
        this.type = type;
    }

    public boolean eatSoup() {
        return this.height > 10;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean breakability() {
            return this.material.equals("steel");
    }

    @Override
    public String toString() {
        return "Plate{" +
                "height=" + height +
                ", material='" + material + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
