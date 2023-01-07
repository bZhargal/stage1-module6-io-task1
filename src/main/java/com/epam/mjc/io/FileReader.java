package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {
    public static Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int c;
            while ((c = fileInputStream.read()) != -1) {
                stringBuilder.append(Character.toString(c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] values = stringBuilder.toString().split("\n");

        profile.setName(values[0].split(":")[1].trim());
        profile.setAge(Integer.valueOf(values[1].split(":")[1].trim()));
        profile.setEmail(values[2].split(":")[1].trim());
        profile.setPhone(Long.valueOf(values[3].split(":")[1].trim()));
        return profile;
    }
}
