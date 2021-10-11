package main.two;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader;
        ArrayList<Site> siteArrayList = new ArrayList<>();
        try{
            reader = new BufferedReader(new InputStreamReader(
                    new DataInputStream(new FileInputStream(
                            "C:\\KFU\\ITIS2sem\\Informatics\\ExamPreparation\\JustJava\\src\\main\\two\\in.txt"))));
            String data;
            while ((data = reader.readLine()) != null){
                String[] tmp = data.split(" ");//Split space
                Site site = new Site(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]),
                        Integer.parseInt(tmp[4]), Integer.parseInt(tmp[5]), Integer.parseInt(tmp[6]), Integer.parseInt(tmp[7]));
                System.out.println(site);
                siteArrayList.add(site);
            }
            reader.close();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        try{
            DataOutputStream siteWriter = new DataOutputStream(
                    new FileOutputStream(
                            "C:\\KFU\\ITIS2sem\\Informatics\\ExamPreparation\\JustJava\\src\\main\\two\\out.txt"));
            int middleMeaning;
            for (Site site: siteArrayList){
                middleMeaning = (site.getMonday() + site.getTuesday() + site.getWednesday() + site.getThursday()
                        + site.getFriday() + site.getSaturday() + site.getSunday())/7;
                siteWriter.writeUTF(site.getName() + " " + middleMeaning + "\n");
            }
            siteWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
