package com.freemarker.service4d.impl;

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
 * 服务生成工具
 */
public class Generator {
    public static void generate(Configuration cfg, Map<String, String> info) throws Exception {
        generateService4dImpl(cfg, info);

        generateImpls(cfg, info);

        generateUtils(cfg, info);

        generateMain(cfg, info);

        generateEnv(cfg, info);

        generateDubbos(cfg, info);

        generateCfg(cfg, info);

        generateLib(info);

        generateAssembly(cfg, info);

        generatePOM(cfg, info);

        generateDoc(info);
    }

    /**
     * 生成服务
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateService4dImpl(Configuration cfg, Map<String, String> info) throws Exception {
        Template service4dImplTemplate = cfg.getTemplate(Constants.CHANNEL_SERVICE4D_IMPL);
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.SERVICE);
        String service4dImplDirStr = sb.toString();
        String service4dImplFile = sb.append(info.get(Constants.PARAM_C_CHANNEL_NAME)).append(Constants.SUFFIX_4D_IMPL).toString();
        Path service4dImplDir = Paths.get(service4dImplDirStr);
        if (Files.notExists(service4dImplDir)) {
            try {
                Files.createDirectories(service4dImplDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Writer out = new FileWriter(service4dImplFile);
        service4dImplTemplate.process(info, out);
    }

    /**
     * 生成服务具体功能
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateImpls(Configuration cfg, Map<String, String> info) throws Exception {
        //生成代付
        Template dfTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.DF_SERVICE + Constants.FTLH);
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator).append(Constants.SERVICE_IMPL);
        String dfDirStr = sb.toString();
        String dfFile = sb.append(Constants.DF_SERVICE + Constants.JAVA).toString();
        Path dfDir = Paths.get(dfDirStr);
        if (Files.notExists(dfDir)) {
            try {
                Files.createDirectories(dfDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer out = new FileWriter(dfFile);
        dfTemplate.process(info, out);

        //生成网关
        Template gwTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.GW_SERVICE + Constants.FTLH);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator).append(Constants.SERVICE_IMPL);
        String gwDirStr = sb.toString();
        String gwFile = sb.append(Constants.GW_SERVICE + Constants.JAVA).toString();
        Path gwDir = Paths.get(gwDirStr);
        if (Files.notExists(gwDir)) {
            try {
                Files.createDirectories(gwDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(gwFile);
        gwTemplate.process(info, out);

        //生成H5网关
        Template h5GWTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.H5_GW_SERVICE + Constants.FTLH);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator).append(Constants.SERVICE_IMPL);
        String h5GWDirStr = sb.toString();
        String h5GWFile = sb.append(Constants.H5_GW_SERVICE + Constants.JAVA).toString();
        Path h5GWDir = Paths.get(h5GWDirStr);
        if (Files.notExists(h5GWDir)) {
            try {
                Files.createDirectories(h5GWDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(h5GWFile);
        h5GWTemplate.process(info, out);

        //生成快捷
        Template kjTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.KJ_SERVICE + Constants.FTLH);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator).append(Constants.SERVICE_IMPL);
        String kjDirStr = sb.toString();
        String kjFile = sb.append(Constants.KJ_SERVICE + Constants.JAVA).toString();
        Path kjDir = Paths.get(kjDirStr);
        if (Files.notExists(kjDir)) {
            try {
                Files.createDirectories(kjDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(kjFile);
        kjTemplate.process(info, out);

        //生成扫码
        Template smTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.SM_SERVICE + Constants.FTLH);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator).append(Constants.SERVICE_IMPL);
        String smDirStr = sb.toString();
        String smFile = sb.append(Constants.SM_SERVICE + Constants.JAVA).toString();
        Path smDir = Paths.get(smDirStr);
        if (Files.notExists(smDir)) {
            try {
                Files.createDirectories(smDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(smFile);
        smTemplate.process(info, out);
    }

    /**
     * 生成服务工具类
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateUtils(Configuration cfg, Map<String, String> info) throws Exception {
        Template converterTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.TEMPLATE_CONVERTER + Constants.FTLH);
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.UTILS);
        String converterDirStr = sb.toString();
        String converterFile = sb.append(Constants.TEMPLATE_CONVERTER + Constants.JAVA).toString();
        Path converterDir = Paths.get(converterDirStr);
        if (Files.notExists(converterDir)) {
            try {
                Files.createDirectories(converterDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Writer out = new FileWriter(converterFile);
        converterTemplate.process(info, out);
    }

    /**
     * 生成服务Main
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateMain(Configuration cfg, Map<String, String> info) throws Exception {
        Template mainTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.MAIN + Constants.FTLH);
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.JAVA_BASE_PATH).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(File.separator);
        String mainDirStr = sb.toString();
        String mainFile = sb.append(info.get(Constants.PARAM_C_CHANNEL_NAME)).append(Constants.MAIN).append(Constants.JAVA).toString();
        Path mainDir = Paths.get(mainDirStr);
        if (Files.notExists(mainDir)) {
            try {
                Files.createDirectories(mainDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Writer out = new FileWriter(mainFile);
        mainTemplate.process(info, out);
    }

    /**
     * 生成服务环境配置文件
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateEnv(Configuration cfg, Map<String, String> info) throws Exception {
        StringBuilder sb = new StringBuilder();

        //生成alpha配置
        Template alphaTemplate = cfg.getTemplate(Constants.SERVICE_CONFIG_ALPHA);
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ENV_BASE_PATH).append(Constants.ALPHA).append(File.separator);
        String alphaDirStr = sb.toString();
        String alphaFile = sb.append(Constants.SERVICE_CONFIG).toString();
        Path alphaDir = Paths.get(alphaDirStr);
        if (Files.notExists(alphaDir)) {
            try {
                Files.createDirectories(alphaDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer out = new FileWriter(alphaFile);
        alphaTemplate.process(info, out);
        Path alphaCfgDir = Paths.get(alphaDirStr + File.separator + info.get(Constants.PARAM_L_CHANNEL_NAME) + Constants.PROERPTIES_SUFFIX);
        Files.createFile(alphaCfgDir);

        //生成dev配置
        Template devTemplate = cfg.getTemplate(Constants.SERVICE_CONFIG_DEV);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ENV_BASE_PATH).append(Constants.DEV).append(File.separator);
        String devDirStr = sb.toString();
        String devFile = sb.append(Constants.SERVICE_CONFIG).toString();
        Path devDir = Paths.get(devDirStr);
        if (Files.notExists(devDir)) {
            try {
                Files.createDirectories(devDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(devFile);
        devTemplate.process(info, out);
        Path devCfgDir = Paths.get(devDirStr + File.separator + info.get(Constants.PARAM_L_CHANNEL_NAME) + Constants.PROERPTIES_SUFFIX);
        Files.createFile(devCfgDir);

        //生成local配置
        Template localTemplate = cfg.getTemplate(Constants.SERVICE_CONFIG_LOCAL);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ENV_BASE_PATH).append(Constants.LOCAL).append(File.separator);
        String localDirStr = sb.toString();
        String localFile = sb.append(Constants.SERVICE_CONFIG).toString();
        Path localDir = Paths.get(localDirStr);
        if (Files.notExists(localDir)) {
            try {
                Files.createDirectories(localDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(localFile);
        localTemplate.process(info, out);
        Path localCfgDir = Paths.get(localDirStr + File.separator + info.get(Constants.PARAM_L_CHANNEL_NAME) + Constants.PROERPTIES_SUFFIX);
        Files.createFile(localCfgDir);

        //生成prd配置
        Template prdTemplate = cfg.getTemplate(Constants.SERVICE_CONFIG_PRD);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ENV_BASE_PATH).append(Constants.PRD).append(File.separator);
        String prdDirStr = sb.toString();
        String prdFile = sb.append(Constants.SERVICE_CONFIG).toString();
        Path prdDir = Paths.get(prdDirStr);
        if (Files.notExists(prdDir)) {
            try {
                Files.createDirectories(prdDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(prdFile);
        prdTemplate.process(info, out);
        Path prdCfgDir = Paths.get(prdDirStr + File.separator + info.get(Constants.PARAM_L_CHANNEL_NAME) + Constants.PROERPTIES_SUFFIX);
        Files.createFile(prdCfgDir);

        //生成uat配置
        Template uatTemplate = cfg.getTemplate(Constants.SERVICE_CONFIG_UAT);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ENV_BASE_PATH).append(Constants.UAT).append(File.separator);
        String uatDirStr = sb.toString();
        String uatFile = sb.append(Constants.SERVICE_CONFIG).toString();
        Path uatDir = Paths.get(uatDirStr);
        if (Files.notExists(uatDir)) {
            try {
                Files.createDirectories(uatDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(uatFile);
        uatTemplate.process(info, out);
        Path uatCfgDir = Paths.get(uatDirStr + File.separator + info.get(Constants.PARAM_L_CHANNEL_NAME) + Constants.PROERPTIES_SUFFIX);
        Files.createFile(uatCfgDir);
    }

    /**
     * 生成服务dubbo文件
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateDubbos(Configuration cfg, Map<String, String> info) throws Exception {
        StringBuilder sb = new StringBuilder();

        //生成spring-xxxx-context.xml
        Template contextTemplate = cfg.getTemplate(Constants.SPRING_CONTEXT);
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.RES_BASE_PATH);
        String contextDirStr = sb.toString();
        String contextFile = sb.append(Constants.SPRING_PREFIX).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.CONTEXT_SUFFIX).append(Constants.XML).toString();
        Path contextDir = Paths.get(contextDirStr);
        if (Files.notExists(contextDir)) {
            try {
                Files.createDirectories(contextDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer out = new FileWriter(contextFile);
        contextTemplate.process(info, out);

        //生成spring-dubbo-xxxx-common.xml
        Template commonTemplate = cfg.getTemplate(Constants.DUBBO_COMMON);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.RES_BASE_PATH);
        String commonDirStr = sb.toString();
        String commonFile = sb.append(Constants.SPRING_PREFIX).append(Constants.DUBBO_PREFIX).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.COMMON_SUFFIX).append(Constants.XML).toString();
        Path commonDir = Paths.get(commonDirStr);
        if (Files.notExists(commonDir)) {
            try {
                Files.createDirectories(commonDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(commonFile);
        commonTemplate.process(info, out);

        //生成spring-dubbo-xxxx-consumer.xml
        Template consumerTemplate = cfg.getTemplate(Constants.DUBBO_CONSUMER);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.RES_BASE_PATH);
        String consumerDirStr = sb.toString();
        String consumerFile = sb.append(Constants.SPRING_PREFIX).append(Constants.DUBBO_PREFIX).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.CONSUMER_SUFFIX).append(Constants.XML).toString();
        Path consumerDir = Paths.get(consumerDirStr);
        if (Files.notExists(consumerDir)) {
            try {
                Files.createDirectories(consumerDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(consumerFile);
        consumerTemplate.process(info, out);

        //生成spring-dubbo-xxxx-provider.xml
        Template providerTemplate = cfg.getTemplate(Constants.DUBBO_PROVIDER);
        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.RES_BASE_PATH);
        String providerDirStr = sb.toString();
        String providerFile = sb.append(Constants.SPRING_PREFIX).append(Constants.DUBBO_PREFIX).append(info.get(Constants.PARAM_L_CHANNEL_NAME)).append(Constants.PROVIDER_SUFFIX).append(Constants.XML).toString();
        Path providerDir = Paths.get(providerDirStr);
        if (Files.notExists(providerDir)) {
            try {
                Files.createDirectories(providerDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        out = new FileWriter(providerFile);
        providerTemplate.process(info, out);
    }

    /**
     * 生成服务工具配置文件
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateCfg(Configuration cfg, Map<String, String> info) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.RES_PREFIX_BASE_PATH);
        String cfgDirStr = sb.toString();
        Path cfgDir = Paths.get(cfgDirStr);
        if (Files.notExists(cfgDir)) {
            try {
                Files.createDirectories(cfgDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //复制bank_branch_info.cvs
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.S_4D_IMPL + Constants.BANK_BRANCH_INFO).toURI()), Paths.get(cfgDirStr + Constants.BANK_BRANCH_INFO), StandardCopyOption.REPLACE_EXISTING);
        //复制bank_id_mapping.cvs
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.S_4D_IMPL + Constants.BANK_ID_MAPPING).toURI()), Paths.get(cfgDirStr + Constants.BANK_ID_MAPPING), StandardCopyOption.REPLACE_EXISTING);
        //复制convert_template.properties
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.S_4D_IMPL + Constants.CONVERT_TEMPLATE).toURI()), Paths.get(cfgDirStr + Constants.CONVERT_TEMPLATE), StandardCopyOption.REPLACE_EXISTING);
        //复制return_code_mapping.cvs
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.S_4D_IMPL + Constants.RETURN_CODE_MAPPING).toURI()), Paths.get(cfgDirStr + Constants.RETURN_CODE_MAPPING), StandardCopyOption.REPLACE_EXISTING);

        Template logTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.LOG24J + Constants.FTLH);
        String logFile = sb.append(Constants.LOG24J).append(Constants.XML).toString();
        Writer out = new FileWriter(logFile);
        logTemplate.process(info, out);
    }

    /**
     * 复制服务相关jar
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

        //复制huadao-common.jar
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(info.get(Constants.PARAM_HUADAO_COMMON)).toURI()), Paths.get(libDirStr + info.get(Constants.PARAM_HUADAO_COMMON)), StandardCopyOption.REPLACE_EXISTING);
        //复制dubbo.jar
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(info.get(Constants.PARAM_DUBBO)).toURI()), Paths.get(libDirStr + info.get(Constants.PARAM_DUBBO)), StandardCopyOption.REPLACE_EXISTING);
        //复制channel-base.jar
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(info.get(Constants.PARAM_CHANNEL_BASE)).toURI()), Paths.get(libDirStr + info.get(Constants.PARAM_CHANNEL_BASE)), StandardCopyOption.REPLACE_EXISTING);
        //复制ielpm_core_service.jar
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(info.get(Constants.PARAM_IELPM_CORE_SERVICE)).toURI()), Paths.get(libDirStr + info.get(Constants.PARAM_IELPM_CORE_SERVICE)), StandardCopyOption.REPLACE_EXISTING);
        //复制secret_api.jar
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(info.get(Constants.PARAM_SECRET_API)).toURI()), Paths.get(libDirStr + info.get(Constants.PARAM_SECRET_API)), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 生成服务聚合文件
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generateAssembly(Configuration cfg, Map<String, String> info) throws Exception {
        StringBuilder sb = new StringBuilder();

        //复制assembly.xml
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ASSEMBLY).append(File.separator);
        String assemblyDirStr = sb.toString();
        Path assemblyDir = Paths.get(assemblyDirStr);
        if (Files.notExists(assemblyDir)) {
            try {
                Files.createDirectories(assemblyDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.S_4D_IMPL + Constants.ASSEMBLY + Constants.XML).toURI()), Paths.get(assemblyDirStr + Constants.ASSEMBLY + Constants.XML), StandardCopyOption.REPLACE_EXISTING);


        //生成run文件
        String binDirStr = sb.append(Constants.BIN).append(File.separator).toString();
        Path binDir = Paths.get(binDirStr);
        if (Files.notExists(binDir)) {
            try {
                Files.createDirectories(binDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Template runBatTemplate = cfg.getTemplate(Constants.RUN_BAT_FTLH);
        String runBatFile = sb.append(Constants.RUN_BAT).toString();
        Writer out = new FileWriter(runBatFile);
        runBatTemplate.process(info, out);

        sb = new StringBuilder();
        sb.append(info.get(Constants.PARAM_DIR)).append(File.separator).append(Constants.ASSEMBLY).append(File.separator).append(Constants.BIN).append(File.separator);
        Template runShTemplate = cfg.getTemplate(Constants.RUN_SH_FTLH);
        String runShFile = sb.append(Constants.RUN_SH).toString();
        out = new FileWriter(runShFile);
        runShTemplate.process(info, out);
    }

    /**
     * 生成服务pom.xml
     * @param cfg
     * @param info
     * @throws Exception
     */
    private static void generatePOM(Configuration cfg, Map<String, String> info) throws Exception {
        Template pomTemplate = cfg.getTemplate(Constants.S_4D_IMPL + Constants.POM + Constants.FTLH);
        String pomFile = info.get(Constants.PARAM_DIR) + File.separator + Constants.POM + Constants.XML;
        Writer out = new FileWriter(pomFile);
        pomTemplate.process(info, out);
    }

    /**
     * 生成服务文档
     * @param info
     * @throws Exception
     */
    private static void generateDoc(Map<String, String> info) throws Exception {
        String docDir = info.get(Constants.PARAM_DIR) + File.separator + Constants.DOCS + File.separator;
        Path docs = Paths.get(docDir);
        if (Files.notExists(docs)) {
            try {
                Files.createDirectories(docs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Files.copy(Paths.get(Thread.currentThread().getContextClassLoader().getResource(Constants.CHANGE_LOG).toURI()), Paths.get(docDir + Constants.CHANGE_LOG), StandardCopyOption.REPLACE_EXISTING);
    }

}
