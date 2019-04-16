package com.yyc.finereport;

import com.fr.web.ReportServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinereportApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinereportApplication.class, args);
    }

    @Bean // servlet 映射
    public ServletRegistrationBean reportServer() {
        return new ServletRegistrationBean(new ReportServlet(), "/ReportServer");
    }
}
