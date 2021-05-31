package com.ma.doublecolor.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;


    public class DownloadingWebpage2 {
        public static void main(String[] args) throws Exception {
            URL url = new URL("https://cp.360.cn/shdd/ssq?agent=700007");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter("save2yiibai-index.html"));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        }

}
