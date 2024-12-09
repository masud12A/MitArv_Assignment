package utilities;

import java.io.IOException;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class EmailUtils {

    private static final String API_KEY = "iw3n3Syy8IbjJNDb7AoGrbkaYPUh1dGz";
    private static final String SERVER_ID = "vbcximhj";
    private static final String SERVER_DOMAIN = "vbcximhj.mailosaur.net";
    private static final String FROM = "support@mittarv.com";

    private static final MailosaurClient mailosaur = new MailosaurClient(API_KEY);

    public static String getRandomEmail() {
        return "user" + System.currentTimeMillis() + "@" + SERVER_DOMAIN;
    }

    public static String fetchOTP(String email) throws MailosaurException, IOException {
        MessageSearchParams params = new MessageSearchParams();
        params.withServer(SERVER_ID);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo(email);
        criteria.withSentFrom(FROM);

        Message message = mailosaur.messages().get(params, criteria);

        System.out.println(message.text().body());
        Code otpCode = message.html().codes().get(0);
        return otpCode.value();
    }
}
