package bugtracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BugTracker tracker = new BugTracker();

        while (true) {
            System.out.println("\nBug Tracker Menu:");
            System.out.println("1. Add Bug");
            System.out.println("2. List All Bugs");
            System.out.println("3. Filter Bugs");
            System.out.println("4. Update Bug Status");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Severity (LOW, MEDIUM, HIGH): ");
                    Severity severity = Severity.valueOf(scanner.nextLine().toUpperCase());
                    Bug newBug = new Bug(title, desc, severity, Status.OPEN);
                    tracker.addBug(newBug);
                    System.out.println("Bug added.");
                    break;

                case 2:
                    for (Bug bug : tracker.getAllBugs()) {
                        displayBug(bug);
                    }
                    break;

                case 3:
                    System.out.print("Filter Severity (LOW, MEDIUM, HIGH or blank): ");
                    String sevInput = scanner.nextLine();
                    Severity sevFilter = sevInput.isEmpty() ? null : Severity.valueOf(sevInput.toUpperCase());

                    System.out.print("Filter Status (OPEN, INPROGRESS, RESOLVED or blank): ");
                    String statInput = scanner.nextLine();
                    Status statFilter = statInput.isEmpty() ? null : Status.valueOf(statInput.toUpperCase());

                    for (Bug bug : tracker.filterBugs(sevFilter, statFilter)) {
                        displayBug(bug);
                    }
                    break;

                case 4:
                    System.out.print("Bug Title to update: ");
                    String bugTitle = scanner.nextLine();
                    System.out.print("New Status (OPEN, INPROGRESS, RESOLVED): ");
                    Status newStatus = Status.valueOf(scanner.nextLine().toUpperCase());
                    tracker.updateBugStatus(bugTitle, newStatus);
                    System.out.println("Status updated.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
            }
        }
    }

    private static void displayBug(Bug bug) {
        System.out.println("---------------------");
        System.out.println("Title: " + bug.getTitle());
        System.out.println("Description: " + bug.getDescription());
        System.out.println("Severity: " + bug.getSeverity());
        System.out.println("Status: " + bug.getStatus());
    }
}