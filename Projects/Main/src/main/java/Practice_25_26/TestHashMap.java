package Practice_25_26;

public class TestHashMap {
    public static void main(String[] args) {
        HashMapInterfaceImpl<Object, String> myHashMap = new HashMapInterfaceImpl<>();

        myHashMap.add(1, "Привет");
        myHashMap.add(2, "Hello");
        myHashMap.add(3, "Bonjour");
        myHashMap.add(4, "Ciao");
        myHashMap.add(5, "папавпвы");
        myHashMap.add(5, "Xin chào");
        myHashMap.add(6, "Здоров");

        myHashMap.remove(6);

        for(int i = 1; i < 7; i++) {
            System.out.println(myHashMap.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------");
        for(String val : myHashMap) {
            System.out.println(val);
        }
    }
}
