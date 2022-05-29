package be.fednot.testguillermo.model;


import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class VATNumber {

    public static final String VAT_PATTERN = "^(?=([A-Za-z]{2,4}))\\1(?![\\W_]+$)(?=.{2,12}$)[-_ \\d]*(?:[a-zA-Z][-_ \\d]*){0,2}$";
    private String vatNumber;

    public VATNumber() {
    }

    public VATNumber(String vatNumber) {
        Validation.checkThat(vatNumber != null && !vatNumber.isBlank(), "VAT number must not be null or blank");
        Validation.checkThat(Pattern.matches(VAT_PATTERN, vatNumber), "VAT number must be valid");
        this.vatNumber = vatNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }
}
