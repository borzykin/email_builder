import java.util.ArrayList;
import java.util.Scanner;

public class DataCollector {

    double totalWorked;
    int totalProjects;
    ArrayList<String> projectNames = new ArrayList<>();
    ArrayList<Double> projectTimes = new ArrayList<>();
    ArrayList<ArrayList<String>> projects = new ArrayList<ArrayList<String>>();

    public void collectData() {
        setHoursWorked();
        setTotalProjectToday();
        setGeneralProjectsData();
        for (int i = 0; i < totalProjects; i++) {
            System.out.println("Enter data about project " + (i + 1) + "...");
            setDetailedProjectsData(projectNames.get(i), projectTimes.get(i));
        }

        System.out.println(totalWorked);
        System.out.println(totalProjects);
        System.out.println(projectNames);
        System.out.println(projectTimes);
        System.out.println(projects);
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

    private void setGeneralProjectsData() {
        int i = 0;
        while (i < totalProjects) {
            System.out.print("Enter project name: ");
            Scanner reader = new Scanner(System.in);
            projectNames.add(reader.nextLine());
            System.out.print("Enter project time: ");
            projectTimes.add(reader.nextDouble());
            i++;
        }
    }

    private void setDetailedProjectsData(String name, double time) {
        // nothing better than creating the list of lists
        Scanner reader = new Scanner(System.in);
        ArrayList<String> typesOfTesting = new ArrayList<>();

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
        projects.add(typesOfTesting);
    }
}

