package Practice_7.Part_1;

public abstract class Dish {
    protected String material;
    protected String type;

    public abstract boolean breakability();

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "material='" + material + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
