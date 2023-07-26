

import java.util.Scanner;
import  java.lang.NullPointerException;
import java.util.regex.*;

class Node {
    String name;
    String number;
    String gmail;
    Node next;

    public Node(String name, String number, String gmail) {
        this.name = name;
        this.number = number;
        this.gmail = gmail;
        this.next = null;

    }


}


class Phonebook {

    Node head;

    public Phonebook() {

        head = null;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }
    private boolean isValidNumber(String number) {
        // Define your validation criteria here
        // Example: Check if the number contains only digits
        String regex = "\\d+";

        // Check if the input is a valid number
        return number.matches(regex);
    }

    // Method to validate the Gmail address
    private boolean isValidGmail(String gmail) {
        // Define your validation criteria here
        // Example: Check if the address matches the general Gmail address format
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Check if the input is a valid Gmail address
        return gmail.matches(regex);
    }


    public void insert() {
        Scanner scanner = new Scanner(System.in);

        String name;
        String number;
        String gmail;

        while (true) {
            System.out.print("Enter name: ");
            name = scanner.nextLine();

            System.out.print("Enter number: ");
            number = scanner.nextLine();

            System.out.print("Enter Gmail: ");
            gmail = scanner.nextLine();

            // Perform validation
            boolean isValidNumber = isValidNumber(number);
            boolean isValidGmail = isValidGmail(gmail);

            if (isValidNumber && isValidGmail) {
                // Both number and Gmail address are valid, proceed with further operations
                Node newNode = new Node(name, number, gmail);

                if (head == null) {
                    head = newNode;
                } else {
                    Node current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }

                System.out.println("Contact added successfully!");
                break; // Exit the loop as the input is valid

            } else {
                // Display error message for each invalid field
                if (!isValidNumber) {
                    System.out.println("Please enter the numbers. Please try again.");
                }
                if (!isValidGmail) {
                    System.out.println("Invalid Gmail address entered. Please try again.");
                }
            }
        }
    }


    public void display() {
        if(isEmpty()==true) {
            System.out.println("Contact list  is empty");

        }
        boolean swapped;
        Node current;
        Node prev = null;

        if (head == null)
            return;

        do {
            swapped = false;
            current = head;

            while (current.next != prev) {
                if (current.name.compareTo(current.next.name) > 0) {
                    // Swapping the data of current and next nodes
                    String temp = current.name;
                    current.name = current.next.name;
                    current.next.name = temp;
                    swapped = true;
                }
                current = current.next;
            }
            prev = current;
        } while (swapped);


        Node curr = head;

        while (curr != null) {

            System.out.println("Name is " +""+ curr.name);
            System.out.println("Number is " +""+ curr.number);
            System.out.println("Gmail is " +""+ curr.gmail);
            System.out.println();
            curr = curr.next;
        }

    }

    public void delete(String name) {

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Contact deleted successfully!");
            return;

        }

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.name.equals(name)) {
                prev.next = current.next;
                System.out.println("Contact deleted successfully!");
                return;
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Contact not found!");
    }


    public void update() {
        if(isEmpty()==true) {
            System.out.println("Contact list  is empty");

        }
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Update name");
        System.out.println("2. Update number");
        System.out.println("3. Update gmail");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

                sc.nextLine(); // Consume the newline character

                System.out.print("Enter the name of the  update ");
                String names = sc.nextLine();


                System.out.print("Enter the new name ");
                String name1 = sc.nextLine();

                if (head.name.equals(names)) {

                    head.name = name1;
                    System.out.println("Contact updated successfully!");
                    return;

                }


                Node current = head.next;

                while (current != null) {
                    if (current.name.equals(names)) {
                        current.name = name1;
                        System.out.println("Contact updated successfully!");
                        return;
                    }

                    current = current.next;
                }
                System.out.println("Contact not found!");



        } else if (choice == 2) {
            while (true) {
                sc.nextLine(); // Consume the newline character
                System.out.print("Enter the number of the  update ");
                String numbers = sc.nextLine();

                boolean isValidNumber = isValidNumber(numbers);
                if(isValidNumber){
                    System.out.print("Enter the new number ");
                    String num = sc.nextLine();

                    if (head.number.equals(numbers)) {
                        head.number = num;
                        System.out.println("Contact updated successfully!");
                        return;

                    }


                    Node current = head.next;

                    while (current != null) {
                        if (current.number.equals(numbers)) {
                            current.number = num;
                            System.out.println("Contact updated successfully!");
                            return;
                        }

                        current = current.next;
                    }

                    System.out.println("Contact not found!");
                }
                else{
                    System.out.println("Please enter numbers");
                }

            }
        }
        else if (choice == 3) {
            while (true) {
                sc.nextLine(); // Consume the newline character
                System.out.print("Enter the Gmail of the  update ");
                String Gmail = sc.nextLine();
                boolean isValidGmail = isValidGmail(Gmail);
                if (isValidGmail) {
                    System.out.print("Enter the Gmail ");
                    String gmails = sc.nextLine();


                    if (head.gmail.equals(Gmail)) {
                        head.number = gmails;
                        System.out.println("Gmail updated successfully!");
                        return;

                    }


                    Node current = head.next;

                    while (current != null) {
                        if (current.gmail.equals(Gmail)) {
                            current.gmail = gmails;
                            System.out.println("Contact updated successfully!");
                            return;
                        }

                        current = current.next;
                    }

                    System.out.println("gmail not found!");

                }
                else {
                    System.out.println("Please enter correct gmail");
                }
            }

        }

        else {

            System.out.println("Error");
        }


    }

    public void search(String names) {


            Node current = head;
            while (current != null) {
                if (current.name.equals(names)) {
                    System.out.println("Name is " + "" + names);
                    System.out.println("Number is " + "" + current.number);
                    System.out.println("Gmail is " + "" + current.gmail);
                    return;

                }
                current = current.next;

            }

    }





public  void sdelete(){
    if(isEmpty()==true) {
        System.out.println("Contact list  is empty");

    }
    Node current = head;

    while (current != null) {
        Node runner = current;
        while (runner.next != null) {
            if (runner.next.name .equals(current.name) ) {
                runner.next = runner.next.next;
                System.out.println("found duplicate record and deleted");
            } else {
                runner = runner.next;
            }
        }
        current = current.next;
    }



    }



}





    public class App1 {


    public static void main(String[] args) {

        Phonebook phoneBook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("                                   Welcome");
            System.out.println("1. Insert contact");
            System.out.println("2. Display All contact details");
            System.out.println("3. Delete contact");
            System.out.println("4. Update contact");
            System.out.println("5. Search number");
            System.out.println("6. Delete same contact");
            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    phoneBook.insert();
                    break;
                case 2:
                phoneBook.display();
                    break;
                case 3:
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the name of the contact to delete: ");
                    String nameToDelete = scanner.nextLine();
                    if(phoneBook.isEmpty()==true) {
                        System.out.println("Contact list  is empty");
                        break;
                    }
                    phoneBook.delete(nameToDelete);
                    break;
                case 4:
                    if(phoneBook.isEmpty()==true) {
                        System.out.println("Contact list  is empty");
                        break;
                    }
                    phoneBook.update();
                    break;
                case 5:
                    if(phoneBook.isEmpty()==true) {
                        System.out.println("Contact list  is empty");
                        break;
                    }
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter the name of the search: ");
                    String namesss = scanner.nextLine();
                    phoneBook.search(namesss);
                    break;

                case 6:
                    phoneBook.sdelete();



            }



            System.out.print("Do you want to continue? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();



}
}
