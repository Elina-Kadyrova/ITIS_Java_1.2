package ru.kpfu.itis.fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class TreeCommand extends Command{
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    private StringBuilder builder;

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        try{
            String spaces = " ";
            builder = new StringBuilder(spaces);
            File[] files = file.listFiles();
            printFiles(files);
        } catch (FileNotFoundException ex) {
            System.out.println(ANSI_RED + "The system cannot find the specified path!");
        }
        return path;
    }

    private void printFiles(File[] files) throws FileNotFoundException {
        for (int i = 0; i < files.length; i++) {
            if (files[i].exists()) {
                builder.append("   "); //3 spaces
                if (files[i].isDirectory()) {
                    System.out.println(builder + ANSI_PURPLE + "<DIR> " + files[i].getName());
                    printFiles(files[i].listFiles());
                } else {
                    System.out.println(builder + ANSI_BLUE + ">> " + files[i].getName());
                }
                builder.delete(0, 3);
            }
            else{
                throw new FileNotFoundException();
            }
        }
    }
}