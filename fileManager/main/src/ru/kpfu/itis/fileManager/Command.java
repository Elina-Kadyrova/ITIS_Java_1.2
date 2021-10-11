package ru.kpfu.itis.fileManager;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public abstract class Command {
    public abstract Path execute(Path path, Scanner scanner, File file);
}