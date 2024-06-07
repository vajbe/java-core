class DesignSingletone {
    private static DesignSingletone single_instance = null;

    public String s;

    private DesignSingletone() {
        s = "I am part of singletone class";
    }

    public static synchronized DesignSingletone getInstance() {
        if (single_instance == null) {
            single_instance = new DesignSingletone();
        }
        return single_instance;
    }
}

public class Singletone {
    public static void main(String args[]) {
        DesignSingletone s1 = DesignSingletone.getInstance();
        DesignSingletone s2 = DesignSingletone.getInstance();

        System.out.println("Hashcode for s1" + s1.hashCode());
        System.out.println("Hashcode for s2" + s2.hashCode());

        if (s1 == s2) {
            System.out.println("This belongs to the same memory object");
        } else {
            System.out.println("They do not belong to same memory");
        }

    }
}