package be.fednot.testguillermo.model;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class Email {
    public Email() {
    }

    public final static String EMAIL_PATTERN = "^([\\p{L}-_.]+){1,64}@([\\p{L}-_.]+){2,255}.[a-z]{2,}$";

    private String email;

    public Email(String email) {
        Validation.checkThat(Pattern.matches(EMAIL_PATTERN, email), "Email address must be valid");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
