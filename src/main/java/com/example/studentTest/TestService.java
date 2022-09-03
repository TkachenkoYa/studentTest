package com.example.studentTest;

import lombok.Getter;

import java.util.List;
import java.util.Scanner;

@Getter
public class TestService {
    private final TestFileReader testFileReader;
    private int number;
    private int correctAnswers;

    public TestService(TestFileReader testFileReader) {
        this.testFileReader = testFileReader;
    }

    public void ask() {
        Scanner in = new Scanner(System.in);
        while (number < testFileReader.getRecords().size()) {
            System.out.println(question());
            if (checkAnswer(in.nextLine())) {
                correctAnswers++;
            }
            number++;
        }
        System.out.println("Correct answers: " + correctAnswers);
    }

    private String question() {
        List<String> record = testFileReader.getRecords().get(number);
        return record.get(0) + "\\n Answer options: " + String.join(
                ", ", record.get(1), record.get(2), record.get(3), record.get(4));
    }

    private boolean checkAnswer(String answer) {
        return testFileReader.getRecords().get(number).get(5).equals(answer);
    }
}
