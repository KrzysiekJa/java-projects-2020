package com.company.Substring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Substring {

    int substring(String string, String substring) {

        if(string.equals("")){
            throw new EpmtyStringException("Passed empty string.");
        }

        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(string);
        int maxIter = 10, iterNumber = 0;

        for (int i = 0; i < maxIter; ++i) {
            ++iterNumber;
            if (!matcher.find()) {
                string += string;
                matcher = pattern.matcher(string);
            } else {
                return iterNumber;
            }
        }
        return -1;
    }

    public void run() {
        String string = "abcd";
        String substring = "cdabcdab";
        int result = 0;

        try{
            result = substring(string, substring);
        }catch (IllegalArgumentException exception){
            System.out.println("Exception occured: " + exception);
        }

        System.out.println("For string :" + string + " substring :" + substring + " find after " + result + " addition of string.");
    }
}
