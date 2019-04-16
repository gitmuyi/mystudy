package com.yyc.finereport;
import com.fr.base.FRContext;
import com.fr.base.Parameter;
import com.fr.dav.LocalEnv;
import com.fr.io.TemplateWorkBookIO;
import com.fr.main.TemplateWorkBook;
import com.fr.print.PrintUtils;

import java.util.HashMap;

/**
 * @Auther: yangyongcui
 * @Date: 2019/4/15: 21:07
 * @Description:
 */
public class FunRuanPrint {

    public static void main(String[] args) {
        String envPath = "E:\\FineReport_9.0\\WebReport\\WEB-INF";
        FRContext.setCurrentEnv(new LocalEnv(envPath));
        try {
            TemplateWorkBook workbook = TemplateWorkBookIO.readTemplateWorkBook(FRContext.getCurrentEnv(), "test.cpt");
            Parameter[] parameters = workbook.getParameters();
            HashMap<String, String> paraMap = new HashMap<>();
            paraMap.put(parameters[0].getName(), "H42F188680811500120190412E001");
            boolean b = PrintUtils.printWorkBook("test.cpt", paraMap, false);//false 代表不需要弹出框直接打印
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
