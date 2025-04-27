package DSA.ArrayString;

//https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char d = i + 1 >= s.length() ? s.charAt(i) : s.charAt(i + 1);
            int curr = map.get(c);
            int next = map.get(d);

            if (curr < next) {
                result += next - curr;
                i++;
            } else {
                result += curr;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt i = new RomanToInt();
        System.out.println(i.romanToInt("III"));
        System.out.println(i.romanToInt("MCMXCIV"));        
        System.out.println(i.romanToInt("LVIII"));        
    }

}
