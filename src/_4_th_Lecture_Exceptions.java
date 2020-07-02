public class _4_th_Lecture_Exceptions {
    public static void main(String[] args) {
        // 1. Kaip iššaukti exception'ą
        // int res = 5 / 0;
        // System.out.println(res);

        // 2. Kaip suhandlinti ir kaip pasinaudoti exception objektais
        // try {
        //     int res = 5 / 0;
        //     System.out.println(res);
        // } catch(Exception e){
        //     System.out.println(e.getMessage());
        // }
        //
        // System.out.println("Programa baigė darbą");

        // 3. Exception klasių hierarchija + multicatch
        try {
            String s = null;
            System.out.println(s.equals(null));

            int res = 5 / 0;
            System.out.println(res);
        } catch (ArithmeticException e){
            System.out.println("Arithmetic problem -> " + e.getMessage());
        } catch (NullPointerException e){
            System.out.println("Nullpointer -> " + e.getMessage());
        } catch (Exception e){
            System.out.println("Task failed succesfully");
        }

        System.out.println("Programa baigė darbą");


        // 4. Kaip mesti exceptionus iš savo metodų
        ProductItem productItem = new ProductItem();
        try {
            productItem.setWeightInGrams(-5);
        } catch (Exception e) {
            // - pataisyti duomenu faila
            // - siusti pranešimą admintratoriui
            System.out.println(e.getMessage());
        }
    }
}

class ProductItem {
    int weightInGrams;

    public void setWeightInGrams(int weightInGrams) throws Exception {
        if(weightInGrams < 0){
            throw new Exception("Neteisingas svoris");
        }
        this.weightInGrams = weightInGrams;
    }
}
