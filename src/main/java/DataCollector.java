import java.util.ArrayList;
import java.util.Scanner;

public class DataCollector {

    double totalWorked;
    int totalProjects;
    ArrayList<String> projectNames = new ArrayList<>();
    ArrayList<Double> projectTimes = new ArrayList<>();
    ArrayList<ArrayList<String>> projects = new ArrayList<>();
    ArrayList<String> bugsCreated = new ArrayList<>();
    ArrayList<String> bugsReopened = new ArrayList<>();
    ArrayList<String> bugsClosed = new ArrayList<>();
    ArrayList<Integer> totalProjectElements = new ArrayList<>();

    ArrayList<Project> projectsList = new ArrayList<>();

    public void collectData() {
        setHoursWorked();
        setTotalProjectToday();
        Scanner reader = new Scanner(System.in);

        for (int i = 0; i < totalProjects; i++) {
            System.out.print("Enter project name: ");
            String nameInput = reader.nextLine();
            System.out.print("Enter project time: ");
            Double timeInput = reader.nextDouble();

            Project project = new Project(nameInput, timeInput);
            project.setTypesOfTesting();

            projectsList.add(project);

        }

        System.out.println(projectsList.get(0).getTypesOfTesting());

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

//    private void setGeneralProjectsData() {
//        int i = 0;
//        while (i < totalProjects) {
//            System.out.print("Enter project name: ");
//            Scanner reader = new Scanner(System.in);
//            projectNames.add(reader.nextLine());
//            System.out.print("Enter project time: ");
//            projectTimes.add(reader.nextDouble());
//            i++;
//        }
//    }

    private void setDetailedProjectsData(String name, double time) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> typesOfTesting = new ArrayList<>();
        ArrayList<String> devices = new ArrayList<>();
        ArrayList<String> builds = new ArrayList<>();

        System.out.println("Select what kind on testing \n" +
                "1 for Functional\n" +
                "2 for Regression\n" +
                "3 for By Checklist\n" +
                "4 for Communication\n" +
                "5 for Writing test-cases\n" +
                "or 0 to exit...");

        int typeInput = reader.nextInt();
        while (typeInput != 0) {
            switch (typeInput) {
                case 1:
                    String functionalProjectItem = "- Функциональное тестирование приложения " + name;
                    if (!typesOfTesting.contains(functionalProjectItem)) {
                        typesOfTesting.add(functionalProjectItem);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 2:
                    String regressionProjectItem = "- Регрессионное тестирование приложения " + name;
                    if (!typesOfTesting.contains(regressionProjectItem)) {
                        typesOfTesting.add(regressionProjectItem);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 3:
                    String byChecklist = "- Тестирование по чек-листу приложения " + name;
                    if (!typesOfTesting.contains(byChecklist)) {
                        typesOfTesting.add(byChecklist);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 4:
                    String communication = "- Коммуникация с заказчиком";
                    if (!typesOfTesting.contains(communication)) {
                        typesOfTesting.add(communication);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 5:
                    String testCases = "- Написание тест-кейсов";
                    if (!typesOfTesting.contains(testCases)) {
                        typesOfTesting.add(testCases);
                    }
                    typeInput = reader.nextInt();
                    break;
                default:
                    System.out.println("Invalid code. Please choose between 0,1,2");
                    typeInput = reader.nextInt();
                    break;
            }
        }

        System.out.println("Enter devices or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            devices.add(input);
            // idk code adds empty space to list, but we don't need it
            devices.remove("");
        }

        System.out.println("Enter builds or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            builds.add(input);
            // same as devices
            builds.remove("");
        }

        System.out.println("Enter bugs CREATED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            bugsCreated.add(input);
        }

        System.out.println("Enter bugs REOPENED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            bugsReopened.add(input);
        }

        System.out.println("Enter bugs CLOSED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            bugsClosed.add(input);
        }

        projects.add(typesOfTesting);
        projects.add(devices);
        projects.add(builds);
        projects.add(bugsCreated);
        projects.add(bugsReopened);
        projects.add(bugsClosed);
    }
}

