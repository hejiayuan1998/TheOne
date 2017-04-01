package com.smashing.theone.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: chensen
 * date: 2017年03月30日10:32
 * desc:将字符串转换成网页内容
 */

public class Htmlutils {
    public static String format(String str) {
        //用正则将img的style置为空
        Pattern pattern = Pattern.compile("style=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(str);
        str = matcher.replaceAll("");

        return "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                "<title>Sign in | Score System</title>" +
                "<style type=\"text/css\">\n" +
                "img{margin-top:15px;margin-bottom:15px;}" +
                "body{display:flex;flex-direction:column;justify-content:center;line-height:2;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                str +
                "</body>" +
                "</html>";
    }
}
