package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    //Test Data for 8 character long passwords IGNORES TRIPLE characters
    String test1 = ""; //empty case
    String test2 = "aitilapp"; //8 characters long, no special, no numbers, no capitals
    String test3 = "aitilaoP"; //8 characters long, no special, no numbers, with capitals
    String test4 = "ait8l9op"; //8 characters long, no special, with numbers, no capitals
    String test5 = "ai4pi1@4"; //8 characters long, with special, with number, no capitals
    String test6 = "ai4Pi1€4"; //8 characters long, now with forbidden special, with capital
    String test7 = "ai4Pi1@4"; //8 characters long, with special, with numbers, with capitals IS VALID

    //Test for 25 character long passwords IGNORES TRIPLE characters
    String test8 = "aitilaopueldpsjtngkdeergd"; //25 characters long, no special, no numbers, no capitals
    String test9 = "aitilaopueldpsjtngDdEErgd"; //25 characters long, no special, no numbers, with capitals
    String test10 = "aitilaopueldps89ngDdEErgd"; //25 characters long, no special, with numbers, no capitals
    String test11 = "aiti$aopueldps89ngddeer@d"; //25 characters long, with special, with number, no capitals
    String test12 = "aiti$aopueldps89ngDdEEr€d"; //25 characters long, now with forbidden special, with capital
    String test13 = "tujap$@943GjeosEEIPkd7811"; //25 characters long, with special, with numbers, with capitals IS VALID

    //Test Data for 8 character long passwords with more than TRIPLE CHARACTERS
    String test14 = "Piiii1€4"; //triple letter is not capital
    String test15 = "pIIII1€4@4"; //triple letter with capital

    //Test Data for 25 character long passwords with more than TRIPLE CHARACTERS
    String test16 = "AItila@ppppdpsjtngkdee45d"; //quad character is not capital
    String test17 = "ai@$laoPPPPdpsj6ng9dEErgd"; //quad character is capital

    //Test Data for length
    String test18 = "a4Pi1@4"; //only 7 characters long, otherwise valid
    String test19 = "tujap$@943GjeosEEIPkd7811e"; //over 25 characters long, otherwise valid


    @Test //Tests for INVALID Passwords => Assertions must be FALSE
    public void testPW_len8_1_to_6() {
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
    public void testPW_len8_7() {
        boolean test = App.checkPassword(test7);
        assertTrue(test);
    }

    @Test //Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_len25_8_to_12() {
        boolean test_1 = App.checkPassword(test8);
        boolean test_2 = App.checkPassword(test9);
        boolean test_3 = App.checkPassword(test10);
        boolean test_4 = App.checkPassword(test11);
        boolean test_5 = App.checkPassword(test12);

        assertFalse(test_1);
        assertFalse(test_2);
        assertFalse(test_3);
        assertFalse(test_4);
        assertFalse(test_5);
    }

    @Test //Test for VALID Password => Assertion must be TRUE
    public void testPW_len25_13() {
        boolean test = App.checkPassword(test13);
        assertTrue(test);
    }

    @Test //with over triple characters => Assertion must be FALSE
    public void testPW_len8Triple_14_to_15(){
        boolean test_1 = App.checkPassword(test14);
        boolean test_2 = App.checkPassword(test15);

        assertFalse(test_1);
        assertFalse(test_2);
    }

    @Test //with over triple characters
    public void testPW_len25Triple_16_to_17(){
        boolean test_1 = App.checkPassword(test16);
        boolean test_2 = App.checkPassword(test17);

        assertFalse(test_1);
        assertFalse(test_2);
    }

    @Test
    public void testPW_lenUnder8_18(){
        boolean test = App.checkPassword(test18);
        assertFalse(test);
    }
    @Test
    public void testPW_lenOver25_19(){
        boolean test = App.checkPassword(test19);
        assertFalse(test);
    }
}