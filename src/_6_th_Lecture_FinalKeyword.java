public class _6_th_Lecture_FinalKeyword {
    public static void main(String[] args) {
        Z z = new Z();
        z.doSomething();
    }
}

// final class can not be extended (used with inner classes)
final class X {
    final int i = 5;

    public X() {
        // this.i = 9; can't assign
    }
}

// class Y extends X { // can not inherit from final class
//
// }

class Z {
    final void doSomething(){
        System.out.println("Final method!");
    }
}

class ZChild extends Z{
    // final method - can not be overridden
    // void doSomething(){
    //
    // }
}

