import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Project {

    private Scanner reader = new Scanner(System.in);
    private String projectName;
    private Double projectTime;
    private HashMap<String, ArrayList<String>> stringMap = new HashMap<>();

    public Project(String name, Double time) {
        this.projectName = name;
        this.projectTime = time;
        //stringMap keys init
        stringMap.put("typesOfTesting", new ArrayList<>());
        stringMap.put("builds", new ArrayList<>());
        stringMap.put("devices", new ArrayList<>());
        stringMap.put("bugsCreated", new ArrayList<>());
        stringMap.put("bugsReopened", new ArrayList<>());
        stringMap.put("bugsClosed", new ArrayList<>());
    }

    public String toString() {
    return getProjectHeader() + "with total bugs: " + (getBugsClosed().size() + getBugsCreated().size() + getBugsReopened().size());
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
//Proposition: All input methods move to DataCollector class
        int typeInput = reader.nextInt();
        while(typeInput != 0) {
            switch (typeInput) {
                case 0:
                    break;
                case 1:
                    String functionalProjectItem = "- Функциональное тестирование приложения " + projectName;
                    //Insane but here it is! HashMap of ArrayList
                    //Some add method looks pretty weird though
                    if (!stringMap.get("typesOfTesting").contains(functionalProjectItem))
                        stringMap.get("typesOfTesting").add(functionalProjectItem);
                    typeInput = reader.nextInt();
                    break;
                case 2:
                    String regressionProjectItem = "- Регрессионное тестирование приложения " + projectName;
                    if (!stringMap.get("typesOfTesting").contains(regressionProjectItem)) {
                        stringMap.get("typesOfTesting").add(regressionProjectItem);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 3:
                    String byChecklist = "- Тестирование по чек-листу приложения " + projectName;
                    if (!stringMap.get("typesOfTesting").contains(byChecklist)) {
                        stringMap.get("typesOfTesting").add(byChecklist);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 4:
                    String communication = "- Коммуникация с заказчиком";
                    if (!stringMap.get("typesOfTesting").contains(communication)) {
                        stringMap.get("typesOfTesting").add(communication);
                    }
                    typeInput = reader.nextInt();
                    break;
                case 5:
                    String testCases = "- Написание тест-кейсов";
                    if (!stringMap.get("typesOfTesting").contains(testCases)) {
                        stringMap.get("typesOfTesting").add(testCases);
                    }
                    typeInput = reader.nextInt();
                    break;
                default:
                    System.out.println("Invalid code. Please choose between 1 - 5 or 0 to exit");
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
            stringMap.get("devices").add(input); // issue similar to what happened with nextDouble in DataCollector
            stringMap.get("devices").remove(""); // https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        }
    }

    public void setBuilds() {
        System.out.println("Enter builds or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            stringMap.get("builds").add(input);
            stringMap.get("builds").remove(""); // same issue that above
        }
    }

    public void setBugsCreated() {
        System.out.println("Enter bugs CREATED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            stringMap.get("bugsCreated").add(input);
            stringMap.get("bugsCreated").remove("");
        }
    }

    public void setBugsReopened() {
        System.out.println("Enter bugs REOPENED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            stringMap.get("bugsReopened").add(input);
            stringMap.get("bugsReopened").remove("");
        }
    }

    public void setBugsClosed() {
        System.out.println("Enter bugs CLOSED or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            stringMap.get("bugsClosed").add(input);
            stringMap.get("bugsClosed").remove("");
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
        return stringMap.get("typesOfTesting");
    }

    public ArrayList<String> getDevices() {
        return stringMap.get("devices");
    }

    public ArrayList<String> getBuilds() {
        return stringMap.get("builds");
    }

    public ArrayList<String> getBugsCreated() {
        return stringMap.get("bugsCreated");
    }

    public ArrayList<String> getBugsReopened() {
        return stringMap.get("bugsReopened");
    }

    public ArrayList<String> getBugsClosed() {
        return stringMap.get("bugsClosed");
    }


}


