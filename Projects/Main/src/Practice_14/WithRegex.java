package Practice_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Pattern pat = Pattern.compile("(?<rule>\\w+) (?<on>\\w+)");
        ArrayList <Matcher> matchers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            matchers.add(pat.matcher(scanner.nextLine()));
        }
        String line = scanner.next();
        StringBuffer buffer = new StringBuffer();
        HashMap<String, String> dict = new HashMap<String, String>();
        for (Matcher matcher:matchers) {
            if(matcher.find()) {
                buffer.append(matcher.group("rule"));
                if (matcher != matchers.get(count - 1)) {
                    buffer.append("|");
                }
                dict.put(matcher.group("rule"), matcher.group("on"));
            }
        }
        Pattern pattern = Pattern.compile(buffer.toString());
        Matcher matcher = pattern.matcher(line);
        line =  matcher.replaceAll(var -> dict.get(var.group()));
        System.out.println(line);
    }
}
