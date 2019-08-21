import java.util.ArrayList;
import java.util.Scanner;

public class DataCollector {

    private double totalWorked;
    private int totalProjects;
    private ArrayList<Project> projectsList = new ArrayList<>();

    public void collectData() {
        setHoursWorked();
        setTotalProjectToday();

        for (int i = 0; i < totalProjects; i++) {
            Scanner reader = new Scanner(System.in);
            double timeInput;

            System.out.print("Enter project name: ");
            String nameInput = reader.nextLine();
            System.out.print("Enter project time: ");
            try {
                timeInput = Double.parseDouble(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number Format! Try again!");
                e.printStackTrace();
                timeInput = 0.0;
            }
            Project project = new Project(nameInput, timeInput);
            project.setTypesOfTesting();
            project.setDevices();
            project.setBuilds();
            project.setBugsCreated();
            project.setBugsReopened();
            project.setBugsClosed();

            projectsList.add(project);
        }
    }

    private void setHoursWorked() {
        System.out.print("Enter total hours worked: ");
        Scanner reader = new Scanner(System.in);
        totalWorked = reader.nextDouble();
    }

    private void setTotalProjectToday() {
        System.out.print("Enter how much projects: ");
        Scanner reader = new Scanner(System.in);
        totalProjects = reader.nextInt();
    }

    public Project getFullProject(int index) {
        return projectsList.get(index);
    }

    public int getProjectsNumber() {
        return projectsList.size();
    }
}

