/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package android.gw2.rage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fyhao
 */
public class BBCodeParser {
    public static String fromBbCode(String text) {

        String temp = text;

        Map<String , String> bbMap = new HashMap<String , String>();

        bbMap.put("\\[b\\](.+?)\\[/b\\]", "<strong>$1</strong>");

        bbMap.put("\\[i\\](.+?)\\[/i\\]", "<span style=\"font-style:italic;\">$1</span>");

        bbMap.put("\\[u\\](.+?)\\[/u\\]", "<span style=\"text-decoration:underline;\">$1</span>");

        bbMap.put("\\[h1\\](.+?)\\[/h1\\]", "<h1>$1</h1>");

        bbMap.put("\\[h2\\](.+?)\\[/h2\\]", "<h2>$1</h2>");

        bbMap.put("\\[h3\\](.+?)\\[/h3\\]", "<h3>$1</h3>");

        bbMap.put("\\[h4\\](.+?)\\[/h4\\]", "<h4>$1</h4>");

        bbMap.put("\\[h5\\](.+?)\\[/h5\\]", "<h5>$1</h5>");

        bbMap.put("\\[h6\\](.+?)\\[/h6\\]", "<h6>$1</h6>");

        bbMap.put("\\[quote\\](.+?)\\[/quote\\]", "<blockquote>$1</blockquote>");

        bbMap.put("\\[font=(.+?)\\](.+?)\\[/font\\]", "<span style=\"font-family:$1;\">$2</span>");
        bbMap.put("\\[background=(.+?)\\](.+?)\\[/background\\]", "<span style=\"background-color:$1\">$2</span>");
        
        bbMap.put("\\[center\\](.+?)\\[/center\\]", "<div align=\"center\">$1");
        bbMap.put("\\[left\\](.+?)\\[/left\\]", "<p style=\"display:block; text-align:left;\">$1</p>");

        bbMap.put("\\[align=(.+?)\\](.+?)\\[/align\\]", "<div align=\"$1\">$2");

        bbMap.put("\\[color=([\\#0-9A-Fa-f]+?)\\](.+?)\\[/color\\]", "<span style=\"color:$1;\">$2</span>");

        bbMap.put("\\[size=(.+?)\\](.+?)\\[/size\\]", "<span style=\"font-size:$1;\">$2</span>");

        bbMap.put("\\[img\\](.+?)\\[/img\\]", "<img src=\"$1\" />");

        bbMap.put("\\[img=(.+?),(.+?)\\](.+?)\\[/img\\]", "<img width=\"$1\" height=\"$2\" src=\"$3\" />");

        bbMap.put("\\[email\\](.+?)\\[/email\\]", "<a href=\"mailto:$1\">$1</a>");

        bbMap.put("\\[email=(.+?)\\](.+?)\\[/email\\]", "<a href=\"mailto:$1\">$2</a>");

        bbMap.put("\\[url\\](.+?)\\[/url\\]", "<a href=\"$1\">$1</a>");

        bbMap.put("\\[url=(.+?)\\](.+?)\\[/url\\]", "<a href=\"$1\">$2</a>");

        bbMap.put("\\[video\\](.+?)\\[/video\\]", "<video src=\"$1\" />");
        temp.replaceAll("\\]\\[", "] [");
        for (Map.Entry entry: bbMap.entrySet()) {

        temp = temp.replaceAll(entry.getKey().toString(), entry.getValue().toString());

        }

        return temp;

    }
}
