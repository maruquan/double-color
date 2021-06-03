package com.ma.doublecolor.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DataToDoUtils {

    /**
     * 去重
     * @param list
     * @return
     */
    public static List<String> getHashSet(List<String> list){
        HashSet<String> set = new HashSet<>(list.size());
        List<String> result = new ArrayList<>(list.size());
        for (String str : list) {
            if (set.add(str)) {
                result.add(str);
            }
        }
        result = new ArrayList<>(set.size());
        for (String s :set) {
            result.add(s);
        }
        Collections.sort(result);
        return result;
    }


}
