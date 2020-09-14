package Practice_5;

class MovableCircleTest {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        MovableCircle circle = new MovableCircle(10, point);
        System.out.println(circle.toString());
        circle.moveUp();
        circle.moveLeft();
        System.out.println(circle.toString());
    }
}