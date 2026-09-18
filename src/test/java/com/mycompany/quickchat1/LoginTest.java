/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.quickchat1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 *
 * @author masego
 */
public class LoginTest {
  private Login login;
  
    public LoginTest() {
    }
    @BeforeEach
    public void setUp() {
        login = new Login();
        login.setFirstName("Kyle");
        login.setLastName("Peters");
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        login.setCellPhoneNumber("+27838968976");
    }

    
     // checkUserName() – assertTrue / assertFalse
    
    @Test
    public void testUserName_CorrectlyFormatted_ReturnsTrue() {
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUserName_IncorrectlyFormatted_ReturnsFalse() {
        Login user = new Login();
        user.setUsername("kyle!!!!!!!");
        assertFalse(user.checkUserName());
    }

     // registerUser() – assertEquals for username condition
    
    @Test
    public void testRegister_UserNameCorrectlyFormatted() {
        assertEquals(
            "Username successfully captured. Password successfully captured. Cell phone number successfully added.",
            login.registerUser()
        );
    }

    @Test
    public void testRegister_UserNameIncorrectlyFormatted() {
        Login user = new Login();
        user.setUsername("kyle!!!!!!!");
        user.setPassword("Ch&&sec@ke99!");
        user.setCellPhoneNumber("+27838968976");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            user.registerUser()
        );
    }

     // checkPasswordComplexity() – assertTrue / assertFalse
    
    @Test
    public void testPassword_MeetsComplexity_ReturnsTrue() {
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPassword_DoesNotMeetComplexity_ReturnsFalse() {
        Login user = new Login();
        user.setUsername("kyl_1");
        user.setPassword("password");
        assertFalse(user.checkPasswordComplexity());
    }

    // registerUser() – assertEquals for password condition
    
    @Test
    public void testRegister_PasswordMeetsComplexity() {
        assertEquals(
            "Username successfully captured. Password successfully captured. Cell phone number successfully added.",
            login.registerUser()
        );
    }

    @Test
    public void testRegister_PasswordDoesNotMeetComplexity() {
        Login user = new Login();
        user.setUsername("kyl_1");
        user.setPassword("password");
        user.setCellPhoneNumber("+27838968976");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            user.registerUser()
        );
    }

      // checkCellPhoneNumber() – assertTrue / assertFalse
    
    @Test
    public void testCellPhone_CorrectlyFormatted_ReturnsTrue() {
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhone_IncorrectlyFormatted_ReturnsFalse() {
        Login user = new Login();
        user.setCellPhoneNumber("08966553");
        assertFalse(user.checkCellPhoneNumber());
    }

     // registerUser() – assertEquals for cell phone condition
    
    @Test
    public void testRegister_CellPhoneCorrectlyFormatted() {
        assertEquals(
            "Username successfully captured. Password successfully captured. Cell phone number successfully added.",
            login.registerUser()
        );
    }

    @Test
    public void testRegister_CellPhoneIncorrectlyFormatted() {
        Login user = new Login();
        user.setUsername("kyl_1");
        user.setPassword("Ch&&sec@ke99!");
        user.setCellPhoneNumber("08966553");
        assertEquals(
            "Cell phone number incorrectly formatted or does not contain international code.",
            user.registerUser()
        );
    }

     // Login – assertTrue / assertFalse
   
    @Test
    public void testLogin_Successful_ReturnsTrue() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLogin_Failed_ReturnsFalse() {
        assertFalse(login.loginUser("kyl_1", "wrongPassword1!"));
    }

    // returnLoginStatus() – assertEquals
    
    @Test
    public void testReturnLoginStatus_Successful() {
        assertEquals(
            "Welcome Kyle, Peters it is great to see you again.",
            login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!")
        );
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        assertEquals(
            "Username or password incorrect, please try again.",
            login.returnLoginStatus("kyl_1", "wrongPassword1!")
        );
    }
}

  
