package be.fednot.testguillermo.model;


import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class PhoneNumber {

    public static final String PHONE_NUMBER_PATTERN = "^[+]*[(]?\\d{1,4}[)]?[-\\s./\\d]*$";
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(String phoneNumber) {
        Validation.checkThat(phoneNumber != null && !phoneNumber.isEmpty(), "phone number must not be empty or null");
        Validation.checkThat(Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber), "Phone number must be valid");
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
