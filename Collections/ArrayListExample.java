package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Data {
    int data;

    Data(int data) {
        this.data = data;
    }
}

class SortByData implements Comparator<Data> {

    @Override
    public int compare(Data o1, Data o2) {
        return o1.data - o2.data;
    }

}

public class ArrayListExample {

    public static void main(String[] args) {
        List<Data> list = new ArrayList<Data>();
        list.add(new Data(87));
        list.add(new Data(15));
        list.add(new Data(32));
        list.add(new Data(11));
        list.add(new Data(76));
        System.out.println("Before sort");
        for (Data data : list) {
            System.out.print(data.data + ", ");
        }
        System.out.println("");
        Collections.sort(list, new SortByData());
        System.out.println("After sort");
        for (Data data : list) {
            System.out.print(data.data + ", ");
        }
    }
}
