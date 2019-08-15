import java.util.ArrayList;
import java.util.Scanner;

public class EmailBuilder {

    public static void main(String[] args) {
        StringBuilder email = emailBuilder();
        WebInterface webInterface = new WebInterface();
        webInterface.sendEmail(email);
    }

    private static StringBuilder emailBuilder() {
        double totalWorked = getHoursWorked();
        int totalProjects = getTotalProjectToday();

        ArrayList<String> project = new ArrayList<>();
        ArrayList<Double> projectTimes = new ArrayList<>();

        for (int i = 0; i < totalProjects; i++) {
            System.out.println("Enter data about project " + (i + 1) + "...");
            project.add(getProjectName());
            projectTimes.add(getProjectTime());
        }

        StringBuilder header = new StringBuilder();
        header.append(emailHeader(totalWorked).append("\n"));

        StringBuilder projectsBlock = new StringBuilder();
        for (int i = 0; i < totalProjects; i++) {
            projectsBlock.append(buildProject(project.get(i), projectTimes.get(i)));
            projectsBlock.append("\n");
        }

        StringBuilder footer = new StringBuilder();
        footer.append("Задачи планируемые на завтра - нет" + "\n" + "\n" + "Текущие проблемы - нет");

        return header.append(projectsBlock).append(footer);

    }

    private static double getHoursWorked() {
        System.out.print("Enter total hours worked: ");
        Scanner reader = new Scanner(System.in);
        return reader.nextDouble();
    }

    private static int getTotalProjectToday() {
        System.out.print("Enter how much projects: ");
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    private static String getProjectName() {
        System.out.print("Enter project name: ");
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    private static Double getProjectTime() {
        System.out.print("Enter project time: ");
        Scanner reader = new Scanner(System.in);
        return reader.nextDouble();
    }

    private static StringBuilder buildProject(String name, double time) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> devices = new ArrayList<>();
        ArrayList<String> builds = new ArrayList<>();
        ArrayList<String> bugsCreated = new ArrayList<>();
        ArrayList<String> bugsReopened = new ArrayList<>();
        ArrayList<String> bugsClosed = new ArrayList<>();
        ArrayList<String> typesOfTesting = new ArrayList<>();

        // делаю красивости окончаний слов
        String hoursEnding = "";
        if (time <= 1) {
            hoursEnding = " час";
        } else if (time > 1 && time < 5) {
            hoursEnding = " часa";
        } else {
            hoursEnding = " часов";
        }

        StringBuilder projectHeader = new StringBuilder();
        projectHeader.append(name).append(" - ").append(time).append(hoursEnding).append("\n");

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

        StringBuilder typesOfTestingBlock = new StringBuilder();
        int i = 0;
        while (i < typesOfTesting.size()) {
            typesOfTestingBlock.append(typesOfTesting.get(i)).append(" \n");
            i++;
        }

        System.out.println("Enter devices or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            devices.add(input);
        }

        System.out.println("Enter builds or 0 to exit...");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("0")) {
                break;
            }
            builds.add(input);
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

        StringBuilder devicesBlock = new StringBuilder();
        devicesBlock.append("Девайсы:");
        i = 0;
        while (i < devices.size()) {
            devicesBlock.append(devices.get(i)).append(" \n");
            i++;
        }
        devicesBlock.append("\n");

        StringBuilder buildsBlock = new StringBuilder();
        buildsBlock.append("Билды: \n");
        i = 0;
        while (i < builds.size()) {
            buildsBlock.append(builds.get(i)).append(" \n");
            i++;
        }
        buildsBlock.append("\n");

        StringBuilder createdBlock = new StringBuilder();
        if (bugsCreated.size() > 0) {
            createdBlock.append("Заведено " + bugsCreated.size() + " дефектов:" + "\n");
            i = 0;
            while (i < bugsCreated.size()) {
                createdBlock.append(bugsCreated.get(i)).append(" \n");
                i++;
            }
        }

        StringBuilder reopenedBlock = new StringBuilder();
        if (bugsReopened.size() > 0) {
            if (bugsCreated.size() > 0) {createdBlock.append("\n");}
            reopenedBlock.append("Переоткрыто " + bugsReopened.size() + " дефектов:" + "\n");
            i = 0;
            while (i < bugsReopened.size()) {
                reopenedBlock.append(bugsReopened.get(i)).append(" \n");
                i++;
            }
        }

        StringBuilder closedBlock = new StringBuilder();
        if (bugsClosed.size() > 0) {
            if (bugsReopened.size() > 0 || bugsCreated.size() > 0) {reopenedBlock.append("\n");}
            closedBlock.append("Закрыто " + bugsClosed.size() + " дефектов:" + "\n");
            i = 0;
            while (i < bugsClosed.size()) {
                closedBlock.append(bugsClosed.get(i)).append(" \n");
                i++;
            }
        }

        return projectHeader.append("\n").append(typesOfTestingBlock).append("\n").append(buildsBlock).append(devicesBlock).append(createdBlock)
                .append(reopenedBlock).append(closedBlock);
    }

    private static StringBuilder emailHeader(double time) {
        StringBuilder emailHeader = new StringBuilder();
        return emailHeader.append("Добрый вечер! \nСегодня отработано - " + time + " часов \n");
    }
}
