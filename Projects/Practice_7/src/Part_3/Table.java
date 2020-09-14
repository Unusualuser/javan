package Part_3;

public class Table extends Furniture {
    int legs;

    public Table(int legs, int size, String material) {
        this.legs = legs;
        this.size = size;
        this.material = material;
    }

    public void howManyLegs() {
        System.out.println(this.legs);
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Table{" +
                "legs=" + legs +
                ", size=" + size +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public void whatIsMaterial() {
        System.out.println(this.material);
    }
}
