package at.ac.fhcampuswien;

import static java.lang.Character.*;

public class App {

    private static final int min_len = 8;
    private static final int max_len = 25;

    public static boolean checkPassword(String pw){
        boolean hasLowerCase=false;
        boolean hasUpperCase=false;
        boolean hasNum=false;
        boolean hasSpecial=false;

        //Test for length
        if(pw.length()<min_len) {
            return false;
        }
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
                    default:
                        System.out.println("Illegal special character."); return false;
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
        return hasLowerCase && hasUpperCase && hasNum && hasSpecial; //pw is valid
    }
}
