import java.util.*;

public class EmailAnalyzer {
    public static boolean isValid(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.lastIndexOf('.');
        return (at > 0 && at == lastAt && dot > at + 1 && dot < email.length() - 1);
    }

    public static void analyze(String email) {
        if (!isValid(email)) {
            System.out.println(email + "\tInvalid");
            return;
        }
        int at = email.indexOf('@');
        int dot = email.lastIndexOf('.');
        String user = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = domain.substring(0, dot - at - 1);
        String ext = email.substring(dot + 1);
        System.out.println(email + "\t" + user + "\t" + domain + "\t" + domainName + "\t" + ext + "\tValid");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of emails:");
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            String email = sc.nextLine();
            analyze(email);
        }
    }
}
