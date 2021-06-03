package com.ma.doublecolor.service;

import com.ma.doublecolor.utils.AnayleUtils;
import com.ma.doublecolor.utils.LogUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PreviousOutCome {

    public static void main(String[] args) {

        String url = "http://kaijiang.zhcw.com/zhcw/html/ssq/list_1.html";

        String data = AnayleUtils.getDataFormInternet(url);

        LogUtils.get().info("往期："+data);
        List<String> killbolls = new ArrayList<>();
        //获取当前期杀号
        if (data.contains("前号")) {
            data = data.substring(data.indexOf("期号"));

            char ch1, ch2, ch3, ch4, ch5, ch6, ch7;
            int i = 0;
            while (data.length() > 0 && !"".equals(data) && i < data.length()) {
                ch1 = data.charAt(i);
                if (ch1 >= 48 && ch1 <= 57) {
                    ch2 = data.charAt(i + 1);
                    if (ch2 >= 48 && ch2 <= 57) {
                        ch3 = data.charAt(i + 2);
                        if (ch3 >= 48 && ch3 <= 57) {

                            ch4 = data.charAt(i + 3);
                            if (ch4 >= 48 && ch4 <= 57) {
                                ch5 = data.charAt(i + 4);
                                if (ch5 >= 48 && ch5 <= 57) {
                                    ch6 = data.charAt(i + 5);
                                    if (ch6 >= 48 && ch6 <= 57) {
                                        ch7 = data.charAt(i + 6);
                                        if (ch7 >= 48 && ch7 <= 57) {
                                            if ('>' == data.charAt(i - 1) && '<' == data.charAt(i + 7)) {

                                                String year = "" + ch1 + ch2 + ch3 + ch4;
                                                Calendar cal = Calendar.getInstance();
                                                String yearNow = String.valueOf(cal.get(Calendar.YEAR));
                                                if (yearNow.equals(year)) {
                                                    String issue = "" + ch1 + ch2 + ch3 + ch4 + ch5 + ch6 + ch7;
                                                    i += 6;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else if (ch3 == '<' && '>' == data.charAt(i - 1) && '<' == data.charAt(i + 2)) {
                                killbolls.add(String.valueOf(ch1) + ch2);
                                i++;
                            }
                        }
                    }
                }
                i++;
            }
        }
}
