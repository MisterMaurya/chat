package org.anonymous.buddychatter.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * @author Pawan Maurya
 * @since July 10, 2020
 */
public class Genes {
    public static void main(String[] args) {

        System.out.println("------------------------\nFirst way\n\n");

        String x = "atgbbbbtaaxatgyytaa9090atgzzztaaaxcvvcatg00taa00zzatg5656taallllatgxxpawtaachaiatgchaitaa";
        Matcher m = Pattern.compile("(?<=atg).*?(?=taa)").matcher(x);
        while (m.find()) System.out.println("atg" + m.group() + "taa");

        System.out.println("------------------------\n\nsecond way\n");
        find(x);
    }

    private static void find(String x) {
        int start = x.indexOf("atg");
        if (start != -1) {
            String substring = x.substring(start);
            if (substring.contains("taa")) {
                int end = substring.indexOf("taa") + 3;
                System.out.println(substring.substring(0, end));
                find(substring.substring(end));
            }
        }
    }


}
