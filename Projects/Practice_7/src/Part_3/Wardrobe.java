package Part_3;

public class Wardrobe extends Furniture{
    int height;
    int width;

    @Override
    public void whatIsMaterial() {
        System.out.println(this.material);
    }

    public void whatIsVolume() {
        System.out.println(this.height * this.width);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Wardrobe{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
