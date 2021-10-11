package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        File file = new File("C:\\KFU\\ITIS2sem\\Informatics\\для файлового менеджера");
        Path path = Paths.get("C:\\KFU\\ITIS2sem\\Informatics\\для файлового менеджера").normalize().toAbsolutePath();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_YELLOW + path.toString() + ">>");
        String inputCommand = scanner.nextLine().toLowerCase();

        while (!inputCommand.equals("exit")) {
            Command command = CommandList.chooseOption(inputCommand);
            path = command.execute(path, scanner, file).normalize().toAbsolutePath();
            file = path.toFile();
            System.out.println(ANSI_YELLOW + path.toString() + ">>");
            inputCommand = scanner.nextLine().toLowerCase();
        }
        System.exit(0);
    }
}