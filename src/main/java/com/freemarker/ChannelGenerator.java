package com.freemarker;

import com.freemarker.service4d.impl.Generator;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付通道生成工具
 */
public class ChannelGenerator {

    public static void main(String[] args) throws Exception {
        //生成前，请指定如下参数
        String prefixDir = "C:\\channels";//生成的根目录
        String lchannel = "zdrszpay";//通道名字
        String author = "daniel";//作者
        String port = "20641";//服务端口

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setDirectoryForTemplateLoading(new File(Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath()));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        String date = getToday();
        String cchannel = lchannel.substring(0,1).toUpperCase() + lchannel.substring(1);

        Map<String,String> info = new HashMap<>(11);
        info.put(Constants.PARAM_PORT,port);
        info.put(Constants.PARAM_AUTHOR,author);
        info.put(Constants.PARAM_L_CHANNEL_NAME,lchannel);
        info.put(Constants.PARAM_C_CHANNEL_NAME,cchannel);
        info.put(Constants.PARAM_DATE,date);

        //如果jar有变化，需要复制变更后的jar到resources目录下，然后替换下列jar名
        info.put(Constants.PARAM_HUADAO_COMMON,"huadao-common-1.3.0.jar");
        info.put(Constants.PARAM_DUBBO,"dubbo-2.8.4.jar");
        info.put(Constants.PARAM_CHANNEL_BASE,"huadao-channel-base-1.0.1-SNAPSHOT.jar");
        info.put(Constants.PARAM_IELPM_CORE_SERVICE,"ielpm.core.service-1.0.5.2.jar");
        info.put(Constants.PARAM_SECRET_API,"secret.api-jar-with-dependencies.jar");

        String rootDir = createRootDir(prefixDir,lchannel);
        String trunk = createVCSDir(rootDir);

        info.put(Constants.PARAM_DIR,trunk);
        generatePOM(cfg,info);

        String itfsDir = createItfsDir(trunk,lchannel);
        info.put(Constants.PARAM_DIR,itfsDir);
        com.freemarker.service4d.Generator.generate(cfg,info);

        String sevsDir = createSevsDir(trunk,lchannel);
        info.put(Constants.PARAM_DIR,sevsDir);
        Generator.generate(cfg,info);

        createDocDir(trunk);
    }

    /**
     * 生成总目录下pom.xml
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generatePOM(Configuration cfg,Map<String,String> info) throws Exception{
        Template pomTemplate = cfg.getTemplate(Constants.POM + Constants.FTLH);
        String pomFile = info.get(Constants.PARAM_DIR) + File.separator + Constants.POM + Constants.XML;
        Writer out = new FileWriter(pomFile);
        pomTemplate.process(info, out);
    }


    /**
     * 生成总目录
     * @param rootPath
     * @param channel
     * @return
     * @throws Exception
     */
    private static String createRootDir(String rootPath,String channel){
        String rootStr = rootPath + File.separator + channel;
        Path root = Paths.get(rootStr);
        if(Files.notExists(root)){
            try{Files.createDirectories(root);}
            catch (IOException e ) { e.printStackTrace(); }
        }

       return rootStr;
    }

    /**
     * 生成接口目录
     * @param rootDir
     * @param channel
     * @return
     */
    private static String createItfsDir(String rootDir,String channel){
        String itfsDir = rootDir + File.separator + channel + Constants.INTERFACE_DIR;
        Path itfs = Paths.get(itfsDir);
        if(Files.notExists(itfs)){
            try{Files.createDirectories(itfs);}
            catch (IOException e ) { e.printStackTrace(); }
        }

        return itfsDir;
    }

    /**
     * 生成服务目录
     * @param rootDir
     * @param channel
     * @return
     */
    private static String createSevsDir(String rootDir,String channel){
        String sevsDir = rootDir + File.separator + channel + Constants.SERVICE_DIR;
        Path sevs = Paths.get(sevsDir);
        if(Files.notExists(sevs)){
            try{Files.createDirectories(sevs);}
            catch (IOException e ) { e.printStackTrace(); }
        }

        return sevsDir;
    }

    /**
     * 生成文档目录
     * @param rootDir
     * @throws Exception
     */
    private static void createDocDir(String rootDir) throws Exception{
        String docDir = rootDir + File.separator + Constants.DOCS + File.separator;
        Path docs = Paths.get(docDir);
        if(Files.notExists(docs)){
            try{Files.createDirectories(docs);}
            catch (IOException e ) { e.printStackTrace(); }
        }

        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.CHANGE_LOG).toURI()), Paths.get(docDir + Constants.CHANGE_LOG), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 生成版本控制相关目录
     * @param rootDir
     * @return
     */
    private static String createVCSDir(String rootDir){
        String branchDir = rootDir + File.separator + "branches";
        Path branch = Paths.get(branchDir);
        if(Files.notExists(branch)){
            try{Files.createDirectories(branch);}
            catch (IOException e ) { e.printStackTrace(); }
        }

        String tagDir = rootDir + File.separator + "tags";
        Path tag = Paths.get(tagDir);
        if(Files.notExists(tag)){
            try{Files.createDirectories(tag);}
            catch (IOException e ) { e.printStackTrace(); }
        }

        String trunkDir = rootDir + File.separator + "trunk";
        Path trunk = Paths.get(trunkDir);
        if(Files.notExists(trunk)){
            try{Files.createDirectories(trunk);}
            catch (IOException e ) { e.printStackTrace(); }
        }

        return trunkDir;
    }

    private static String getToday(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}