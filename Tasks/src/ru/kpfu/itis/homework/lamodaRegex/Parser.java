package ru.kpfu.itis.homework.lamodaRegex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser{
    public static final String PATCLASS = "(?:<div class=\"products-list-item m_loading\"([\\s\\S\\w\\W\\d\\D]+?)>Подробнее<\\/div><\\/div><\\/div><\\/div>)";
    public static final String PATREF = "href=\"([a-zA-Z0-9-\\/]+)\"";
    public static final String PATPRICE = "data-price=\"([0-9]+)\"";
    public static final String PATNAME = "alt=\\\"([а-яА-ЯЁё\\s\\d\\w\\W\\D\\S]+?)Артикул:(?:[а-яА-ЯЁё\\s\\d\\w\\W\\D\\S]+?)\"";
    public static final String schema = "https";
    public static final String host = "lamoda.ru";
    public static final String port =  "443";

    public void printItems(){
        ArrayList<ItemData> itemsList = searchItems();
        for (ItemData itemData : itemsList) {
            System.out.println(itemData);
        }
        System.out.println(itemsList.size() + " elements found");
    }

    public ArrayList<ItemData> searchItems(){
        ArrayList<ItemData> itemsList = new ArrayList<>();
        try{
            List<String> stringList =
                    Files.readAllLines(Paths.get("C:/KFU/ITIS2sem/Informatics/Tasks/lamoda.ochki.html"));
            String stringText = String.join(" ", stringList);
            Pattern patternClass = Pattern.compile(PATCLASS);
            Matcher classMatcher = patternClass.matcher(stringText);

            while (classMatcher.find()) {
                ItemData newItem = new ItemData();
                String classText = classMatcher.group(1);

                Pattern patternReference = Pattern.compile(PATREF);
                Matcher refMatcher = patternReference.matcher(classText);
                Pattern patternPrice = Pattern.compile(PATPRICE);
                Matcher priceMatcher = patternPrice.matcher(classText);
                Pattern patternName = Pattern.compile(PATNAME);
                Matcher nameMatcher = patternName.matcher(classText);

                if (refMatcher.find()){
                    newItem.setReference(refMatcher.group(1));
                    newItem.setReference(changeReference(newItem.getReference()));
                }
                if (priceMatcher.find()) {
                    newItem.setPrice(priceMatcher.group(1));
                }
                if (nameMatcher.find()){
                    newItem.setName(nameMatcher.group(1));
                }
                itemsList.add(newItem);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return itemsList;
    }

    public static String changeReference(String reference){
        String sub = schema + "://" + host + ":" + port;
        if (reference.contains(sub)) {
            return reference;
        }
        else{
            return schema + "://" + host + ":" + port + reference;
        }
    }
}
