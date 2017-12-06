package com.freemarker;

import java.io.File;

public interface Constants {
    String PARAM_PORT = "port";
    String PARAM_AUTHOR = "author";
    String PARAM_L_CHANNEL_NAME = "l_channel_name";
    String PARAM_C_CHANNEL_NAME = "c_channel_name";
    String PARAM_DATE = "date";
    String PARAM_HUADAO_COMMON = "huadao_common";
    String PARAM_DUBBO = "dubbo";
    String PARAM_CHANNEL_BASE = "channel_base";
    String PARAM_IELPM_CORE_SERVICE = "ielpm_core_service";
    String PARAM_SECRET_API = "secret_api";
    String PARAM_DIR = "dir";
    String FTLH = ".ftlh";
    String JAVA = ".java";
    String XML = ".xml";


    String INTERFACE_DIR = "-channel-interface";
    String SERVICE_DIR = "-channel-service";
    String DOCS = "docs";
    String POM = "pom";

    String SUFFIX_4D = "ChannelService4d.java";
    String JAVA_COMMON_DIR = "com" + File.separator + "huadao" + File.separator + "channel";
    String RESOURCE_COMMON_DIR = "META-INF" + File.separator + "spring";
    String S_4D = "service4d" + File.separator;
    String CHANNEL_SERVICE4D = "channel-service4d";
    String DUBBO_SUFFIX = "-dubbo";
    String SPRING_PREFIX = "spring-";
    String CONTEXT_SUFFIX = "-context";
    String DUBBO_PREFIX = "dubbo-";
    String COMMON_SUFFIX = "-common";
    String CONSUMER_SUFFIX = "-consumer";
    String PROVIDER_SUFFIX = "-provider";
    String DUBBO_4D = S_4D + SPRING_PREFIX + DUBBO_SUFFIX + CONSUMER_SUFFIX + FTLH;
    String PROERPTIES_SUFFIX = "_00.properties";


    String SUFFIX_4D_IMPL = "ChannelService4dImpl.java";
    String BASE_PATH = "src" + File.separator + "main" + File.separator;
    String RES_PREFIX_BASE_PATH = BASE_PATH + "resources" + File.separator;
    String JAVA_PREFIX_BASE_PATH = BASE_PATH + "java" + File.separator;
    String JAVA_BASE_PATH = JAVA_PREFIX_BASE_PATH + JAVA_COMMON_DIR + File.separator;
    String ENV_BASE_PATH = BASE_PATH + "env" + File.separator;
    String RES_BASE_PATH = RES_PREFIX_BASE_PATH + RESOURCE_COMMON_DIR + File.separator;
    String SERVICE_CONFIG = "serviceconfig.properties";
    String S_4D_IMPL = "service4d_impl" + File.separator;
    String CHANNEL_SERVICE4D_IMPL = S_4D_IMPL + "channel-service4d-impl.ftlh";
    String DF_SERVICE = "DFServiceImpl";
    String GW_SERVICE = "GWServiceImpl";
    String H5_GW_SERVICE = "H5GWServiceImpl";
    String KJ_SERVICE = "KJServiceImpl";
    String SM_SERVICE = "SMServiceImpl";
    String TEMPLATE_CONVERTER = "TemplatePacketConverter";
    String MAIN = "Main";
    String ENV = "env";
    String SERVICE_CONFIG_TAG = "serviceconfig";
    String ALPHA = "alpha";
    String DEV = "dev";
    String LOCAL = "local";
    String PRD = "prd";
    String UAT = "uat";
    String SERVICE_CONFIG_ALPHA = S_4D_IMPL + ENV + File.separator + ALPHA + File.separator + SERVICE_CONFIG_TAG + FTLH;
    String SERVICE_CONFIG_DEV = S_4D_IMPL + ENV + File.separator + DEV + File.separator + SERVICE_CONFIG_TAG + FTLH;
    String SERVICE_CONFIG_LOCAL = S_4D_IMPL + ENV + File.separator + LOCAL + File.separator + SERVICE_CONFIG_TAG + FTLH;
    String SERVICE_CONFIG_PRD = S_4D_IMPL + ENV + File.separator + PRD + File.separator + SERVICE_CONFIG_TAG + FTLH;
    String SERVICE_CONFIG_UAT = S_4D_IMPL + ENV + File.separator + UAT + File.separator + SERVICE_CONFIG_TAG + FTLH;
    String SPRING_CONTEXT = S_4D_IMPL + SPRING_PREFIX + CONTEXT_SUFFIX + FTLH;
    String DUBBO_COMMON = S_4D_IMPL + SPRING_PREFIX + DUBBO_PREFIX + COMMON_SUFFIX + FTLH;
    String DUBBO_CONSUMER = S_4D_IMPL + SPRING_PREFIX + DUBBO_PREFIX + CONSUMER_SUFFIX + FTLH;
    String DUBBO_PROVIDER = S_4D_IMPL + SPRING_PREFIX + DUBBO_PREFIX + PROVIDER_SUFFIX + FTLH;
    String ASSEMBLY = "assembly";
    String RUN_BAT_FTLH = S_4D_IMPL + "run_bat" + FTLH;
    String RUN_BAT = "run.bat";
    String RUN_SH_FTLH = S_4D_IMPL + "run_sh" + FTLH;
    String RUN_SH = "run.sh";
    String CHANGE_LOG = "changeLog.txt";
    String LOG24J = "log4j2";
    String BANK_BRANCH_INFO = "bank_branch_info.csv";
    String BANK_ID_MAPPING = "bank_id_mapping.csv";
    String CONVERT_TEMPLATE = "converttemplate.properties";
    String RETURN_CODE_MAPPING = "return_code_mapping.csv";
    String SERVICE = File.separator + "service" + File.separator;
    String SERVICE_IMPL = SERVICE + "impl" + File.separator;
    String UTILS = File.separator + "utils" + File.separator;
    String BIN = "bin";
    String LIB = "lib";
}
