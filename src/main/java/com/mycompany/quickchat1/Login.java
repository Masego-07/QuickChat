/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat1;
import java.util.regex.Pattern;
// Import the regex (Regular Expression) library.
// Regex lets us define patterns to check if text matches certain rules.
// Reference: Adapted from https://www.baeldung.com/java-regex-validate-phone-numbers

/**
 
 * 
 * @author masego
 */
public class Login {

    // declaration
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // constructor - set everything to empty strings so we don't get null errors
    public Login() {
        this.username = "";
        this.password = "";
        this.cellPhoneNumber = "";
        this.firstName = "";
        this.lastName = "";
    }

    // setters; these let other classes safely give us data.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // getters; these let other classes read our data.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

   
    // Checks if the username is correctly formatted.
    // Username must contain an underscore and be no more than 5 characters long.
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Checks if password meets complexity requirements.
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasMinLength = password.length() >= 8;
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^()_+\\-=\\[\\]{};'\"<>,./?~`|\\\\].*");
        return hasMinLength && hasUpperCase && hasNumber && hasSpecialChar;
    }

    // Checks if cell phone number has international code and correct length.
    // Reference: Adapted from https://www.baeldung.com/java-regex-validate-phone-numbers
    
    
    public boolean checkCellPhoneNumber() {
        String regex = "^\\+\\d{1,3}\\d{9}$";
        return cellPhoneNumber != null && Pattern.matches(regex, cellPhoneNumber);
    }

    
    // Registers the user. Checks username, then password, then cell number.
    // Returns the first error message it finds, or a success message if all pass.
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your "
                    + "username contains an underscore and is no more than five "
                    + "characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the "
                    + "password contains at least eight characters, a capital "
                    + "letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain "
                    + "international code.";
        }

        return "Username successfully captured. Password successfully captured. "
                + "Cell phone number successfully added.";
    }

    
    // Checks if entered login credentials match stored ones.
    // equals() compares String CONTENT.
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    // Returns welcome message if login succeeds, error message if it fails.
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

 

