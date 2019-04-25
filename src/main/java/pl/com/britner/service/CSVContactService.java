package pl.com.britner.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVContactService {

    private static final Pattern EMAIL_VALIDATOR =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern TELEPHONE_VALIDATOR =
            Pattern.compile("^\\d{9}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern JABBER_VALIDATOR =
            Pattern.compile("^(?:([^@/<>'\"]+)@)?([^@/<>'\"]+)(?:/([^<>'\"]*))?$", Pattern.CASE_INSENSITIVE);

    public int getContactType(String pattern) {
       if (doesMatchEmail(pattern)) return 1;
       else if (doesMatchTelephone(pattern)) return 2;
       else if (doesMatchJabber(pattern)) return 3;
       else return 0;
    }

    private boolean doesMatchEmail(String contact) {
        Matcher email = EMAIL_VALIDATOR.matcher(contact);
        return email.find();
    }

    private boolean doesMatchTelephone(String contact) {
        Matcher email = TELEPHONE_VALIDATOR.matcher(contact.replaceAll(" ", ""));
        return email.find();
    }

    private boolean doesMatchJabber(String contact) {
        Matcher email = JABBER_VALIDATOR.matcher(contact);
        return email.find();
    }
}