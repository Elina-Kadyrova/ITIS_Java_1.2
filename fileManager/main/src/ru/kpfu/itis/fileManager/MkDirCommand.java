package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MkDirCommand extends Command{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        String newDirectoryName = scanner.nextLine();
        makeDirectory(path, newDirectoryName, file);
        return path;
    }

    private void makeDirectory(Path path, String newDirectoryName, File file){
        Pattern pattern = Pattern.compile("([A-Za-zА-Яа-яЁё0-9-+_()%$#@!^&]+)$");
        Matcher matcher = pattern.matcher(newDirectoryName);

        if (matcher.find()) {
            for (File f : file.listFiles()) {
                if (f.getName().equals(matcher.group(1))) {
                    System.out.println(ANSI_RED + "A directory with the same name already exists!");
                }
            }
            Path newPath = path.resolve(newDirectoryName).normalize().toAbsolutePath();
            if (newPath.toFile().mkdir()){
                System.out.println(ANSI_YELLOW + "The directory was successfully added.");
            }
            else{
                System.out.println(ANSI_RED + "This directory cannot be added.");
            }
        }
        else{
            System.out.println(ANSI_RED + "This directory cannot be added: incorrect name.");
        }
    }
}
