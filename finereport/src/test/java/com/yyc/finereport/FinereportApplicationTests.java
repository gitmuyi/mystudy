package com.yyc.finereport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class FinereportApplicationTests {

    @Test
    public void contextLoads() {
        //打印机列表
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        PrintService ps = null;
        for (int i = 0; i < printService.length; i++) {
            String pn = printService[i].getName();
            System.out.println(pn);
        }
        //当前默认打印机
        PrintService PS = PrintServiceLookup.lookupDefaultPrintService();
        String defaaultName = PS.getName();
        //默认打印机名称
        System.out.println("defaaultName=" + defaaultName);

    }

}
