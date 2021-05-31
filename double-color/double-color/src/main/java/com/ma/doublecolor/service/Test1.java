package com.ma.doublecolor.service;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class Test1 {


    public static void main(String[] args) {
// TODO Auto-generated method stub

        try {
            URL url = new URL("https://cp.360.cn/shdd/ssq?agent=700007");

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String s = null;

            StringBuffer sb = new StringBuffer();

            while ((s = br.readLine()) != null)

            {
                sb.append(s + "/r/n");

            }

            System.out.println(sb.toString());

            br.close();

        } catch (Exception e) {
// TODO Auto-generated catch block

            e.printStackTrace();

        }

    }

    private static RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

        TrustSelfSignedStrategy acceptingTrustStrategy = new TrustSelfSignedStrategy();
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

}
