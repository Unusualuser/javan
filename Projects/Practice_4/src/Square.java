class Square extends Rectangle {
    double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        this.filled = filled;
        this.color = color;
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setWidth(double side) {
        this.width = side;
    }

    public void setLength(double side) {
        this.length = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + getSide() +
                ", width=" + getWidth()+
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }
}