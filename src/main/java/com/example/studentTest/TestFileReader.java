package com.example.studentTest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class TestFileReader {
    private ClassPathResource resource;
    private List<List<String>> records;
    public void readFile() {
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> tests = new ArrayList<>();
                String[] units = line.split(",");
                Arrays.stream(units).forEach(s -> tests.add(s.trim()));
                records.add(tests);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
