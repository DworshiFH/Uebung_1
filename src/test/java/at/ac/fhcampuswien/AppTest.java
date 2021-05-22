package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //Test for 8 letters long passwords IGNORES TRIPLE LETTERS
    String test1 = ""; //empty case
    String test2 = "aitilaop"; //8 letters long, no special, no numbers, no capitals
    String test3 = "aitilaoP"; //8 letters long, no special, no numbers, with capitals
    String test4 = "ait8l9op"; //8 letters long, no special, with numbers, no capitals
    String test5 = "ai4pi1@4"; //8 letters long, with special, with number, no capitals
    String test6 = "ai4Pi1€4"; //8 letters long, now with forbidden special, with capital
    String test7 = "ai4Pi1@4"; //8 letters long, with special, with numbers, with capitals IS VALID

    //Test for 25 letters long passwords IGNORES TRIPLE LETTERS
    String test8 = "aitilaopueldpsjtngkdeergd"; //25 letters long, no special, no numbers, no capitals
    String test9 = "aitilaopueldpsjtngDdEErgd"; //8 letters long, no special, no numbers, with capitals
    String test10 = "aitilaopueldps89ngDdEErgd"; //25 letters long, no special, with numbers, no capitals
    String test11 = "aiti$aopueldps89ngDdEEr@d"; //8 letters long, with special, with number, no capitals
    String test12 = "aiti$aopueldps89ngDdEEr€d"; //8 letters long, now with forbidden special, with capital
    String test13 = "tujap$@943GjeosEEIPkd7811"; //25 letters long, with special, with numbers, with capitals IS VALID

    //Test for 8 letters long passwords WITH TRIPLE LETTERS
    String test14 = "Piiii1€4"; //triple letter is not capital
    String test15 = "pIIII1€4@4"; //triple letter with capital

    //Test for 25 letters long passwords WITH TRIPLE LETTERS
    String test16 = "AItila@ppppdpsjtngkdee45d"; //triple letter is not capital
    String test17 = "ai@$laoPPPPdpsj6ng9dEErgd"; //triple letter is capital


    @Test //Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_len_8_1() {
        App exercise1 = new App();

        boolean test_1 = App.checkPassword(test1);
        boolean test_2 = App.checkPassword(test2);
        boolean test_3 = App.checkPassword(test3);
        boolean test_4 = App.checkPassword(test4);
        boolean test_5 = App.checkPassword(test5);
        boolean test_6 = App.checkPassword(test6);

        assertFalse(test_1);
        assertFalse(test_2);
        assertFalse(test_3);
        assertFalse(test_4);
        assertFalse(test_5);
        assertFalse(test_6);
    }

    @Test //Tests for VALID Password => Assertion must be TRUE
    public void testPW_len_8_7() {
        App exercise1 = new App();
        boolean test = App.checkPassword(test7);
        assertTrue(test);
    }

    @Test //Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_len_25_8() {
        App exercise1 = new App();
        boolean test_1 = App.checkPassword(test8);
        boolean test_2 = App.checkPassword(test9);
        boolean test_3 = App.checkPassword(test10);
        boolean test_4 = App.checkPassword(test11);
        boolean test_5 = App.checkPassword(test12);
        boolean test_6 = App.checkPassword(test13);

        assertFalse(test_1);
        assertFalse(test_2);
        assertFalse(test_3);
        assertFalse(test_4);
        assertFalse(test_5);
        assertFalse(test_6);
    }

    @Test //Test for VALID Password => Assertion must be TRUE
    public void testPW_len_25_13() {
        App exercise1 = new App();
        boolean test = App.checkPassword(test13);
        assertTrue(test);
    }

    @Test
    public void testPW_len_8_w3L(){ //with triple letters
        App exercise1 = new App();

        boolean test_1 = App.checkPassword(test14);
        boolean test_2 = App.checkPassword(test15);

        assertFalse(test_1);
        assertFalse(test_2);
    }

    @Test
    public void testPW_len_25_w3L(){ //with triple letters
        App exercise1 = new App();

        boolean test_1 = App.checkPassword(test16);
        boolean test_2 = App.checkPassword(test17);

        assertFalse(test_1);
        assertFalse(test_2);
    }
}
