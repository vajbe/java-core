package DSA.ArrayString;

public class LengthLast {
    public int lengthOfLastWord(String s) {
        String str[] = s.split(" ");
        String last = str[str.length - 1];

        return last.length();
    }

    public static void main(String[] args) {
        LengthLast l = new LengthLast();
        System.out.println(l.lengthOfLastWord("   fly me   to   the moon"));
    }
}
