import java.util.Scanner;

public class RegisterStudentUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the student registration form!");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // consume newline left-over

        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();

        System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
        String genderStr = scanner.nextLine().toUpperCase();
        Gender gender = Gender.valueOf(genderStr);

        System.out.println("Enter Parent 1 Information");
        Guardian parent1 = readGuardian(scanner);

        System.out.println("Enter Parent 2 Information (Enter 'skip' to skip)");
        Guardian parent2 = null;
        String skip = scanner.nextLine();
        if (!skip.equalsIgnoreCase("skip")) {
            parent2 = readGuardian(scanner);
        }

        System.out.println("Enter Emergency Contact Information");
        Guardian emerContact = readGuardian(scanner);

        int id = 0; // default value
        System.out.print("Enter ID (optional): ");
        String idStr = scanner.nextLine();
        if (!idStr.isEmpty()) {
            id = Integer.parseInt(idStr);
        }

        // Create a new student object
        StudentDB student = new StudentDB(firstName, lastName, address, gender, age, dob, parent1, parent2, emerContact);
        if (id != 0) {
            student.setId(id);
        }

        // Print the student information
        System.out.println("\nStudent information:");
        System.out.println(student);
    }

    private static Guardian readGuardian(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        return new Guardian(firstName, lastName, phone);
    }
}
