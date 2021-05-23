package at.ac.fhcampuswien;

import static java.lang.Character.*;

public class App {

    private static final int min_len = 8; //minimal password length
    private static final int max_len = 25; //maximum password lenght


    /*
    Function to test passwords for the following criteria:
        - Must be at least 8 characters long.
        - Must be no longer than 25 characters.
        - Must contain at least one lower case character.
        - Must contain at least one upper case character.
        - Must contain at least one number.
        - Must contain at least one of the following special characters:
            - (
            - )
            - $
            - ?
            - !
            - %
            - /
            - @
            - All other special characters are not allowed.
    */
    public static boolean checkPassword(String pw){
        //set boolean flags, initiate with FALSE
        boolean hasLowerCase=false;
        boolean hasUpperCase=false;
        boolean hasNum=false;
        boolean hasSpecial=false;

        //Test for length
        if(pw.length()<min_len) return false;
        if(pw.length()>max_len) return false;

        //loop through String
        for(int i = 0; i < pw.length(); i++){

            //contains special?
            if(!isDigit(pw.charAt(i)) && !isLetter(pw.charAt(i))){
                switch (pw.charAt(i)){
                    case '(':
                    case ')':
                    case '$':
                    case '?':
                    case '!':
                    case '%':
                    case '/':
                    case '@':
                        hasSpecial=true; break;
                    default: //if the special character is not one of the listed, it is an illegal character
                        return false;
                }
            }

            //check for mandatory characters
            if(isLowerCase(pw.charAt(i))) hasLowerCase=true;
            if(isUpperCase(pw.charAt(i))) hasUpperCase=true;
            if(isDigit(pw.charAt(i))) hasNum=true;
        }

        //check for over triple characters
        for(int i = 0; i < pw.length()-4; i++){
            if(pw.charAt(i)==pw.charAt(i+1) &&
                    pw.charAt(i)==pw.charAt(i+2) &&
                    pw.charAt(i)==pw.charAt(i+3)) return false;
        }

        //all checks have passed and booleans are all true?
        return hasLowerCase && hasUpperCase && hasNum && hasSpecial; //pw is valid => return true
    }
}
