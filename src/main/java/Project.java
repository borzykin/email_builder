import java.util.ArrayList;
import java.util.Scanner;

public class Project {

    private Scanner reader = new Scanner(System.in);
    private String projectName;
    private Double projectTime;

    private ArrayList<String> typesOfTesting = new ArrayList<>();
    ArrayList<String> devices = new ArrayList<>();
    ArrayList<String> builds = new ArrayList<>();
    ArrayList<String> bugsCreated = new ArrayList<>();
    ArrayList<String> bugsReopened = new ArrayList<>();
    ArrayList<String> bugsClosed = new ArrayList<>();

    public Project(String name, Double time) {
        this.projectName = name;
        this.projectTime = time;
    }

    public void setTypesOfTesting() {
        System.out.println("Enter data about project " + projectName + "...");
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
                    String functionalProjectItem = "- Функциональное тестирование приложения " + projectName;
                    if (!typesOfTesting.contains(functionalProjectItem)) {
                        typesOfTesting.add(functionalProjectItem);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 2:
                    String regressionProjectItem = "- Регрессионное тестирование приложения " + projectName;
                    if (!typesOfTesting.contains(regressionProjectItem)) {
                        typesOfTesting.add(regressionProjectItem);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 3:
                    String byChecklist = "- Тестирование по чек-листу приложения " + projectName;
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
                    System.out.println("Invalid code. Please choose between 1 - 5 or 0 to exit");
                    typeInput = reader.nextInt();
                    break;
            }
        }
    }

    public ArrayList<String> getTypesOfTesting() {
        return typesOfTesting;
    }

}


