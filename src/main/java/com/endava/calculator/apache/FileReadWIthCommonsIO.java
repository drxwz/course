package com.endava.calculator.apache;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileReadWIthCommonsIO {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/file.txt");


        String content = FileUtils.readFileToString(file, Charset.defaultCharset());
        System.out.println(content);
    }
}
