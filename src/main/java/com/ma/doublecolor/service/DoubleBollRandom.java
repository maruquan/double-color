package com.ma.doublecolor.service;

import com.ma.doublecolor.entity.DollsColor;

import java.util.*;

public class DoubleBollRandom {


    /**双色球前区
     * 获取除listKillBools以后的number随机数
     * @param listKillBolls 除外
     * @return
     */
    public static List<String> getDoubleColor(List<String> listKillBolls,int number,int coler) {
        List<String> list = new ArrayList<>(6);
        int randnum = 16;
        if(coler == DollsColor.RedColer){
            randnum = 33;
        }
        Random a = new Random();
        for (int i = 0; i < number; i++) {
            while (true) {
                int r = (int) (Math.random() * randnum)+1;
                String r_string = String.valueOf(r);
                if (r <= 9) {
                    r_string = "0" + r;
                }
                if (!listKillBolls.contains(r_string) && !list.contains(r_string)) {
                    list.add(r_string);
                    break;
                }
            }
        }
        Collections.sort(list);
        return list;
    }
}
