import java.util.ArrayList;
import java.util.Scanner;

public class DataCollector {

    double totalWorked;
    int totalProjects;
    ArrayList<Project> projectsList = new ArrayList<>();

    public void collectData() {
        setHoursWorked();
        setTotalProjectToday();

        for (int i = 0; i < totalProjects; i++) {
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter project name: ");
            String nameInput = reader.nextLine();
            System.out.print("Enter project time: ");
            Double timeInput = Double.parseDouble(reader.nextLine()); // with nextDouble scanner somehow grabs space as input for second project,
                                                                      // so we will user Double.parseDouble. Maybe it is worth to add try / catch block here
            Project project = new Project(nameInput, timeInput);
            project.setTypesOfTesting();
            project.setDevices();
            project.setBuilds();
            project.setBugsCreated();
            project.setBugsReopened();
            project.setBugsClosed();

            projectsList.add(project);
        }

        // temp test code for 1 project added
        System.out.println(projectsList.get(0).getProjectHeader());
        System.out.println(projectsList.get(0).getTypesOfTesting());
        System.out.println(projectsList.get(0).getDevices());
        System.out.println(projectsList.get(0).getBuilds());
        System.out.println(projectsList.get(0).getBugsCreated());
        System.out.println(projectsList.get(0).getBugsReopened());
        System.out.println(projectsList.get(0).getBugsClosed());
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
}

