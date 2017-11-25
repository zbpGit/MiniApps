package com.zbp.config;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.log.Log4jLogFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.SqlReporter;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;
import com.zbp.controller.PayController;

/**
 * Created by Administrator on 2017/8/9.
 */
public class Mybogl extends JFinalConfig {

    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        //开启日志
        constants.setLogFactory(new Log4jLogFactory());
        SqlReporter.setLog(true);
    }

    public void configRoute(Routes routes) {
        routes.add("/", PayController.class);
    }

    public void configEngine(Engine engine) {
        /*导入函数路径*/
        engine.setBaseTemplatePath(PathKit.getWebRootPath());
    }

    public void configPlugin(Plugins plugins) {

    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }

    @Override
    public void afterJFinalStart() {
        System.out.println("JFinalMiniApps");
    }

    public static void main(String[] args) {
        JFinal.start("JFinalMiniApps/src/main/webapp",8080,"/");
    }
}
