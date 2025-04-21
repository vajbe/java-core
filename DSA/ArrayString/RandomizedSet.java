package DSA.ArrayString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RandomizedSet {

    HashSet<Integer> s;

    public RandomizedSet() {
        s = new HashSet<>();
    }

    public boolean insert(int val) {
        return s.add(val);
    }

    public boolean remove(int val) {
        return s.remove(val);
    }

    public int getRandom() {
        List<Integer> list = new ArrayList<>(s);
        int randomKey = (int) (s.size() * Math.random());
        return list.get(randomKey);
    }

    public static void main(String[] args) {

    }
}
