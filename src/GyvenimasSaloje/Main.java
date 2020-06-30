package GyvenimasSaloje;

public class Main {
    public boolean arMirsta(Person p) {
        // Jei žmogeliukas papuola į tam tikras amžiaus grupes tai jis miršta pagal tam tikrą tikimybę.
        // jei žmogeliuko amžius nuo 0 iki 10 tai tikimybė jam numirti 5%;
        if (p.getAge() > 0 && p.getAge() <= 10 && p.getMires() == false){
            // (int)(Math.random() * 100) --> nuo nulio iki simto ir jei daugiau ar lygu 5 tai nemirsta
        }

        // jei žmogeliuko amžius nuo 11 iki 20 tai tikimybė jam numirti 2%;
        // jei žmogeliuko amžius nuo 21 iki 50 tai tikimybė jam numirti 5%;
        // jei žmogeliuko amžius virš 50 tai tikimybė jam numirti 10% ir kiekvienais metais didėja 2%;



        return false;
    }

    public boolean arSusilaukiaPalikuonio(Person p){
        // Jei žmogeliukas yra tam tikro amžiaus tai jis su tam tikra tikimybe susilaukia palikuonio.
        // jei žmogeliuko amžius nuo 15 iki 30 tai tikimybė jam susilaukti palikuonio yra 10% ir po to jis 2 metus negali dalyvauti gyvybės loterijoje;
        // jei žmogeliuko amžius nuo 31 iki 50 tai tikimybė jam susilaukti palikuonio yra 5% ir po to jis 3 metus negali dalyvauti gyvybės loterijoje;
        // kito amžiaus žmogeliukai gyvybės loterijoje nedalyvauja;

        return false;
    }

    public static void main(String[] args) {
        // Zmogeliuku masyvas
        int zmogeliukuKiekis = (int)(Math.random() * 500 + 1);
        // iniciliazuojame masyva į random dydį
        Person[] salosGyventojai = new Person[zmogeliukuKiekis];

        // sukame ciklą ir sukuriame jame zmogeliukus
        final int MAX_HUMAN_AGE = 120;
        for (int i = 0; i < zmogeliukuKiekis; i++) {
            salosGyventojai[i] = new Person((int)(Math.random() * MAX_HUMAN_AGE + 1));
        }

        // Gyvenimo ir mirties ciklas - p.s. tas pats žmogeliukas dalyvauja ir gyvybės ir mirties loterijoje.
        // ... for ciklas bus
        // ... kiekvienam zmogeliukui kviesite arMirsta() bei arSusilaukiaPalikuonio() metodus.
        // ... Spausdinkite metus (1, 2, 3 ...)
        // ... ir kiek tais metai gimė žmogeliukų,
        // ... kiek mirė
        // ... ir kiek jų viso yra saloje.
    }
}

class Person {
    private boolean mires;
    private int palikuoniuKiekis;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public boolean getMires() {
        return mires;
    }

    public void setMires(boolean mires) {
        this.mires = mires;
    }

    public int getPalikuoniuKiekis() {
        return palikuoniuKiekis;
    }

    public void setPalikuoniuKiekis(int palikuoniuKiekis) {
        this.palikuoniuKiekis = palikuoniuKiekis;
    }
}
