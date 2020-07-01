import java.util.Arrays;

public class _2_nd_Lecture {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Jonas");
        employee1.setPhoneNumber("+3706299512");
        System.out.println(employee1.getAge());

        // creating the engine "named object"
        Engine engine = new Engine(150);
        // Car car = new Car(new Engine(150));
        Car car = new Car(engine);
        System.out.println(car.getHp());

        // Ar automatiškai pasikeičia arklio galios car objekte jei pakeičiu
        // ... jas main() metode
        engine.setHorsePower(200);
        System.out.println("New hp: " + car.getHp()); // turime naują HP!

        // toString();
        System.out.println(engine); // Engine@4554617c -->

        Engine engine2 = new Engine(200);
        System.out.println(engine.equals(engine2));

        // spausdiname automobilio vidurius
        System.out.println(car);
    }
}

class Person {
    private String name;
    private int age;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

class Student2 extends Person{ }

class Employee extends Person{
    private int badgeNumber;
}

// Example for composition (has-a relationship)
class Engine {
    private int horsePower;
    private String[] cilidrai = {"pirmas", "antras", "trečias", "ketvirtas"};

    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "{"
                + "'hp':" + horsePower
                + ",'cilidrai':" + Arrays.toString(cilidrai)
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        // Taip atrodys kvietimas: engine1.equals(engine2);

        // Žiūrime adresas sutampa, jei sutampa objektai tapatūs
        // engine1 == engine2
        if (this == o) return true;

        // Lginame kokiai klasei objektai priklauso
        if (o == null || getClass() != o.getClass()) return false;

        // lyginame laukus
        Engine engine = (Engine) o;
        if (horsePower != engine.horsePower) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(this.cilidrai, engine.cilidrai);
    }
}

class Car {
    private String color;
    private Engine engine;

    // constructor injection (dependency injection)
    public Car(Engine engine) {
        this.engine = engine;
    }

    // setter injection (dependency injection)
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getHp(){
        return engine.getHorsePower();
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
