package com.ma.doublecolor.utils;

import java.util.Random;
import java.util.UUID;

/**
 * StringUtil
 *
 * @author gaohuaiyu
 * @date 2020/06/03 11:32
 */
public class StringUtil {

    /**
     * 生成不重复随机字符串包括字母数字
     * (注册时用到)
     *
     * @param len
     * @return
     */
    public static String generateRandomStr(int len) {
        //字符源，可以根据需要删减
        String generateSource = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String rtnStr = "";
        for (int i = 0; i < len; i++) {
            //循环随机获得当次字符，并移走选出的字符
            String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
            rtnStr += nowStr;
            generateSource = generateSource.replaceAll(nowStr, "");
        }
        return rtnStr;
    }

    /**
     * 生成随机密码
     *
     * @param len
     * @return
     */
    public static String generatePassword(int len) {
        // 1、定义基本字符串baseStr和出参password
        String password = null;
        String baseStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ~!@#$%^&*()_+{}|<>?";
        boolean flag = false;
        // 2、使用循环来判断是否是正确的密码
        while (!flag) {
            // 密码重置
            password = "";
            // 个数计数
            int a = 0, b = 0, c = 0, d = 0;
            for (int i = 0; i < len; i++) {
                int rand = (int) (Math.random() * baseStr.length());
                password += baseStr.charAt(rand);
                if (0 <= rand && rand < 10) {
                    a++;
                }
                if (10 <= rand && rand < 36) {
                    b++;
                }
                if (36 <= rand && rand < 62) {
                    c++;
                }
                if (62 <= rand && rand < baseStr.length()) {
                    d++;
                }

            }
            // 是否是正确的密码（4类中仅一类为0，其他不为0）
            flag = a * b * c * d != 0;
        }
        return password;
    }

    /**
     * 生成requestId
     * op资源请求时使用
     *
     * @return
     */
    @SuppressWarnings("PMD")
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 获取随机String
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机纯数字String
     *
     * @param length
     * @return
     */
    public static String getRandomDigitalString(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否不为空（null 或 “”）
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为空（null 或 “”）
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 特殊字符转义
     *
     * @param str
     * @return
     */
    public static String setEscapeSpecialChar(String str) {
        if (!StringUtil.isEmpty(str)) {
            String[] fbsArr = {"%", "_"};
            for (String name : fbsArr) {
                if (str.contains(name)) {
                    str = str.replace(name, "\\" + name);
                }
            }
        }
        return str;
    }
}
