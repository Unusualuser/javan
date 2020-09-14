package Part_2;

class DogTest {
    public static void main(String[] args) {
        Dachshund dachshund = new Dachshund(9,3, "sausage");
        System.out.println(dachshund.toString());
        System.out.println(dachshund.isHunt());
        dachshund.lifeExpectancy();
        Corgi corgi = new Corgi(1,2,"smile");
        System.out.println(corgi.toString());
        System.out.println(corgi.isTrained());
        corgi.lifeExpectancy();
    }
}