package ru.kpfu.itis.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CdCommand extends Command {
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        try {
            String newString = scanner.nextLine();
            path = changeDirectory(newString);
        } catch (FileNotFoundException ex) {
            System.out.println(ANSI_RED + "The system cannot find the specified path!");
        }
        return path;
    }

    private Path changeDirectory(String newString) throws FileNotFoundException {
        Path newPath = Paths.get(newString).normalize().toAbsolutePath();
        File newFile = newPath.toFile();

        if (newFile.exists() && newFile.isDirectory()) {
            return newPath;
        } else {
            throw new FileNotFoundException();
        }
    }
}
