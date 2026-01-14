package com.example.presentation.config;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 本类用于
 *
 * @author liuhao
 * @since 2023/11/13 15:53
 */
@Slf4j
@Data
@FieldNameConstants
@Configuration
@ConfigurationProperties(XportCommonProperties.CONFIG_PREFIX)
@RequiredArgsConstructor
public class XportCommonProperties {

    public static final String CONFIG_PREFIX = "yonbip.xport.sdk";

    public static final String CONFIG_COMPATIBLE_VERSION = CONFIG_PREFIX + "." + Fields.compatibleVersion;

    public static final String THREAD_NAME_PREFIX = "ap-xport-";
    public static final Duration DEFAULT_KEEPALIVE = Duration.ofMinutes(2);

    @Value("${spring.application.name:${vcap.application.name:${spring.config.name:application}}}")
    protected String applicationName;

    @Value("${dc_app_env:${mw_profiles_active:${spring.profiles.active:unknown}}}")
    protected String environment;

    /**
     * 是否时专属化安装，专属化不推送消息
     */
    @Value("${isPremises:false}")
    protected Boolean isPremises = false;

    @Value("${mdd.i18n.enable:false}")
    protected boolean mddI18nEnable = false;

    /**
     * 是否忽略字段权限,默认忽略,目前已知人力云不忽略
     *
     * @since 8.3.0
     */
    @Value("${mdd.ignore.fieldAuth:true}")
    protected boolean ignoreFieldAuth = true;

    /**
     * 是否禁用OTTToken，因为ISV无法使用，外网无法生成和验证OTT
     *
     * @since 8.3.0
     */
    protected boolean disableOttToken = false;

    /**
     * 发送预警消息的机器人地址
     */
    protected String onlineRobotUrl = "https://c2.yonyoucloud.com/yonbip-ec-link/intelligent-robot/system/send?accessToken=1861657457245290507";

    protected String testRobotUrl = "https://c2.yonyoucloud.com/yonbip-ec-link/intelligent-robot/system/send?accessToken=1861103088644390918";

    @NestedConfigurationProperty
    protected RobotConnectionProperties robotConnection = new RobotConnectionProperties();

    protected Set<String> atUserEmails = Sets.newHashSet();

    @Value("${domain.iuap-metadata-ui:}")
    protected String uimetaServerUrl = "https://bip-test.yonyoucloud.com/iuap-metadata-ui/";

    /**
     * 使用统计的上报间隔时间，如果为0则不上报
     */
    protected Duration usageReportInterval = Duration.ofHours(6);
    /**
     * 使用统计计数的间隔时间
     */
    protected Duration usageSegmentCountingDuration = Duration.ofHours(10);

    /**
     * YNF导入导出是否启用xport存储，null标识默认获取，获取不到降级，true标识仅使用xport存储，false表示仅使用uimeta存储
     */
    protected Boolean enableXportStorage;

    /**
     * 715升级过程中，大供应链无法一个迭代完成升级，这里增加一个开关，支持走旧的
     */
    protected String compatibleVersion;

    @Value("${mdd.import.event.v2.switch:true}")
    protected Boolean importV2Switch;

    /**
     * YonBIP访问地址
     */
    @Value("${domain.url:}")
    protected String domainUrl = "https://bip-test.yonyoucloud.com";

    /**
     * 多语服务地址，目前用于发布多语系统级使用
     */
    @Value("${domain.iuap-apcom-i18n:}")
    protected String i18nServerUrl = "https://bip-test.yonyoucloud.com/iuap-apcom-i18n/";

    @NestedConfigurationProperty
    protected Map<XportThreadPoolDefines, XportThreadPoolConfig> configuration = new HashMap<>();

    protected Integer connectTimeoutMs = 2000;

    protected Integer readTimeoutMs = 30000;

    protected Integer maxTotal = 100;

    protected Integer defaultMaxPerRoute = 100;

    protected Integer connectionRequestTimeout = 5000;

    /**
     * 影响错误信息构造的逻辑，哪些包是内部的包，获取有效错误信息和拼接错误信息时使用
     */
    protected Set<String> internalPackagePrefixes = Sets.newHashSet("com.yonyou", "org.imeta");

    /**
     * 影响错误信息构造的过程，哪些信息时无效的，获取有效错误信息和拼接错误信息时使用
     */
    protected Set<String> meaninglessMessagesLowerCase = Sets.newHashSet("null", "undefined", "服务端逻辑异常", "999");

    /**
     * 影响错误信息构造的过程，哪些信息时无效的，获取有效错误信息和拼接错误信息时使用
     */
    protected Set<String> meaninglessMessagesI18nCodes = Sets.newHashSet("UID:P_MDD-BACK_189A3F3204500037", "UID:P_MDD-BACK_189D006405B0006F");

    /**
     * 保持多选参照单个页签结构
     */
    protected boolean keepReferListIndependentSheet = false;

    /**
     * 诊断信息在内存或者redis中的缓存时长，默认1天
     */
    protected Duration diagnosisCacheDuration = Duration.ofDays(1);

    /**
     * 用于查看|导出参照领域替换参照勇 referViewRefCodeMapping:{“原refcode”:”替换参照的refcode”,“原refcode”:”替换参照的refcode”,...}
     */
    protected String referViewRefCodeMapping;

    /**
     * openApiTranslateSilentMode:true表示开启静默模式，默认为false，如果为true，则不抛出异常, 返回原始的数据
     */
    protected boolean openApiTranslateSilentMode = false;

    /**
     * 是否统一存储UI模版的服务
     */
    @Value("${mdd.uimeta.prop.isMetaServer:false}")
    private boolean isUnionMetaServer = false;

    /**
     * 根据环境编码，返回对应的群机器人地址，专属化已经处理有判断，不会运行
     *
     * @return 群机器人消息发送地址
     */


    @Data
    public static class RobotConnectionProperties {

        private Integer connectTimeoutMs = 2000;

        private Integer readTimeoutMs = 5000;

        private Integer maxTotal = 100;

        private Integer defaultMaxPerRoute = 100;

        private Integer connectionRequestTimeout = 5000;

    }


}
