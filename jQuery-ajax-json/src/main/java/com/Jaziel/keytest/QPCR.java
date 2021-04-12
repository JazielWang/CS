package com.Jaziel.keytest;

import java.io.*;

/**
 * @author 王杰
 * @date 2021/4/12 13:35
 */
public class QPCR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("E:\\OneDrive\\东北林业大学\\研二课题\\qPCR\\2021.4.11\\wj-qpcr-210411.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Google\\qPCR-A.txt"));
        String s = null;
        while ((s = br.readLine()) != null) {
            String s1 = splitFiles(s);
            if (s1 != null) {
                bw.write(s1);
                bw.newLine();
            }
        }
        br.close();
        bw.close();
    }

    public static String splitFiles(String s) throws IOException {
        String[] strings = s.split(" ");
        String string = strings[0].split("\t")[0];
        String s2 = String.valueOf(string.charAt(0));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < string.length(); i++) {
            sb.append(string.charAt(i));
        }
        String s1 = sb.toString();
        if ("A".equals(s2)) {
            if ("9".equals(s1) || "10".equals(s1) || "11".equals(s1) || "12".equals(s1)) {
                System.out.println(s);
                return s;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
