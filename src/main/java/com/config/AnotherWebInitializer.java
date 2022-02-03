package com.config;

import org.springframework.security.web.context.AbstractDispatcherServletInitializer;
import javax.servlet.WebApplicationContext;
import javax.servlet.XmlWebApplicationContext;

//Another way to replace web.xml, used with SecurityInitializer.java
public class AnotherWebInitializer extends AbstractDispatcherServletInitializer {

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocation("/WEB-INF/spring/security-config.xml");
        return ctx;
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext ctx = new XmlWebApplicationContext();
        ctx.setConfigLocations(
        // MVC configuration
        "/WEB-INF/spring/mvc-config.xml",
        // Service configuration
        "/WEB-INF/spring/app-config.xml");
        return ctx;
    }
}