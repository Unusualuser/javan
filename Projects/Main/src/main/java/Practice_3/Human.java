package Practice_3;

public class Human {
    String name;
    int height;
    Hand leftH;
    Hand rightH;
    Head head;
    Leg leftL;
    Leg rightL;
    protected double weight;

    public Human(String name, int height, Hand leftH, Hand rightH, Head head, Leg leftL, Leg rightL, double weight) {
        this.name = name;
        this.height = height;
        this.leftH = leftH;
        this.rightH = rightH;
        this.head = head;
        this.leftL = leftL;
        this.rightL = rightL;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Hand getLeftH() {
        return leftH;
    }

    public void setLeftH(Hand leftH) {
        this.leftH = leftH;
    }

    public Hand getRightH() {
        return rightH;
    }

    public void setRightH(Hand rightH) {
        this.rightH = rightH;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeftL() {
        return leftL;
    }

    public void setLeftL(Leg leftL) {
        this.leftL = leftL;
    }

    public Leg getRightL() {
        return rightL;
    }

    public void setRightL(Leg rightL) {
        this.rightL = rightL;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", left_h=" + leftH +
                ", right_h=" + rightH +
                ", head=" + head +
                ", left_l=" + leftL +
                ", right_l=" + rightL +
                ", weight=" + weight +
                '}';
    }
}
