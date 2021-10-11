package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class UnknownCommand extends Command{
    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        System.out.println(ANSI_RED + "Unknown Command! Make sure there are no mistakes and try again.");
        return path;
    }
}