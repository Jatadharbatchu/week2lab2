import java.util.*;

public class StringPerformance {
    public static long testString(int n) {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) s += "x";
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long testStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) sb.append("x");
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long testStringBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) sb.append("x");
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of iterations:");
        int n = sc.nextInt();

        long t1 = testString(n);
        long t2 = testStringBuilder(n);
        long t3 = testStringBuffer(n);

        System.out.println("Method\t\tTime(ms)");
        System.out.println("String\t\t" + t1);
        System.out.println("StringBuilder\t" + t2);
        System.out.println("StringBuffer\t" + t3);
    }
}
