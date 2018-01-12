package com.twu.biblioteca;

import java.util.Scanner;

public class Login {

    private Client client;

    public boolean authenticate(Client client){
        String password;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Password: ");
        password = scanner.nextLine();

        if(password.equals(client.getPassword())){
            client.setAuthenticate(true);
            System.out.print("User login sucess");
            return true;
        } else {
            System.out.print("Login or Password error");
            return false;
        }
    }
}
