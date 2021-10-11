package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RmCommand extends Command {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    @Override
    public Path execute(Path path, Scanner scanner, File file) {
        if (file.exists()) {
            path = deleteCommand(scanner, file, path);
        } else{
            System.out.println(ANSI_RED + "The system cannot find the specified path!");
        }
        return path;
    }

    private Path deleteCommand(Scanner scanner, File file, Path path) {
        if(file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteCommand(scanner, f, path);
            }
            if (isDirectoryEmpty(file)){
                file.delete();
                path = Paths.get(file.getParent());
            }
        }
        else{
            System.out.println(ANSI_YELLOW + "Are you sure to delete " + file.getName() + " ? Enter Y(yes) or N(no)." );
            String answer = scanner.nextLine();
            switch(answer){
                case "Y":
                    file.delete();
                    System.out.println(ANSI_YELLOW + "File " + file.getName() + " successfully deleted.");
                    break;
                case "N":
                    System.out.println(ANSI_YELLOW + "File will not be deleted.");
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid command! Enter Y(yes) or N(no).");
            }
        }
        return path;
    }

    private boolean isDirectoryEmpty(File directory){
        String[] files = directory.list();
        return files.length == 0;
    }
}

