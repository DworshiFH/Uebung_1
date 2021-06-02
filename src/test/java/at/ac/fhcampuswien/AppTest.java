package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    String lowerCase1 = "aitilaopueldpsjtngkdeergd";
    @Test
    public void testLowerCase1(){
        assertTrue(App.hasLowerCase(lowerCase1));
    }
    String lowerCase2 = "ZTUHOIQHE"; //no lower case
    @Test
    public void testLowerCase2(){
        assertFalse(App.hasLowerCase(lowerCase2));
    }

    String upperCase1 = "ZULilaopueldpsjtngDdEErgd";
    @Test
    public void testUpperCase1(){
        assertTrue(App.hasUpperCase(upperCase1));
    }

    String upperCase2 = "aitilaopueldpsjtngkdeergd"; //no upper case
    @Test
    public void testUpperCase2(){
        assertFalse(App.hasUpperCase(upperCase2));
    }

    String num1 = "6439laopueldps89ngDdEErgd";
    @Test
    public void testNumber1(){
        assertTrue(App.hasNum(num1));
    }
    String num2 = "ZULilaopueldpsjtngDdEErgd"; //no number
    @Test
    public void testNumber2(){
        assertFalse(App.hasNum(num2));
    }

    String special1 = "tujap$@943GjeosEEIPkd7811";
    @Test
    public void testSpecial1(){
        assertTrue(App.hasSpecial(special1));
    }

    String special2 = ">943GjeosEEIPkd7811"; //invalid special
    @Test
    public void testSpecial2(){
        assertFalse(App.hasSpecial(special2));
    }

    String special3 = "ZULilaopueldpsjtngDdEErgd"; //no special
    @Test
    public void testSpecial3(){
        assertFalse(App.hasSpecial(special3));
    }

    String quadChar1 = "ai@$laoPPPPdpsj6ng9dEErgd";
    @Test
    public void testQuadChar1(){
        assertTrue(App.hasQuadChar(quadChar1));
    }

    String quadChar2 = "ai@$laoPPPdpsj6ng9dEErgd"; //no quad char
    @Test
    public void testQuadChar2(){
        assertFalse(App.hasQuadChar(quadChar2));
    }

    String progressingNum1 = "sasdf123";
    @Test
    public void testProgressingNum1(){
        assertTrue(App.progressingNums(progressingNum1));
    }

    String progressingNum2 = "sasdf124";
    @Test
    public void testProgressingNum2(){
        assertFalse(App.progressingNums(progressingNum2));
    }

    String full1 = "tujap$@943GjeosEEIPkd7811";
    @Test
    public void testFull1(){
        assertTrue(App.checkPassword(full1));
    }

    String full2 = "ai4Pi1@4";
    @Test
    public void testFull2(){
        assertTrue(App.checkPassword(full2));
    }




    /*
    //Old Tests
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
        boolean test_1 = App.checkPassword(LowerCase);
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

    @Test //with over triple characters. Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_len8Triple_14_to_15(){
        boolean test_1 = App.checkPassword(test14);
        boolean test_2 = App.checkPassword(test15);

        assertFalse(test_1);
        assertFalse(test_2);
    }

    @Test //with over triple characters. Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_len25Triple_16_to_17(){
        boolean test_1 = App.checkPassword(test16);
        boolean test_2 = App.checkPassword(test17);

        assertFalse(test_1);
        assertFalse(test_2);
    }

    @Test //length under 8. Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_lenUnder8_18(){
        boolean test = App.checkPassword(test18);
        assertFalse(test);
    }
    @Test //length over 25. Test for INVALID Passwords => Assertions must be FALSE
    public void testPW_lenOver25_19(){
        boolean test = App.checkPassword(test19);
        assertFalse(test);
    }*/
}