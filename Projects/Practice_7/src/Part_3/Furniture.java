package Part_3;

public abstract class Furniture {
    protected int size;
    protected String material;

    public abstract void whatIsMaterial();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "size=" + size +
                ", type='" + material + '\'' +
                '}';
    }
}
