package com.freemarker.service4d;

import com.freemarker.Constants;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

/**
 * 接口生成工具
 */
public class Generator {
    public static void generate(Configuration cfg, Map<String, String> info) throws Exception {

        generateService4d(cfg, info);

        generatePOM(cfg, info);

        generateDubbos(cfg, info);

        generateLib(info);
    }

    /**
     * 生成接口
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateService4d(Configuration cfg, Map<String, String> info) throws Exception {
        Template service4dTemplate = cfg.getTemplate(Constants.S_4D + Constants.CHANNEL_SERVICE4D + Constants.FTLH);
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_PREFIX_BASE_PATH).append(Constants.JAVA_COMMON_DIR).append(File.separator).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator);
        String service4dDirStr = sb.toString();
        String service4dFile = sb.append(info.get(Constants.PARAM_C_CHANNEL_NAME)).append(Constants.SUFFIX_4D).toString();
        Path service4dDir = Paths.get(service4dDirStr);
        if (Files.notExists(service4dDir)) {
            try {
                Files.createDirectories(service4dDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Writer out = new FileWriter(service4dFile);
        service4dTemplate.process(info, out);
    }

    /**
     * 生成接口pom.xml
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generatePOM(Configuration cfg, Map<String, String> info) throws Exception {
        Template pomTemplate = cfg.getTemplate(Constants.S_4D + Constants.POM + Constants.FTLH);
        String pomFile = info.get(Constants.PARAM_DIR) + File.separator + Constants.POM + Constants.XML;
        Writer out = new FileWriter(pomFile);
        pomTemplate.process(info, out);
    }

    /**
     * 生成接口dubbo文件
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateDubbos(Configuration cfg, Map<String, String> info) throws Exception {
        Template consumerTemplate = cfg.getTemplate(Constants.DUBBO_4D);
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.RES_PREFIX_BASE_PATH).append(Constants.RESOURCE_COMMON_DIR).append(File.separator);
        String consumerDirStr = sb.toString();
        String consumerFile = sb.append(Constants.SPRING_PREFIX).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.DUBBO_SUFFIX).append(Constants.CONSUMER_SUFFIX).append(Constants.XML).toString();
        Path consumerDir = Paths.get(consumerDirStr);
        if (Files.notExists(consumerDir)) {
            try {
                Files.createDirectories(consumerDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer out = new FileWriter(consumerFile);
        consumerTemplate.process(info, out);
    }

    /**
     * 复制接口相关jar
     * @param info
     * @throws Exception
     */
    private static void generateLib(Map<String, String> info) throws Exception {
        String libDirStr = info.get(Constants.PARAM_DIR) + File.separator + Constants.LIB + File.separator;
        Path libDir = Paths.get(libDirStr);
        if (Files.notExists(libDir)) {
            try {
                Files.createDirectories(libDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(info.get(Constants.PARAM_HUADAO_COMMON)).toURI()), Paths.get(libDirStr + info.get(Constants.PARAM_HUADAO_COMMON)), StandardCopyOption.REPLACE_EXISTING);
    }


}
