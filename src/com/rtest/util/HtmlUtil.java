package com.rtest.util;

public class HtmlUtil {
    public static String toHtmlChar(String str) {
        if (str == null) return "";
        String s = str;
        s = s.replaceAll("&lt;", "<");
        s = s.replaceAll("&gt;", ">");
        s = s.replaceAll("&amp;", "&");
        s = s.replaceAll("&quot;", "\"");
        s = s.replaceAll("&reg;", "®");
        s = s.replaceAll("&copy;", "©");
        s = s.replaceAll("&trade;", "™");
        s = s.replaceAll("&ensp;", " ");
        s = s.replaceAll("&emsp;", " ");
        //s = s.replaceAll("&nbsp;", " ");

        return s;
    }
}
