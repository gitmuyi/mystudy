package com.yyc.common;

import com.yyc.common.utils.ConvertData;
import com.yyc.common.utils.DateUtil;

import javax.xml.transform.Source;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/26: 14:14
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) {
        int dateElement = DateUtil.getDateElement(new Date(), 14);
        Date dateAddMilliSecond = DateUtil.getDateAddDay(new Date(), 1);
        System.out.println(dateAddMilliSecond);
        System.out.println(dateElement);

        int a = 128;
        double ceil = Math.ceil(a);
        System.out.println(Math.round(
                Math.ceil(ConvertData.toDouble(95) / 32) * 32));

        String jj = String.format("零部件【%s】的发运数量已经超过计划数量。", "哈哈哈");
        System.out.println(jj);
        getDate(new Date());

    }


    public static Date getDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date retDate = new Date();
        try {
            retDate = sdf.parse(sdf.format(date));
            System.out.println(retDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retDate;
    }




}
