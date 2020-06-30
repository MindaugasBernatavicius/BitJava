
// Intro:
// 1. Procedūrinis - funkcijos
// 2. OOP - objektai (savybiu ir susijusių metodų suma)
// 3. Functional - functions as first class citizens, immutable ds.

public class _1_st_Lecture {
    // metodo deklaracija
    public static void printHello(){
        System.out.println("\n");
        System.out.println("Labas");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        // DRY (don't repeat yourself)
        printHello(); // metodo kvietimas (kai norime pasinaudoti)
        // ...

        printHello();
        // ..

        printHello();

        // Let's create the first object
        Student student1 = new Student();
        // Student student2 = new Student("Jonas", 20);

        // dot operator
        System.out.println("student1 age: " + student1.getAge());
        student1.setAge(150);
        System.out.println("student1 age: " + student1.getAge());
    }
}

class Student {
    public String name;
    private int age;

    // default konstruktortius - suteikiamas automatiškai

    // getter ir setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    // defensive coding
    public void setAge(int age) {
        if(age < 120){
            this.age = age;
        } else {
            System.out.println("Invalid age provided, defaulting to 0!");
        }
    }
}
