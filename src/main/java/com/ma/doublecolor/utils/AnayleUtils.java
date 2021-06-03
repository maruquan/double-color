package com.ma.doublecolor.utils;

import com.ma.doublecolor.config.RestTemplateConfig;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AnayleUtils {

    /**
     * 总功能
     * @param url
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public static List<String> getForAdayOrTwoDataKillBoss(String url) {
        AnayleUtils staticMainTest = new AnayleUtils();
        String dataBody = null;
        dataBody = staticMainTest.getDataFormInternet(url);
        //获取当前期杀球
        List<String> list = staticMainTest.analyseForAdayOrTwoData(dataBody);
        List<String> result = DataToDoUtils.getHashSet(list);
        Collections.sort(result);
        LogUtils.get().info("当前期杀球:" + result.toString());
        return result;
    }



    /**
     * 获取网页信息
     * @param url
     */
    public static String getDataFormInternet(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add(HttpHeaders.USER_AGENT, "your agent");
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        RestTemplate restTemplateHttps = null;
        try {
            restTemplateHttps = new RestTemplate(RestTemplateConfig.generateHttpRequestFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        ResponseEntity<String> stringResponseEntity = restTemplateHttps.exchange(url, HttpMethod.GET, entity, String.class);
    // 响应状态
        String body = stringResponseEntity.getBody();
//        LogUtils.get().info("datainfo:"+body);
        return body;
    }

    /**
     * //获取分析网面信息获取当前期杀号
     */
    public List<String> analyseForAdayOrTwoData(String data) {
        List<String> killbolls = new ArrayList<>();
        //获取当前期杀号
        if (data.contains("当前期杀号")) {
            data = data.substring(data.indexOf("当前期杀号") + 5);
            data = data.substring(0, data.indexOf("目前连错次数"));
            char ch1;
            char ch2;
            int i = 0;
            while (data.length() > 0 && !"".equals(data) && i < data.length()) {
                ch1 = data.charAt(i);
                if (ch1 >= 48 && ch1 <= 57) {
                    ch2 = data.charAt(i + 1);
                    if (ch2 >= '0' && ch2 <= 57) {
                        if ('>' == data.charAt(i - 1) && '<' == data.charAt(i + 2)) {
                            killbolls.add(String.valueOf(ch1) + ch2);
                            i++;
                        }
                        if(killbolls.size() >= 10){
                            break;
                        }
                    }
                }
                i++;
            }
        } else {
            LogUtils.get().info("无杀号信息");
        }
        return killbolls;
    }
}
