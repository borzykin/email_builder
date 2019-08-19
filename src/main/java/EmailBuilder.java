import java.util.ArrayList;
import java.util.Scanner;

public class EmailBuilder {


    public static void main(String[] args) {
//        MailBuilder mailBuilder = new MailBuilder();
//        //It's a draft. MailBuilder and ProjectBuilder are needed to be refactored
//        StringBuilder email = mailBuilder.emailBuilder();
//        WebInterface webInterface = new WebInterface();
//        webInterface.sendEmail(email);
//        Input input = new Input(new Scanner(System.in));//Input object can be used to obtain needed input with appropriate methods
//        //Example
//        System.out.println(input.getClosedBugs());

        DataCollector data = new DataCollector();
        data.collectData();
    }


}
