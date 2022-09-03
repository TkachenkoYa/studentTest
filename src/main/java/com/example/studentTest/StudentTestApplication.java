package com.example.studentTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class StudentTestApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean(UserService.class);
        TestService testService = context.getBean(TestService.class);

        userService.inputUser();
        testService.ask();

    }

}
