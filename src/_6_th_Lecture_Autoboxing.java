import java.util.ArrayList;
import java.util.List;

public class _6_th_Lecture_Autoboxing {
    public static void main(String[] args) {
        // Autoboxing
        int i = 5;
        Integer j = Integer.valueOf("5");
        add(i, j); // unboxing
        add2(i, 9); // boxing

        List<Integer> l = new ArrayList<>();
        l.add(5);

        // kai iš primityvaus į wraperį --> boxing
        // kai iš wraperio į primityvų --> unboxing

        Integer[] integers = {5,9};
    }

    public static int add(int i, int j){
        return i + j;
    }

    public static int add2(Integer i, Integer j){
        return i + j;
    }
}
