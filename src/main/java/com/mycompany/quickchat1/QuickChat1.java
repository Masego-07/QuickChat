/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat1;
import java.util.Scanner;

/**
 
 * @author masego
 */
public class QuickChat1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login user = new Login();

        System.out.println("=== QuickChat Registration ===");

        boolean registeredSuccessfully = false;

        while (!registeredSuccessfully) {
            System.out.print("Enter first name: ");
            user.setFirstName(scanner.nextLine());

            System.out.print("Enter last name: ");
            user.setLastName(scanner.nextLine());

            System.out.print("Enter a username (must contain '_' and be at most 5 characters): ");
            user.setUsername(scanner.nextLine());

            System.out.print("Enter a password (8+ characters, capital letter, number, special character): ");
            user.setPassword(scanner.nextLine());

            System.out.print("Enter South African cell number (e.g. +27838968976): ");
            user.setCellPhoneNumber(scanner.nextLine());

            String result = user.registerUser();
            System.out.println(result);

            registeredSuccessfully = result.startsWith("Username successfully");
        }

        System.out.println("\n=== QuickChat Login ===");

        boolean loggedIn = false;
        int attempts = 0;

        while (!loggedIn && attempts < 3) {
            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            String status = user.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(status);

            loggedIn = user.loginUser(loginUsername, loginPassword);
            attempts++;
        }

        scanner.close();
    }
}

