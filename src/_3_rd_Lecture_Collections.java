import java.util.ArrayList;
import java.util.HashMap;

public class _3_rd_Lecture_Collections {
    public static void main(String[] args) {
        // Collections framework - tai yra konteineriai kurie turi daugiau
        // ... funkcionalumo nei stardartiniai masyvai.

        // // 0. ArrayList
        // ArrayList<String> strings = new ArrayList<>();
        // for (int i = 0; i < 100; i++) {
        //     strings.add("Jonas" + (int)(Math.random() * 1000 + 1));
        // }
        //
        // System.out.println(strings);
        // System.out.println(strings.size());
        // strings.add("Jonas100001");
        // System.out.println(strings.size());
        //
        // // Gauname indeksą kiekvieno nario
        // for (int i = 0; i < strings.size(); i++) {
        //     System.out.println(i + " : " + strings.get(i));
        // }

        // // Kai išgauti konkretaus ojekto indeksą
        // System.out.println("Jonas100001 pozicija: " + strings.indexOf("Jonas100001"));

        // Dedame custom objektus
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Lion"));
        Animal tiger = new Animal("Tiger");
        animals.add(tiger);

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).getKind());
        }

        // // remove and index of.
        // // ... jei norime rasti dublikatą / atsakyti į klausimą ar
        // // ... toks objektas jau egzistuoja tai dažniausiai paduodame
        // // ... naują objektą į indexOf() arba constains(). Kad šie
        // // ... metodai veiktų teisingai mums reikia apibrėžti dviejų
        // // ... objektų tapatybę su .equals() metodu toje klasėje, kurios
        // // ... objektus lyginame.
        // System.out.println(animals);
        // System.out.println(animals.indexOf(new Animal("Tiger")));
        // animals.remove(tiger);
        // System.out.println(animals);
        // System.out.println(animals.indexOf(tiger));


        // klausimas iš auditorijos - ar išrynus vieną narį, kitų
        // ... indeksas pasikeičia
        System.out.println(animals);
        System.out.println("Tiger possition before deleting Lion: "
                + animals.indexOf(new Animal("Tiger")));
        animals.remove(new Animal("Lion"));
        System.out.println("Tiger possition after deleting Lion: "
                + animals.indexOf(new Animal("Tiger")));


        // inserting into the middle
        System.out.println(animals);
        animals.add(0, new Animal("Bebras"));
        System.out.println(animals);

        // Hashmapai yra tas pats, kas kitose kalbose yra
        // ... asoc masyvas, dictionary
        HashMap<Long, Person> phoneBook = new HashMap<>();
        Person jonas = new Person();
        jonas.setName("Jonas");
        Person petras = new Person();
        petras.setName("Petras");

        phoneBook.put(89552515156L, jonas);
        phoneBook.put(89552515777L, petras);
        // dar milijonas tokių

        // dabar galime paieškoti petro pagal jo telefoną
        System.out.println(phoneBook.get(89552515156L));

    }
}

class Animal {
    private String kind;
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Animal(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "{" + kind + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return kind != null ? kind.equals(animal.kind) : animal.kind == null;
    }
}
