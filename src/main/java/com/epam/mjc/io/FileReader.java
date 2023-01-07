package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {
    public Profile getDataFromFile(File file) {
        String[] parseString = parseFile(file);

        return mapping(parseString);
    }

    private String[] parseFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int c;
            while ((c = fileInputStream.read()) != -1) {
                stringBuilder.append(Character.toString(c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().split("\n");
    }

    private Profile mapping(String[] values) {
        Profile profile = new Profile();

        profile.setName(values[0].split(":")[1].trim());
        profile.setAge(Integer.valueOf(values[1].split(":")[1].trim()));
        profile.setEmail(values[2].split(":")[1].trim());
        profile.setPhone(Long.valueOf(values[3].split(":")[1].trim()));
        return profile;
    }
}