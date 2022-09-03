package com.example.studentTest;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class UserService {
    private User user;

    public void inputUser() {
        Scanner in = new Scanner(System.in);
        boolean isNotEmpty = false;
        while (!isNotEmpty) {
            System.out.println("Please, enter your name ");
            user.setName(in.nextLine());
            System.out.println("Please, enter your last name ");
            user.setLastName(in.nextLine());
            if (!user.getName().isEmpty() && !user.getLastName().isEmpty())
                isNotEmpty = true;
            else System.out.println("Your data is empty");
        }
    }
}
