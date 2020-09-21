package Practice_5;

class MovableRectangleTest {
    public static void main(String[] args) {
        MovableRectangle movrect = new MovableRectangle(1,1,2,2,1,1);
        movrect.moveUp();
        movrect.moveDown();
        movrect.moveRight();
        System.out.println(movrect);
        movrect.moveUp();
        movrect.setWidth(3);
        movrect.setLength(2);
        System.out.println(movrect);
    }
}