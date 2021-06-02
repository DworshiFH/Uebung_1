package at.ac.fhcampuswien;

import static java.lang.Character.*;

public class App {

    private static final int min_len = 8; //minimal password length
    private static final int max_len = 25; //maximum password lenght


    /**
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
        //check for over triple characters
        if(hasQuadChar(pw)) return false;

        //check for progressing numbers
        if(progressingNums(pw)) return false;

        return pwLength(pw) && hasSpecial(pw) && hasLowerCase(pw) && hasUpperCase(pw) && hasNum(pw); //pw is valid => return true
    }

    public static boolean pwLength(String pw){
        if(pw.length()<min_len) return false;
        if(pw.length()>max_len) return false;
        return true;
    }

    public static boolean hasLowerCase(String pw){
        for(int i = 0; i < pw.length(); i++){
            if(isLowerCase(pw.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasUpperCase(String pw){
        for(int i = 0; i < pw.length(); i++){
            if(isUpperCase(pw.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasNum(String pw){
        for(int i = 0; i < pw.length(); i++){
            if(isDigit(pw.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasQuadChar(String pw){
        for(int i = 0; i < pw.length()-3; i++){ // was -4 at time of submission, changed it afterwards
            if(pw.charAt(i)==pw.charAt(i+1) &&
                    pw.charAt(i)==pw.charAt(i+2) &&
                    pw.charAt(i)==pw.charAt(i+3)) return true;
        }
        return false;
    }

    public static boolean hasSpecial(String pw){
        boolean hasSpecial=false;
        for(int i = 0; i < pw.length(); i++) {
            if (!isDigit(pw.charAt(i)) && !isLetter(pw.charAt(i))) {
                switch (pw.charAt(i)) {
                    case '(':
                    case ')':
                    case '$':
                    case '?':
                    case '!':
                    case '%':
                    case '/':
                    case '@':
                        hasSpecial = true; break;
                    default: //if the special character is not one of the listed, it is an illegal character
                        return false;
                }
            }
        }
        return hasSpecial;
    }

    public static boolean progressingNums(String pw){
        for(int i = 0; i < pw.length()-2; i++){
            if( isDigit(pw.charAt(i)) && isDigit(pw.charAt(i+1)) && isDigit(pw.charAt(i+2)) ){
                if( (int)pw.charAt(i) == (int)pw.charAt(i+1) - 1  &&
                        (int)pw.charAt(i) == (int)pw.charAt(i+2) - 2 ) return true;
            }
        }
        return false;
    }
}
