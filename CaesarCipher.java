import java.util.*;

public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                sb.append((char)((c - 'A' + shift) % 26 + 'A'));
            else if (c >= 'a' && c <= 'z')
                sb.append((char)((c - 'a' + shift) % 26 + 'a'));
            else sb.append(c);
        }
        return sb.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift % 26);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        System.out.println("Enter shift value:");
        int shift = sc.nextInt();

        String enc = encrypt(text, shift);
        String dec = decrypt(enc, shift);

        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
        System.out.println("Decryption matches original? " + text.equals(dec));
    }
}
