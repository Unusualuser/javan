package Practice_27_28;

public class DoAction {
    @DoActionAnnotation(purpose = "sum")
    public static void doSum(Data data) {
        int result = data.getNumbers().stream()
                .mapToInt(a -> a)
                .sum();
        System.out.println(result);
    }

    @DoActionAnnotation(purpose = "print")
    public static void doPrint(Data data) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < data.getWords().size(); i++) {
            stringBuilder.append(data.getWords().get(i));
            if(i != (data.getWords().size() - 1)) {
                stringBuilder.append(data.getDelimeter());
            }
        }
        System.out.println(stringBuilder);
    }
}
