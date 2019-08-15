import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    double houseWorked;
    int totalProjectToday;
    String projectName;
    int projectNumber;
    double projectTime;
    int testingType;
    String devices;
    String createdBugs;
    String reopenedBugs;
    String closedBugs;

    private Scanner scanner;

    public Input(Scanner scanner){
        this.scanner = scanner;
    }

    public double getHouseWorked() {
        return scanner.nextDouble();
    }

    public int getTotalProjectToday() {
        return scanner.nextInt();
    }

    public String getProjectName() {
        return scanner.nextLine();
    }

    public int getProjectNumber() {
        return scanner.nextInt();
    }

    public double getProjectTime() {
        return scanner.nextDouble();
    }

    public int getTestingType() {
        return scanner.nextInt();
    }

    public String getDevices() {
        return scanner.nextLine();
    }

    public String getCreatedBugs() {
        return scanner.nextLine();
    }

    public String getReopenedBugs() {
        return scanner.nextLine();
    }

    public String getClosedBugs() {
        return scanner.nextLine();
    }
}
