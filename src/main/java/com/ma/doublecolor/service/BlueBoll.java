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

public class BlueBoll {

    public void getBlueKillBolls() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

        UrlListEntity urlListEntity = new UrlListEntity();
        ArrayList<String> allUrls = new ArrayList<>();
        allUrls.add("https://cp.360.cn/shdd/shax?LotID=220051&ItemID=20344&TopCount=20&r=0.1956563780097631");
        allUrls.add("https://expert.78500.cn/ssq/lqsm/");
        allUrls.add("https://zst.cjcp.com.cn/shdd/ssq-lq.html");
        urlListEntity.setUrlLists(allUrls);

        AnayleUtils staticMainTest = new AnayleUtils();
        List<String> allKillBolls = new ArrayList<>();
        //获取当前期杀号
        for (int i = 0; i < urlListEntity.getUrlLists().size(); i++) {
            List<String> result = staticMainTest.getForAdayOrTwoDataKillBoss(urlListEntity.getUrlLists().get(i));
            //获取当前期随机号
            List<String> blueRandomNumber_1 = DoubleBollRandom.getDoubleColor(result,1,DollsColor.BlueColer);
            LogUtils.get().info("当前期随机数:" + blueRandomNumber_1.toString());
            allKillBolls.addAll(result);
        }


        allKillBolls = DataToDoUtils.getHashSet(allKillBolls);
        LogUtils.get().info("所有全部杀号后：" + allKillBolls.toString());
        for (int i = 0; i < 5; i++) {
            List<String> blueRandomNumber_6 = DoubleBollRandom.getDoubleColor(allKillBolls,1, DollsColor.BlueColer);
            LogUtils.get().info("前期随机数:" + blueRandomNumber_6.toString());
        }
    }
}
