public class MovableRectangle extends Rectangle implements Movable  {
    MovablePoint topLeft;
    MovablePoint bottomRight;
    Rectangle rectangle;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1, y1, xSpeed,ySpeed);
        this.bottomRight = new MovablePoint(x2, y2,xSpeed, ySpeed);
        this.rectangle = new Rectangle(Math.abs(x1-x2), Math.abs(y1-y2));
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    private boolean speedTest() {
        return ((topLeft.xSpeed == bottomRight.xSpeed) && (topLeft.ySpeed == bottomRight.ySpeed));
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
