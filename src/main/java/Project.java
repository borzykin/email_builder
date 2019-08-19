import java.util.ArrayList;
import java.util.Scanner;

public class Project {

    private Scanner reader = new Scanner(System.in);
    private String projectName;
    private Double projectTime;

    private ArrayList<String> typesOfTesting = new ArrayList<>();
    private ArrayList<String> devices = new ArrayList<>();
    private ArrayList<String> builds = new ArrayList<>();
    private ArrayList<String> bugsCreated = new ArrayList<>();
    private ArrayList<String> bugsReopened = new ArrayList<>();
    private ArrayList<String> bugsClosed = new ArrayList<>();

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

    public void setDevices() {
        System.out.println("Enter devices or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            devices.add(input); // issue similar to what happened with nextDouble in DataCollector
            devices.remove(""); // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        }
    }

    public void setBuilds() {
        System.out.println("Enter builds or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            builds.add(input);
            builds.remove(""); // same issue that above
        }
    }

    public void setBugsCreated() {
        System.out.println("Enter bugs CREATED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            bugsCreated.add(input);
            bugsCreated.remove("");
        }
    }

    public void setBugsReopened() {
        System.out.println("Enter bugs REOPENED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            bugsReopened.add(input);
            bugsReopened.remove("");
        }
    }

    public void setBugsClosed() {
        System.out.println("Enter bugs CLOSED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            bugsClosed.add(input);
            bugsClosed.remove("");
        }
    }

    public String getProjectHeader() {
        String hoursEnding;
        if (projectTime <= 1) {
            hoursEnding = " час";
        } else if (projectTime > 1 && projectTime < 5) {
            hoursEnding = " часa";
        } else {
            hoursEnding = " часов";
        }
        return projectName + " - " + projectTime + hoursEnding + "\n";
    }


    public ArrayList<String> getTypesOfTesting() {
        return typesOfTesting;
    }

    public ArrayList<String> getDevices() {
        return devices;
    }

    public ArrayList<String> getBuilds() {
        return builds;
    }

    public ArrayList<String> getBugsCreated() {
        return bugsCreated;
    }

    public ArrayList<String> getBugsReopened() {
        return bugsReopened;
    }

    public ArrayList<String> getBugsClosed() {
        return bugsClosed;
    }


}


