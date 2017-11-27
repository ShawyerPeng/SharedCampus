import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import java.io.IOException;

public class SendGridTest {
    public static void main(String[] args) throws IOException {
        try {
            SendGrid sg = new SendGrid("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");
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"1002097607@qq.com\"}],\"subject\":\"Sending with SendGrid is Fun\"}],\"from\":{\"email\":\"patrickyateschn@gmail.com\"},\"content\":[{\"type\":\"text/plain\",\"value\": \"and easy to do anywhere, even with Java\"}]}");
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}