package com.example.miniwebapp.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidation {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean check(String mail){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
        return matcher.find();
    }
}
