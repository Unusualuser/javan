package Practice_13;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        try {
            human.setHeight(195);
            human.setWeight(75);
        }

        catch (HumanStatsException hse) {
            System.out.println("Weight is incorrect");
        }

        catch (Exception ex) {
            System.out.println("Height is incorrect");
        }

        finally {
            System.out.println(human);
        }
        human.setName("Andrewnewnew");
    }
}
