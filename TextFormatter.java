import java.util.*;

public class TextFormatter {
    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words;
    }

    public static List<String> justify(String text, int width) {
        List<String> words = splitWords(text);
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int len = words.get(i).length();
            int j = i + 1;
            while (j < words.size() && len + 1 + words.get(j).length() <= width) {
                len += 1 + words.get(j).length();
                j++;
            }
            StringBuilder line = new StringBuilder();
            int spaces = width - len;
            int gaps = j - i - 1;
            if (gaps <= 0 || j == words.size()) {
                for (int k = i; k < j; k++) {
                    line.append(words.get(k));
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < width) line.append(" ");
            } else {
                int extra = spaces / gaps;
                int rem = spaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words.get(k));
                    if (k < j - 1) {
                        for (int s = 0; s <= extra; s++) line.append(" ");
                        if (rem-- > 0) line.append(" ");
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }

    public static List<String> centerAlign(String text, int width) {
        List<String> words = splitWords(text);
        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            if (line.length() + word.length() + 1 > width) {
                int pad = (width - line.length()) / 2;
                StringBuilder newLine = new StringBuilder();
                for (int i = 0; i < pad; i++) newLine.append(" ");
                newLine.append(line);
                result.add(newLine.toString());
                line = new StringBuilder();
            }
            if (line.length() > 0) line.append(" ");
            line.append(word);
        }
        if (line.length() > 0) {
            int pad = (width - line.length()) / 2;
            StringBuilder newLine = new StringBuilder();
            for (int i = 0; i < pad; i++) newLine.append(" ");
            newLine.append(line);
            result.add(newLine.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.println("Enter width:");
        int width = sc.nextInt();

        System.out.println("\nJustified Text:");
        for (String line : justify(text, width)) System.out.println(line);

        System.out.println("\nCenter Aligned Text:");
        for (String line : centerAlign(text, width)) System.out.println(line);
    }
}
