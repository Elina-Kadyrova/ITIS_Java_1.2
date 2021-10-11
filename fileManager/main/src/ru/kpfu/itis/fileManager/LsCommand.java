package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;

public class LsCommand extends Command {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        listCommand(file);
        return path;
    }

    private void listCommand(File file) {
        int i = 1;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                System.out.println(ANSI_PURPLE + new Date(f.lastModified()) + "  <DIR> " + f.getName());
            } else {
                System.out.println(ANSI_BLUE + new Date(f.lastModified()) + "        " + f.getName());
            }
            i++;
        }
    }
}