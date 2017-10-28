package com.expedia.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author shareef on 27/10/2017
 */
public class FileUtil {

    public static String getFileContent(String path) {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("File " + path + " not found");
        }
        return null;
    }

}
