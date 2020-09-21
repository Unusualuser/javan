package Practice_5;

public class MovableRectangle extends Rectangle implements Movable  {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;
    private Rectangle rectangle;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed,ySpeed);
        this.bottomRight = new MovablePoint(x2, y2,xSpeed, ySpeed);
        this.rectangle = new Rectangle(Math.abs(x1-x2), Math.abs(y1-y2));
        super.setWidth(Math.abs(y2 -y1));
        super.setLength(Math.abs(x2 - x1));
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", width=" + getWidth() +
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }

    private boolean speedTest() {
        return ((topLeft.getxSpeed() == bottomRight.getxSpeed()) && (topLeft.getySpeed() == bottomRight.getySpeed()));
    }

    @Override
    public void setWidth(double width) {
        this.topLeft.setX((int) (this.topLeft.getX() - (width - this.getWidth())/2));
        this.bottomRight.setX((int) (this.bottomRight.getX() + (width - this.getWidth())/2));
        super.setWidth(width);
    }

    @Override
    public void setLength(double length) {
        this.topLeft.setY((int) (this.topLeft.getY() + (length - this.getLength())/2));
        this.bottomRight.setY((int) (this.bottomRight.getY() - (length - this.getLength())/2));
        super.setLength(length);
    }

    @Override
    public void moveUp() {
        if (speedTest()) {
            topLeft.moveUp();
            bottomRight.moveUp();
        }
        else System.out.println("Скорости не равны");
    }

    @Override
    public void moveDown() {
        if (speedTest()) {
            topLeft.moveDown();
            bottomRight.moveDown();
        }
        else System.out.println("Скорости не равны");
    }

    @Override
    public void moveLeft() {
        if (speedTest()) {
            topLeft.moveLeft();
            bottomRight.moveLeft();
        }
        else System.out.println("Скорости не равны");
    }

    @Override
    public void moveRight() {
        if (speedTest()) {
            topLeft.moveRight();
            bottomRight.moveRight();
        }
        else System.out.println("Скорости не равны");
    }
}
