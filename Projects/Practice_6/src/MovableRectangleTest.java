class MovableRectangleTest {
    public static void main(String[] args) {
        MovableRectangle movrect = new MovableRectangle(1,1,2,2,1,1);
        movrect.moveUp();
        movrect.moveDown();
        movrect.moveRight();
        System.out.println(movrect);
        movrect.bottomRight.xSpeed = 2;
        movrect.moveUp();
        System.out.println(movrect);
    }
}