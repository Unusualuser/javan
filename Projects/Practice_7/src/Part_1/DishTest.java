package Part_1;

class DishTest {
    public static void main(String[] args) {
        Plate plate = new Plate(8, "steel","plate");
        System.out.println(plate.toString());
        System.out.println(plate.eatSoup());
        Pan pan = new Pan(32, "steel", "pan");
        System.out.println(pan.toString());
        System.out.println(pan.cookSoup());
    }
}