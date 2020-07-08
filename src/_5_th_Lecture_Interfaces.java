import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class _5_th_Lecture_Interfaces {
    public static void main(String[] args) {
        List<ShippingItem> shippingItems = new ArrayList<>();
        shippingItems.add(new ShippingItem("Kedai", 1500));
        shippingItems.add(new ShippingItem("Ąsla", 1500));
        shippingItems.add(new ShippingItem("Batai", 1500));
        shippingItems.add(new ShippingItem("Ąžuolas", 200));

        System.out.println("Before sorting: " + shippingItems);
        // shippingItem1.compareTo(shippingItem2);
        Collections.sort(shippingItems);
        System.out.println("After sorting: " + shippingItems);


        System.out.println();
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Beržas");
        listOfStrings.add("Ąžuolas");
        listOfStrings.add("Citrina");
        listOfStrings.add("Ąsotis");
        System.out.println("Before sorting: " + listOfStrings);
        Locale lithuanian = new Locale("lt_LT");
        Collator lithuanianCollator = Collator.getInstance(lithuanian);
        Collections.sort(listOfStrings, lithuanianCollator);
        System.out.println("After sorting: " + listOfStrings);
    }
}

class ShippingItem implements Comparable<ShippingItem> {
    String itemName;
    int weightInGramms;

    public ShippingItem(String itemName, int weightInGramms) {
        this.itemName = itemName;
        this.weightInGramms = weightInGramms;
    }

    // // 1. Pilna versija su visais ypatumais
    // @Override
    // public int compareTo(ShippingItem o) {
    //     if(this.weightInGramms > o.weightInGramms){
    //         return 1; // reikia apkeisti vietomis
    //     } else if (this.weightInGramms < o.weightInGramms){
    //         return -1; // nereikia apkeisti vietomis
    //     } else {
    //         return 0; // nereikia apkeisti vietomis, jie lygūs palyginamos savybės atžvilgiu
    //     }
    // }

    // // 2. Deleguojame palyginimą Integer klasės statiniam metodui compare()
    // @Override
    // public int compareTo(ShippingItem o) {
    //     // -1, 0, 1
    //     return Integer.compare(this.weightInGramms, o.weightInGramms);
    // }

    // 3. Rikiuojame pagal dvi savybes
    @Override
    public int compareTo(ShippingItem o) {
        if (this.weightInGramms > o.weightInGramms) {
            return 1; // reikia apkeisti vietomis
        } else if (this.weightInGramms < o.weightInGramms) {
            return -1; // nereikia apkeisti vietomis
        } else { // kai sutampa
            // kai weightInGramms sutampa, tada lyginame itemName
            return this.itemName.compareTo(o.itemName);
        }
    }

    @Override
    public String toString() {
        return "{ 'name': " + itemName + ", weight: " + weightInGramms + " }";
    }
}
