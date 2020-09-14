package Practice_7.Part_2;

public class Corgi extends Dog{
    int lengthOfTheHair;

    public Corgi(int lengthOfTheHair, int age, String name) {
        this.lengthOfTheHair = lengthOfTheHair;
        this.age = age;
        this.name = name;
    }

    public boolean isTrained() {
        return age < 1;
    }

    public int getLengthOfTheHair() {
        return lengthOfTheHair;
    }

    public void setLengthOfTheHair(int lengthOfTheHair) {
        this.lengthOfTheHair = lengthOfTheHair;
    }

    @Override
    public void lifeExpectancy() {
        System.out.println("Средняя продолжительность жизни корги 10-12 лет.");
    }

    @Override
    public String toString() {
        return "Corgi{" +
                "lengthOfTheHair=" + lengthOfTheHair +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
