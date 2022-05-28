package be.fednot.testguillermo.model;


import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class PhoneNumber {

    public static final String PHONE_NUMBER_PATTERN = "^[+]*[(]?\\d{1,4}[)]?[-\\s./\\d]*$";
    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        //TODO: Use PhoneNumberUtil.isPossibleNumber()
        Validation.checkThat(phoneNumber != null && !phoneNumber.isEmpty(), "phone number must not be empty or null");
        Validation.checkThat(Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber), "Phone number must be valid");
        this.phoneNumber = phoneNumber;
    }
}
