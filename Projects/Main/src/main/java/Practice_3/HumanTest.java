package Practice_3;

class HumanTest {
    public static void main(String[] args) {
        Hand leftH = new Hand(5);
        Hand rightH = new Hand(4);
        Head head = new Head(true);
        Leg leftL = new Leg(100);
        Leg rightL = new Leg(101);
        Human andrew = new Human("Andrew", 195, leftH, rightH, head, leftL, rightL, 75);
        System.out.println(andrew.toString());
    }
}