package ru.kpfu.itis.homework.uri;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        String str1 = "foo://username:password@www.example.com:8080/hello/index.html?arg=val&arg2=val2#fragment";
        String str2 = "foo://username:password@www.example.com:8080/hello/index.html?arg=val";
        String str3 = "https://udgeu5b:64gbf7rh@www.example.ru:657/dhjcb/dgcn/xc#fragment";
        String str4 = "https://udgeu5b:64gbf7rh@www.example.ru:657/dhjcb/dgcn/xc";
        String str5 = "foo://hello/index.html?arg=val&arg2=val2#fragment";
        String str6 = "/hello/index.html?arg=val&arg2=val2#fragment";
        String str7 = "/hello/index.html";
        String str8 = "http://localhost/";
        String str9 = "https://fjdjn/dnffm#frag";
        String str10 = "ftp://fuhd/uhfn.ifjnv";
        String str11 = "ftp://eygdb/fjcvn";
        String str12 = "ftp://eyfnvm/rijfn?arg=val";
        String str13 = "C:/fuhjcn/dkncm";

        MyURI uri1 = new MyURI(str1);
        MyURI uri2 = new MyURI(str2);
        MyURI uri3 = new MyURI(str3);
        MyURI uri4 = new MyURI(str4);
        MyURI uri5 = new MyURI(str5);
        MyURI uri6 = new MyURI(str6);
        MyURI uri7 = new MyURI(str7);
        MyURI uri8 = new MyURI(str8);
        MyURI uri9 = new MyURI(str9);
        MyURI uri10 = new MyURI(str10);
        MyURI uri11 = new MyURI(str11);
        MyURI uri12 = new MyURI(str12);
        MyURI uri13 = new MyURI(str13);

        System.out.println(uri1.toString());
        System.out.println(uri2.toString());
        System.out.println(uri3.toString());
        System.out.println(uri4.toString());
        System.out.println(uri5.toString());
        System.out.println(uri6.toString());
        System.out.println(uri7.toString());
        System.out.println(uri8.toString());
        System.out.println(uri9.toString());
        System.out.println(uri10.toString());
        System.out.println(uri11.toString());
        System.out.println(uri12.toString());
        System.out.println(uri13.toString());
    }
}
