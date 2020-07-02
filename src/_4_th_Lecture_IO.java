import java.io.*;
import java.util.ArrayList;

public class _4_th_Lecture_IO {
    public static void main(String[] args) {
        //1. Reading files
        // Absolute path C:\Users\Mindaugas\Downloads\a.txt

        // 0. Where should we create / store that file?
        // ... two ways to find out:
        // ... - take an educated guess
        // ... - get current directory with Java
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // ... sukuriu failo objektą, kuris laiko info kur failas randasi
        File relativeFile = new File("a.csv");

        // ... sukuriame kolekciją, kurioje laikysime personos objektus
        ArrayList<Persona> people = new ArrayList<>();
        try {
            // standartinis būdas gauti duomenis iš teksitinio failo javoje
            FileReader fileReader = new FileReader(relativeFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // skaitome eilutė po eilutės su .readLine() metodu
            String fileLine = bufferedReader.readLine();
            while (fileLine != null) { // žiūrome ar perskaityta eilutė nėra tuščia
                // System.out.println(fileLine); // spausdiname visą eilutę

                // inicializuojame savo personų arraylistą su iš failo gautais duomenimis
                String[] splitString = fileLine.split(",");
                people.add(new Persona(
                        splitString[0],
                        Integer.parseInt(splitString[1]),
                        splitString[2]));

                // skaitome sekančią eilutę
                fileLine = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("File was not found, check if it's there!");
        } catch (IOException e){
            System.out.println("Some general IO error!");
        }

        System.out.println(people);


        //2. Writing to files

        //3. Reading from network
    }
}

class Persona {
    private String name;
    private int age;
    private String phoneNumber;

    public Persona(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
