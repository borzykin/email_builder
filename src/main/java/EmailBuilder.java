public class EmailBuilder {

    public static void main(String[] args) {

        DataCollector data = new DataCollector();
        data.collectData();

        Project project = data.getFullProject(0);

        WebInterface web = new WebInterface();
        web.loginToGmailAndClickCompose(project.toString());

    }

}
