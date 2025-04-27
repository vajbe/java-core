package DSA.ArrayString;

public class IntToRoman {
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        IntToRoman i = new IntToRoman();
        System.out.println(i.intToRoman(1994));
        System.out.println(i.intToRoman(58));
        System.out.println(i.intToRoman(1994));
        System.out.println(i.intToRoman(37));
    }
}
