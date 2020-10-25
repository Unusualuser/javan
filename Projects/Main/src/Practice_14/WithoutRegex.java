package Practice_14;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

public class WithoutRegex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] keys = new String[count];
        String[] values = new String[count];
        for (int i = 0; i < count; i++) {
            keys[i] = scanner.next();
            values[i] = scanner.next();
        }
        String line = scanner.next();
        System.out.println(StringUtils.replaceEach(line, keys, values));
    }
}