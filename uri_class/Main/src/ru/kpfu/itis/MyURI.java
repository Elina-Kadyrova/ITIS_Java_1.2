package ru.kpfu.itis;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyURI {
    private String scheme;
    private String user;
    private String pass;
    private String host;
    private int port;
    private String path;
    private String query;
    private String fragment;

    public static final String PATSAP = "([a-zA-Z0-9+-.]+):\\/\\/([a-zA-Z0-9-_]+):([a-zA-Z0-9_]+)@((?:[a-zA-Z0-9_]+\\.*)*):([0-9]+)\\/((?:\\/*[a-zA-Z-_.~]+(?:%[0-9A_F])*)+)(?:\\?((?:[a-z0-9-_.~:@!$'+*,;\\/]+=[a-z0-9-_.~:@!$'+*,;\\/]+[&]*)*))*(?:#((?:[a-zA-Z0-9-_.~:@!$&'+*,;=]+(?:%[0-9A-F])*)*))*";
    public static final String PATSP = "([a-zA-Z]+):\\/\\/(?:([a-zA-Z.$&'=+:\\/-]+(?:%[0-9A-F])*\\/*))(?:\\?((?:[a-z0-9-_.~:@!$'+*,;\\/]+=[a-z0-9-_.~:@!$'+*,;\\/]+[&]*)*))*(?:#((?:[a-zA-Z0-9-_.~:@!$&'+*,;=]+(?:%[0-9A-F])*)*))*";
    public static final String PATP = "([a-zA-Z:]*(?:\\/[a-zA-Z.$&'=+:-]+)+(?:%[0-9A-F])*\\/*)(?:\\?((?:[a-z0-9-_.~:@!$'+*,;\\/]+=[a-z0-9-_.~:@!$'+*,;\\/]+[&]*)*))*(?:#((?:[a-zA-Z0-9-_.~:@!$&'+*,;=]+(?:%[0-9A-F])*)*))*";


    public MyURI(String str) throws URISyntaxException {
        if (str == null) {
            throw new NullPointerException("String is null");
        }
        Pattern patternSAP = Pattern.compile(PATSAP);
        Pattern patternSP = Pattern.compile(PATSP);
        Pattern patternP = Pattern.compile(PATP);
        Matcher matcherSAP = patternSAP.matcher(str);
        Matcher matcherSP = patternSP.matcher(str);
        Matcher matcherP = patternP.matcher(str);
        if (matcherSAP.find()) {
            this.scheme = matcherSAP.group(1);
            this.user = matcherSAP.group(2);
            this.pass = matcherSAP.group(3);
            this.host = matcherSAP.group(4);
            this.port = Integer.parseInt(matcherSAP.group(5));
            this.path = matcherSAP.group(6);
            this.query = matcherSAP.group(7);
            this.fragment = matcherSAP.group(8);
        }
        else if (matcherSP.find()) {
            this.scheme = matcherSP.group(1);
            this.path = matcherSP.group(2);
            this.query = matcherSP.group(3);
            this.fragment = matcherSP.group(4);
        } else if (matcherP.find()) {
            this.path = matcherP.group(1);
            this.query = matcherP.group(2);
            this.fragment = matcherP.group(3);
        } else {
            throw new URISyntaxException(str, "Not an URI");
        }
    }

    public String getScheme() {
        return scheme;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public String getFragment() {
        return fragment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyURI uri = (MyURI) o;
        return Objects.equals(scheme, uri.scheme) &&
                Objects.equals(user, uri.user) &&
                Objects.equals(pass, uri.pass) &&
                Objects.equals(host, uri.host) &&
                Objects.equals(port, uri.port) &&
                Objects.equals(path, uri.path) &&
                Objects.equals(query, uri.query) &&
                Objects.equals(fragment, uri.fragment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheme, user, pass, host, port, path, query, fragment);
    }

    @Override
    public String toString() {
        return "URI: " + '\n' +
                "Scheme = " + scheme + '\n' +
                "User = " + user + '\n' +
                "Pass = " + pass + '\n' +
                "Host = " + host + '\n' +
                "Port = " + port + '\n' +
                "Path = " + path + '\n' +
                "Query = " + query + '\n' +
                "Fragment = " + fragment + '\n';
    }
}
