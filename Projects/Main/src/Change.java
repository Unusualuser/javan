public class Change {
    public int search(int x) {
        if (x == 0) {
            return 1;
        }
        if (x < 0) {
            return 0;
        }
        return search(x - 3) + search(x - 1) + search(x - 5);
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.search(3));
    }
}
