/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package login;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 *
 * PROG5121 POE - Part 1
 * JUnit test class for Login.java
 * This file tests all the methods in the Login class.
 */
public class LoginTest {

    /**
     * Test that a valid username passes (contains underscore and <= 5 chars).
     */
    @Test
    public void testCheckUserName_Valid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkUserName());
    }

    /**
     * Test that an invalid username fails (no underscore / too long).
     */
    @Test
    public void testCheckUserName_Invalid() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName());
    }

    /**
     * Test that a strong password passes complexity check.
     */
    @Test
    public void testCheckPasswordComplexity_Valid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity());
    }

    /**
     * Test that a weak password fails complexity check.
     */
    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    /**
     * Test that a correctly formatted SA number passes (+27 plus 9 digits).
     */
    @Test
    public void testCheckCellPhoneNumber_Valid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber());
    }

    /**
     * Test that an incorrectly formatted phone number fails.
     */
    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber());
    }

    /**
     * Test that login passes when the correct username and password are entered.
     */
    @Test
    public void testLoginUser_Success() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    /**
     * Test that login fails when incorrect username and password are entered.
     */
    @Test
    public void testLoginUser_Failure() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("wrong", "wrong"));
    }

    /**
     * Test that the correct welcome message is displayed on successful login.
     */
    @Test
    public void testReturnLoginStatus_Success() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Welcome Kyle Smith it is great to see you again.", login.returnLoginStatus(true));
    }

    /**
     * Test that the correct error message is displayed on failed login.
     */
    @Test
    public void testReturnLoginStatus_Failure() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
    
    public LoginTest() {
    }

    /**
     * Test of main method, of class MainApp.
     */
    @Test
    public void testMain() {
    }
    
}
