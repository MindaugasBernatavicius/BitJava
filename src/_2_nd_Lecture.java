public class _2_nd_Lecture {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setName("Jonas");
        employee1.setPhoneNumber("+3706299512");
        System.out.println(employee1.getAge() + 1);

        // creating the engine "named object"
        Engine engine = new Engine(150);
        // Car car = new Car(new Engine(150));
        Car car = new Car(engine);
        System.out.println(engine.getHorsePower());
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
}

class Student2 extends Person{ }

class Employee extends Person{
    private int badgeNumber;
}

// Example for composition (has-a relationship)
class Engine {
    private int horsePower;

    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}

class Car {
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
}
