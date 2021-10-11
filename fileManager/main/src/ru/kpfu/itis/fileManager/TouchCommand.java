package ru.kpfu.itis.fileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TouchCommand extends Command {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        try{
            String newFileName = scanner.nextLine();
            touch(path, newFileName, file);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "The system cannot find the specified path!");
        }
        return path;
    }

    private void touch(Path path, String newFileName, File file) throws IOException {
        Pattern pattern = Pattern.compile("([A-Za-zА-Яа-яЁё0-9-+_()%$#@!^&]+)$");
        Matcher matcher = pattern.matcher(newFileName);

        if (matcher.find()) {
            for (File f : file.listFiles()) {
                if (f.getName().equals(matcher.group(1))) {
                    System.out.println(ANSI_RED + "A file with the same name already exists!");
                }
            }
            Path newPath = path.resolve(newFileName).normalize().toAbsolutePath();
            if (newPath.toFile().createNewFile()){
                System.out.println(ANSI_YELLOW + "The file was successfully added.");
            }
            else{
                System.out.println(ANSI_RED + "This file cannot be added.");
            }
        }
        else{
            System.out.println(ANSI_RED + "This file cannot be added: incorrect name.");
        }
    }
}
