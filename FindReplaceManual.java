package week2.lab;

import java.util.*;


public class FindReplaceManual {
    public static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - find.length() && text.substring(i, i + find.length()).equals(find)) {
                result.append(replace);
                i += find.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.println("Enter substring to find:");
        String find = sc.nextLine();
        System.out.println("Enter replacement:");
        String replace = sc.nextLine();

        String manual = manualReplace(text, find, replace);
        String builtin = text.replace(find, replace);

        System.out.println("Manual Replace Result: " + manual);
        System.out.println("Built-in Replace Result: " + builtin);
        System.out.println("Are both same? " + manual.equals(builtin));
    }
}

