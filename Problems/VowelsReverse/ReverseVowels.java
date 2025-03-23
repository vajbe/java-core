package Problems.VowelsReverse;

import java.util.Arrays;
import java.util.List;

public class ReverseVowels {

    private final Character[] vowels = {
            'a', 'e', 'i', 'o', 'u'
    };

    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        char str[] = s.toCharArray();
        List<Character> list = Arrays.asList(this.vowels);
        while (i < j) {
            char leftChar = Character.toLowerCase(str[i]);
            char rightChar = Character.toLowerCase(str[j]);

            if (list.contains(leftChar) && list.contains(rightChar)) {
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
                i++;
                j--;
            }

            if (!list.contains(leftChar)) {
                i++;
            }

            if (!list.contains(rightChar)) {
                j--;
            }
        }
        /* System.out.println("String", str); */
        return new String(str);
    }

    public static void main(String[] args) {
        ReverseVowels s = new ReverseVowels();
        System.out.println(s.reverseVowels("IceCreAm"));
    }
}