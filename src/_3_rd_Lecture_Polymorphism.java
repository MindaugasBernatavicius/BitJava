public class _3_rd_Lecture_Polymorphism {
    public static void main(String[] args) {

        // Polimorfizmas tai OOP kalbų savybė
        // leidžainti vaikininių klasių objektams apsimesti,
        // tarsi jie būtų tėvinių klasių objektai.

        // 0. Polimorfizmo atvejis - polimorfinis masyvas
        // ... tai į tėvinės klasės masyvą, galime paduoti
        // ... vaikinės klasės objektus
        Human[] humans = {
                new Human(), // 0
                new Human(), // 1
                new CompanyEmployee(),
                new Artist()
        };

        // String[] strings = { "s1", 1 };

        CompanyEmployee[] companyEmployees = {
                new CompanyEmployee(),
                // new Human() // incompatible types
        };

        // 1. Polimorfizmo atvejis - polimorfizmas funkcijų parametruose
        // ... tai į tėvinės klasės objektą priimantį metodą, galime paduoti
        // ... vaikinės klasės objektus
        Human jonas = new Human();
        CompanyEmployee petras = new CompanyEmployee();

        // ... jei metodas isBonusDue yra deklaruotas, jog priima Human
        // ... tai galiu paduoti ir Human klasės objektus ir visų vaikinių
        // ... klasių, pvz: CompanyEmployee
        isBonusDue(jonas);
        isBonusDue(petras);

        isFirringDue(petras);
        // isFirringDue(jonas); // can not be applied to class Human
    }

    public static boolean isBonusDue(Human human){
        return human.name.equals("Jonas") ? true : false;
    }

    public static boolean isFirringDue(CompanyEmployee employee){
        return employee.name.equals("Petras") ? true : false;
    }
}

class Human {
    String name;
    String surname;
}

class CompanyEmployee extends Human {
}

class Artist extends Human {}
