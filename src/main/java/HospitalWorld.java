import java.util.Scanner;

public class HospitalWorld {
    public static void main(String[] args) {
        // your code here

        System.out.println("WELCOME!!!!");

        try (Scanner scanner = new Scanner(System.in)) {

            String hospitalName;
            while (true) {
                System.out.println("Please give a name to your hospital!");

                hospitalName = scanner.nextLine();

                if (hospitalName.length() != 0) {
                    break;
                }

                System.out.println("Please enter a name!");
            }

            var hospital = new Hospital(hospitalName);

            System.out.println("You will create doctors now for your hospital...");
            System.out.println("How many doctors do you want to create for your hospital? Please enter a number...");
            String numTimes = scanner.nextLine();
            int num = Integer.parseInt(numTimes);
            System.out.println("Ok now you can start to create your doctors ....");
            addPeople(num, scanner, hospital, true);
            System.out.println("Ok , it is now time for patients....");
            System.out.println("How many patients do you want to create for your hospital? Please enter a number...");
            numTimes = scanner.nextLine();
            num = Integer.parseInt(numTimes);
            addPeople(num, scanner, hospital, false);

            System.out.println("This is your hospital structure: ");
            System.out.println(hospital);

        }

    }

    static void addPeople(int numTimes, Scanner scanner, Hospital hospital, boolean isDoctor) {

        String person = isDoctor ? "Doctor" : "Patient";

        for (int i = 1; i <= numTimes; i++) {
            System.out.println(person + " no " + i + " ...");
            System.out.println("Please type a name for your " + person + ":");
            String name = scanner.nextLine();

            if (name.length() == 0 || isParsable(name)) {
                i = i - 1;
                System.out.println("You have to enter a name!");
                continue;
            }

            printDivisions();
            while (true) {

                String option = scanner.nextLine();
                int optionNum = Integer.parseInt(option);

                if (optionNum < 1 || optionNum > 3) {
                    System.out.println("You need to select a option from 1 to 3 ");
                } else {
                    String selectedOption = hospital.divisions.get(optionNum - 1).name;
                    if (isDoctor) {
                        hospital.addDoc(name, selectedOption);
                    } else {
                        hospital.addPatient(name, selectedOption);
                    }

                    break;
                }
            }
        }

    }

    static void printDivisions() {
        System.out.print("Please choose a division...");
        System.out.println(" --------- Divisions --------- ");
        System.out.println("|  1.    Radiology            |");
        System.out.println("|  2.    Dermatology          |");
        System.out.println("|  3.    Cardiology           |");
        System.out.println(" ----------------------------- ");

    }

    static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

}
