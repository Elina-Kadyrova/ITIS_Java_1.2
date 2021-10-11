package ru.kpfu.itis.fileManager;

public class CommandList {
    public static Command chooseOption(String command) {
        Command result;
        switch (command) {
            case "cd":
                result = new CdCommand();
                break;
            case "dir":
                result = new DirCommand();
                break;
            case "ls":
                result = new LsCommand();
                break;
            case "mkdir":
                result = new MkDirCommand();
                break;
            case "rm":
                result = new RmCommand();
                break;
            case "touch":
                result = new TouchCommand();
                break;
            case "tree":
                result = new TreeCommand();
                break;
            default:
                result = new UnknownCommand();
        }
        return result;
    }
}
