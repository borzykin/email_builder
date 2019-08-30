public class EmailBuilder {

    public static void main(String[] args) {

        DataCollector data = new DataCollector();
        data.collectData();

        // Time to enter data to email via WebInterface
        WebInterface web = new WebInterface();
        web.loginToGmailAndClickCompose();
        web.enterEmailSubject();
        web.enterDataToEmail(buildEmailHeader(data));

        // Enter all project header as bold and body as regular text
        for (int j = 0; j < data.getTotalProjects(); j++) {
            Project project = data.getFullProject(j);
            web.enterDataToEmailBold(buildProjectHeader(project));
            web.enterDataToEmail(buildProjectBody(project));
        }

        // Don't forget to add footer
        web.enterDataToEmail(buildFooter());
    }

    private static StringBuilder buildEmailHeader(DataCollector data) {
        StringBuilder head = new StringBuilder();
        return head.append("Добрый вечер! \n \n").append("Сегодня отработано " + data.getTotalWorked() + " часов \n");
    }

    private static StringBuilder buildProjectHeader(Project project) {
        StringBuilder header = new StringBuilder();
        header.append("\n").append(project.getProjectHeader()).append("\n");
        return header;
    }

    private static StringBuilder buildProjectBody(Project project) {

        // building activities block
        StringBuilder typesOfTestingBlock = new StringBuilder();
        int i = 0;
        while (i < project.getTypesOfTesting().size()) {
            typesOfTestingBlock.append(project.getTypesOfTesting().get(i)).append(" \n");
            i++;
        }

        // building devices block
        StringBuilder devicesBlock = new StringBuilder();
        devicesBlock.append("Девайсы: \n");
        i = 0;
        while (i < project.getDevices().size()) {
            devicesBlock.append(project.getDevices().get(i)).append(" \n");
            i++;
        }
        devicesBlock.append("\n");

        // building builds block
        StringBuilder buildsBlock = new StringBuilder();
        buildsBlock.append("Билды: \n");
        i = 0;
        while (i < project.getBuilds().size()) {
            buildsBlock.append(project.getBuilds().get(i)).append(" \n");
            i++;
        }
        buildsBlock.append("\n");

        // building created bugs block
        StringBuilder createdBlock = new StringBuilder();
        if (project.getBugsCreated().size() > 0) {
            createdBlock.append("Заведено " + project.getBugsCreated().size() + " дефектов:" + "\n");
            i = 0;
            while (i < project.getBugsCreated().size()) {
                createdBlock.append(project.getBugsCreated().get(i)).append(" \n");
                i++;
            }
        }

        // building reopened bugs block
        StringBuilder reopenedBlock = new StringBuilder();
        if (project.getBugsReopened().size() > 0) {
            if (project.getBugsReopened().size() > 0) {
                createdBlock.append("\n");
            }
            reopenedBlock.append("Переоткрыто " + project.getBugsReopened().size() + " дефектов:" + "\n");
            i = 0;
            while (i < project.getBugsReopened().size()) {
                reopenedBlock.append(project.getBugsReopened().get(i)).append(" \n");
                i++;
            }
        }

        // building closed bugs block
        StringBuilder closedBlock = new StringBuilder();
        if (project.getBugsClosed().size() > 0) {
            if (project.getBugsClosed().size() > 0 || project.getBugsClosed().size() > 0) {
                reopenedBlock.append("\n");
            }
            closedBlock.append("Закрыто " + project.getBugsClosed().size() + " дефектов:" + "\n");
            i = 0;
            while (i < project.getBugsClosed().size()) {
                closedBlock.append(project.getBugsClosed().get(i)).append(" \n");
                i++;
            }
        }

        return typesOfTestingBlock.append("\n")
                .append(buildsBlock)
                .append(devicesBlock)
                .append(createdBlock)
                .append(reopenedBlock)
                .append(closedBlock);
    }

    private static StringBuilder buildFooter() {
        StringBuilder footer = new StringBuilder();
        return footer.append("\nЗадачи планируемые на завтра - нет" + "\n" + "\n" + "Текущие проблемы - нет");
    }
}
