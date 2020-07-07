import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
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
            String fileLine = bufferedReader.readLine(); // "\n", "\r\n" - ieško newline
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
        File relativeFile2 = new File("b.csv");
        FileWriter fw = null;
        try {
            fw = new FileWriter(relativeFile2);
            BufferedWriter bw = new BufferedWriter(fw);
            String fileLine = "Mindaugas";
            bw.write(fileLine);

            // writting file with newline
            String fileLine2 = "Mindaugas\n";
            bw.write(fileLine2);
            bw.write("Jonas");
            bw.newLine();
            bw.write("Antanas");

            // bw.flush();
            bw.close(); // close automatically flushes the buffer
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3. Appending to files
        try {
            BufferedWriter bufferedWriter
                    = new BufferedWriter(new FileWriter(new File("b.csv"), true));
            String fileLine = "\nappended file line";
            bufferedWriter.write(fileLine);
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        //4. Reading from network (web)
        try {
            URL url = new URL("https", "www.delfi.lt", "/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = in.readLine();

            while (inputLine != null) {
                System.out.println(inputLine);
                inputLine = in.readLine();
            }
        } catch(MalformedURLException e){
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
