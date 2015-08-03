package com.rtest.util;

import java.io.UnsupportedEncodingException;

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

    public static String string2Unicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            byte[] bytes = s.getBytes("unicode");
            for (int i = 2; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);

                out.append(str1);
                out.append(str);
            }
            return out.toString().toLowerCase();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            int chr1 = (char) str.charAt(i);
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
                result+="\\u" + Integer.toHexString(chr1);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }
}
