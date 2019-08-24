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
            Project p = data.getFullProject(j);
            web.enterDataToEmailBold(buildProjectHeader(p));
            web.enterDataToEmail(buildProjectBody(p));
        }

        // Don't forget to add footer
        web.enterDataToEmail(buildFooter());
    }

    private static StringBuilder buildEmailHeader(DataCollector data) {
        StringBuilder head = new StringBuilder();
        return head.append("Добрый вечер! \n \n").append("Сегодня отработано " + data.getTotalWorked() + " часов \n");
    }

    private static StringBuilder buildProjectHeader(Project p) {
        StringBuilder header = new StringBuilder();
        header.append("\n").append(p.getProjectHeader()).append("\n");
        return header;
    }

    private static StringBuilder buildProjectBody(Project p) {

        // building activities block
        StringBuilder typesOfTestingBlock = new StringBuilder();
        int i = 0;
        while (i < p.getTypesOfTesting().size()) {
            typesOfTestingBlock.append(p.getTypesOfTesting().get(i)).append(" \n");
            i++;
        }

        // building devices block
        StringBuilder devicesBlock = new StringBuilder();
        devicesBlock.append("Девайсы: \n");
        i = 0;
        while (i < p.getDevices().size()) {
            devicesBlock.append(p.getDevices().get(i)).append(" \n");
            i++;
        }
        devicesBlock.append("\n");

        // building builds block
        StringBuilder buildsBlock = new StringBuilder();
        buildsBlock.append("Билды: \n");
        i = 0;
        while (i < p.getBuilds().size()) {
            buildsBlock.append(p.getBuilds().get(i)).append(" \n");
            i++;
        }
        buildsBlock.append("\n");

        // building created bugs block
        StringBuilder createdBlock = new StringBuilder();
        if (p.getBugsCreated().size() > 0) {
            createdBlock.append("Заведено " + p.getBugsCreated().size() + " дефектов:" + "\n");
            i = 0;
            while (i < p.getBugsCreated().size()) {
                createdBlock.append(p.getBugsCreated().get(i)).append(" \n");
                i++;
            }
        }

        // building reopened bugs block
        StringBuilder reopenedBlock = new StringBuilder();
        if (p.getBugsReopened().size() > 0) {
            if (p.getBugsReopened().size() > 0) {
                createdBlock.append("\n");
            }
            reopenedBlock.append("Переоткрыто " + p.getBugsReopened().size() + " дефектов:" + "\n");
            i = 0;
            while (i < p.getBugsReopened().size()) {
                reopenedBlock.append(p.getBugsReopened().get(i)).append(" \n");
                i++;
            }
        }

        // building closed bugs block
        StringBuilder closedBlock = new StringBuilder();
        if (p.getBugsClosed().size() > 0) {
            if (p.getBugsClosed().size() > 0 || p.getBugsClosed().size() > 0) {
                reopenedBlock.append("\n");
            }
            closedBlock.append("Закрыто " + p.getBugsClosed().size() + " дефектов:" + "\n");
            i = 0;
            while (i < p.getBugsClosed().size()) {
                closedBlock.append(p.getBugsClosed().get(i)).append(" \n");
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
