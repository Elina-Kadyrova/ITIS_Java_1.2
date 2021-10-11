package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class DirCommand extends Command{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        directory(file);
        return path;
    }

    private void directory(File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(ANSI_PURPLE + "<DIR> " + f.getName());
            } else {
                System.out.println(ANSI_BLUE + ">> " + f.getName());
            }
        }
    }
}