import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 A program to add, remove, modify or print
 student names and grades.
 */
public class Gradebook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // TODO: Fill in variables, etc.
        TreeMap<String, String> students = new TreeMap<>();

        String[] names = {"Bob", "Lex", "Sally", "Jeff", "Nathan"};
        String[] grades = {"A", "B", "C", "D", "F"};
        for (int i = 0; i < names.length; i++)
            students.put(names[i], grades[i]);

        String firstName, grade;
        boolean done = false;
        System.out.println("Welcome to the Online Gradebook! \nWhat would you like to do?\n");
        while (!done) {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q")) {
                done = true;
            } else if (input.equals("A")) {
                System.out.println("What is the first name of the student?");
                firstName = in.next();
                in.nextLine();
                System.out.println("What is " + firstName + "'s grade?");
                grade = in.next();
                students.put(firstName, grade);
                System.out.println("Student successfully added!\n");
            } else if (input.equals("R")) {
                System.out.println("Which student do you want to remove?");
                firstName = in.next();
                if (students.containsKey(firstName)) {
                    students.remove(firstName);
                    System.out.println("Student successfully removed!\n");
                }
                else
                    System.out.println("Student not found!\n");
            } else if (input.equals("M")) {
                System.out.println("Which student do you want to modify?");
                firstName = in.next();
                in.nextLine();
                System.out.println("What is " + firstName + "'s new grade?");
                grade = in.next();
                students.replace(firstName, grade);
                System.out.println("Student successfully modified!\n");
            } else if (input.equalsIgnoreCase("P")) {

                System.out.println("Printed students and grades...");
                Set<String> keys = students.keySet();
                for (String student : keys)
                    System.out.println("Student Name: " + student + " - Grade: " + students.get(student));
                System.out.println("");
            } else {
                System.out.println("Goodbye...");
                done = true;
            }
        }
    }
}