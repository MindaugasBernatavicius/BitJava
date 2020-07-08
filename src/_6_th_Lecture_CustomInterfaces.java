public class _6_th_Lecture_CustomInterfaces {
    public static void main(String[] args) {
        Apskirtimas apskirtimas1 = new Apskirtimas();
        apskirtimas1.spindulys = 5;
        System.out.println("Apskritimo plotas: " + apskirtimas1.getArea());
        doSomethingWithShape(apskirtimas1);
    }

    public static void doSomethingWithShape(Figūra figūra){
        System.out.println(figūra.getArea());
    }
}

abstract class Figūra2 {
    double area;
    double perimeter;

    abstract double getArea();
    abstract double getPerimeter();
}

interface Figūra {
    // public and abstract by default
    double getArea();
    double getPerimeter();
}


class Apskirtimas implements Figūra {
    int spindulys;
    final double pi = 3.1459;

    @Override
    public double getArea() {
        return pi * (spindulys * spindulys);
    }

    @Override
    public double getPerimeter() {
        return 2 * spindulys * pi;
    }
}

class Kvadratas implements Figūra {
    int ilgis;
    int plotis = ilgis;


    @Override
    public double getArea() {
        return ilgis * ilgis;
    }

    @Override
    public double getPerimeter() {
        return ilgis * 4;
    }
}
