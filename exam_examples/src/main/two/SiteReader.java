package main.two;

import java.io.*;
import java.util.ArrayList;

public class SiteReader extends FileReader {

    public SiteReader(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public Site readSite(ArrayList<String> data){
        String name = null;
        int monday = 0;
        int tuesday = 0;
        int wednesday = 0;
        int thursday = 0;
        int friday = 0;
        int saturday = 0;
        int sunday = 0;
        Site site = new Site(name, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
        return site;
    }
}
