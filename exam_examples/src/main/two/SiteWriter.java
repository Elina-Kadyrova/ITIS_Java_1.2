package main.two;

import java.io.FileWriter;
import java.io.IOException;

public class SiteWriter extends FileWriter {

    public SiteWriter(String fileName) throws IOException {
        super(fileName);
    }

    public void writeSite(Site site){
        try{
            write(site.getName() + " " + knowMiddleMeaning(site) + "\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Site has been written.");
    }

    public int knowMiddleMeaning(Site site){
        return (site.getMonday() + site.getTuesday() + site.getWednesday() + site.getThursday()
                + site.getFriday() + site.getSaturday() + site.getSunday())/7;
    }
}
