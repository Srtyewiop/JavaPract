package ru.mirea.t17_18;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static PrintWriter printWriter;

    static {
        try {
            printWriter = new PrintWriter("C:\\Users\\Zyjc\\IdeaProjects\\JavaPract\\src\\ru\\mirea\\t17_18\\CodeCopy.md");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void copyCodeToFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            String[] code = file.list();
            for (String s : code) {
                copyCodeToFile(path + "/" + s);
            }
        }
        if (file.isFile()) {
            if (file.getName().substring(file.getName().lastIndexOf(".")).equals(".java")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                    printWriter.write("##### " + path + "\n```java\n");
                    String line = reader.readLine();
                    while (line != null) {
                        printWriter.write(line + "\n");
                        line = reader.readLine();
                    }
                    printWriter.write("```\n");


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static void main(String[] args) {
        Path filePath = Paths.get("").toAbsolutePath();
        copyCodeToFile(filePath.toString() + "/src");
        printWriter.close();
    }
}
