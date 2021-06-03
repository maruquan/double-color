package com.ma.doublecolor.service;

import com.ma.doublecolor.entity.DollsColor;
import com.ma.doublecolor.entity.UrlListEntity;
import com.ma.doublecolor.utils.AnayleUtils;
import com.ma.doublecolor.utils.DataToDoUtils;
import com.ma.doublecolor.utils.LogUtils;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class RedBoll {

    public void getRedKillBolls() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        UrlListEntity urlListEntity = new UrlListEntity();
        ArrayList<String> allUrls = new ArrayList<>();
        allUrls.add("https://cp.360.cn/shdd/sha/?LotID=220051&agent=700007");
        allUrls.add("https://expert.78500.cn/ssq/hqsm/");
        allUrls.add("https://zst.cjcp.com.cn/shdd/ssq-hq.html");
        urlListEntity.setUrlLists(allUrls);

        AnayleUtils staticMainTest = new AnayleUtils();
        List<String> allKillBolls = new ArrayList<>();


        for (int i = 0; i < urlListEntity.getUrlLists().size(); i++) {
            //获取当前期杀号
            List<String> result = staticMainTest.getForAdayOrTwoDataKillBoss(urlListEntity.getUrlLists().get(i));
            //获取当前期随机号
            List<String> redRandomNumber_6 = DoubleBollRandom.getDoubleColor(result,6, DollsColor.RedColer);
            LogUtils.get().info("当前期随机数:" + redRandomNumber_6.toString());
            //加入总杀号列表
            allKillBolls.addAll(result);
        }
        allKillBolls = DataToDoUtils.getHashSet(allKillBolls);
        LogUtils.get().info("全部杀号：" + allKillBolls.toString());

        for (int i = 0; i < 5; i++) {
            List<String> redRandomNumber_6 = DoubleBollRandom.getDoubleColor(allKillBolls,6,DollsColor.RedColer);
            LogUtils.get().info("前期随机数:" + redRandomNumber_6.toString());
        }
    }
}
