import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _5_th_Lecture_Interfaces {
    public static void main(String[] args) {
        List<ShippingItem> shippingItems = new ArrayList<>();
        shippingItems.add(new ShippingItem("Batai", 1500));
        shippingItems.add(new ShippingItem("Ąžuolas", 200));
        shippingItems.add(new ShippingItem("Kedai", 1200));

        System.out.println("Before sorting: " + shippingItems);
        // shippingItem1.compareTo(shippingItem2);
        Collections.sort(shippingItems);
        System.out.println("After sorting: " + shippingItems);
    }
}

class ShippingItem implements Comparable<ShippingItem> {
    String itemName;
    int weightInGramms;

    public ShippingItem(String itemName, int weightInGramms) {
        this.itemName = itemName;
        this.weightInGramms = weightInGramms;
    }

    @Override
    public int compareTo(ShippingItem o) {
        if(this.weightInGramms > o.weightInGramms){
            return 1; // reikia apkeisti vietomis
        } else if (this.weightInGramms < o.weightInGramms){
            return -1; // nereikia apkeisti vietomis
        } else {
            return 0; // nereikia apkeisti vietomis, jie lygūs palyginamos savybės atžvilgiu
        }
    }

    @Override
    public String toString() {
        return "{ 'name': " + itemName + ", weight: " + weightInGramms + " }";
    }
}
