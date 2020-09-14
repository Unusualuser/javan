package Practice_7.Part_2;

public class Dachshund extends Dog {
    int lengthOfTheEars;

    public Dachshund(int lengthOfTheEars, int age, String name) {
        this.lengthOfTheEars = lengthOfTheEars;
        this.age = age;
        this.name = name;
    }

    public boolean isHunt() {
        return lengthOfTheEars > 8 && age < 10;
    }

    public int getLengthOfTheEars() {
        return lengthOfTheEars;
    }

    public void setLengthOfTheEars(int lengthOfTheEars) {
        this.lengthOfTheEars = lengthOfTheEars;
    }

    @Override
    public void lifeExpectancy() {
        System.out.println("Средняя продолжительность жизни таксы 12-15 лет.");
    }

    @Override
    public String toString() {
        return "Dachshund{" +
                "lengthOfTheEars=" + lengthOfTheEars +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
