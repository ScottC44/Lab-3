import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonInfo {

    private static String firstName;
    private static String lastName;
    private static String gender;
    private static int age;
    private static String phoneNo;
    private static String email;

    public PersonInfo(String firstName, String lastName, String gender, int age, String phoneNo, String email) {

        PersonInfo.firstName = firstName;
        PersonInfo.lastName = lastName;
        PersonInfo.gender = gender;
        PersonInfo.age = age;
        PersonInfo.phoneNo = phoneNo;
        PersonInfo.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        PersonInfo.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        PersonInfo.lastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        PersonInfo.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        PersonInfo.age = age;
    }
    public void setPhoneNo(String phoneNo){
        PersonInfo.phoneNo = phoneNo;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setEmail(String email){
        PersonInfo.email = email;
    }
    public String getEmail(){
        return email;
    }

    public static void main(String[] args) {
        ArrayList<PersonInfo> list = new ArrayList<>();
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
                list.add(new PersonInfo(firstName, lastName, gender, age, phoneNo, email));
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: ");
        }
        System.out.format("%2s%20s%20s%20s%20s%20s ", "First Name", "Last Name", "Gender", "Age", "Phone no", "Email");
        for (int i = 0; i < list.size(); i++) {
            System.out.format("%2s%21s%22s%22s%22s%30s ", list.get(i).getFirstName(), list.get(i).getLastName(),
                    list.get(i).getGender(), list.get(i).getAge(), list.get(i).getPhoneNo(), list.get(i).getEmail());
        }
    }
}



