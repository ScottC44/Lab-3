import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonInfo {

    public static void main(String[] args) {
         String firstName;
         String lastName;
         String gender;
         int age;
         String phoneNo;
         String email;
         String total;
        ArrayList<String> list = new ArrayList<>();
        File file = new File("records.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                firstName = line.split(",")[0];
                lastName = line.split(",")[1];
                gender = line.split(",")[2];
                age = Integer.parseInt(line.split(",")[3]);
                phoneNo = line.split(",")[4];
                email = line.split(",")[5];
                firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1, firstName.length());
                lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1, lastName.length());
                if (gender.toLowerCase() == "male" || gender.toLowerCase() == "female") {
                    gender = gender.toLowerCase();
                }
                if (age > 1 || age < 130) {
                    age = age;
                }
                if (phoneNo.length() == 13) {
                    phoneNo = phoneNo;
                }
                if (email.matches("[A-Z][0-9].@")) {
                    email = email;
                }
                total = firstName +lastName + age +phoneNo +email;
                list.add(total);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
        }
        System.out.format("%2s%20s%20s%20s%20s%20s ", "First Name", "Last Name", "Gender", "Age", "Phone no", "Email");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); 		        }
    }
}



