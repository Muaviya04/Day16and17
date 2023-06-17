import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    String name;
    int amount;
    boolean isDeposit;

    public Person(String name, int amount, boolean isDeposit) {
        this.name = name;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }
}

class CashCounter {
    private int cashBalance;
    private Queue<Person> queue;

    public CashCounter() {
        cashBalance = 0;
        queue = new LinkedList<>();
    }

    public void addPerson(String name, int amount, boolean isDeposit) {
        Person person = new Person(name, amount, isDeposit);
        queue.add(person);
    }

    public void processQueue() {
        while (!queue.isEmpty()) {
            Person person = queue.poll();
            if (person.isDeposit) {
                cashBalance += person.amount;
                System.out.println(person.name + " deposited $" + person.amount);
            } else {
                if (person.amount > cashBalance) {
                    System.out.println(person.name + " does not have sufficient funds to withdraw $" + person.amount);
                } else {
                    cashBalance -= person.amount;
                    System.out.println(person.name + " withdrew $" + person.amount);
                }
            }
        }
    }

    public void displayCashBalance() {
        System.out.println("Cash Balance: $" + cashBalance);
    }
}

public class CashCounterProgram {
    public static void main(String[] args) {
        CashCounter cashCounter = new CashCounter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add person to queue for deposit");
            System.out.println("2. Add person to queue for withdrawal");
            System.out.println("3. Process queue");
            System.out.println("4. Display cash balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter person's name: ");
                    String depositName = scanner.nextLine();
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    cashCounter.addPerson(depositName, depositAmount, true);
                    break;
                case 2:
                    System.out.print("Enter person's name: ");
                    String withdrawalName = scanner.nextLine();
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawalAmount = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    cashCounter.addPerson(withdrawalName, withdrawalAmount, false);
                    break;
                case 3:
                    cashCounter.processQueue();
                    break;
                case 4:
                    cashCounter.displayCashBalance();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}