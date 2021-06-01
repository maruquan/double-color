package com.ma.doublecolor.service;

import com.ma.doublecolor.config.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Service
public class StaticMainTest {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) throws InterruptedException {
//       System.out.println( HttpUtils.doGet("https://zst.cjcp.com.cn/shdd/ssq-lq-100.html"));
//       System.out.println( HttpUtils.doGet("https://cp.360.cn/shdd/sha/?LotID=220051&agent=700007"));
       String url = "https://cp.360.cn/shdd/sha/?LotID=220051&agent=700007";

//       Thread.sleep(5000);
//        System.out.println(""+HttpUtils.getDataBody());
        //获取数据int[][]

/*   */
//        RestTemplate restTemplate = HttpClientUtils.getInstance(Proxy.NO_PROXY,true);
//        restTemplate.getForEntity(url,String.class);
    }

    public void startRestTemplate() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String url = "https://cp.360.cn/shdd/sha/?LotID=220051&agent=700007";



//        System.out.println("结果"+ restTemplate.getForEntity(url,String.class));

        HttpHeaders headers = new HttpHeaders();
// headers.set("token", tokenStr);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        RestTemplate restTemplateHttps = new RestTemplate(RestTemplateConfig.generateHttpRequestFactory());
        ResponseEntity<String> stringResponseEntity = restTemplateHttps.exchange(url, HttpMethod.GET, entity, String.class);
// 响应状态
        String body = stringResponseEntity.getBody();
        System.out.println("body:"+body);
    }
}
