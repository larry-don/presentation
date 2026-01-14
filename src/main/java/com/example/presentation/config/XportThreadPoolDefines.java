package com.example.presentation.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

import static com.example.presentation.config.XportCommonProperties.DEFAULT_KEEPALIVE;
import static com.example.presentation.config.XportCommonProperties.THREAD_NAME_PREFIX;


/**
 * 本类用于
 *
 * @author liuhao
 * @since 2024/04/09 14:57
 */
@Getter
@Slf4j
@RequiredArgsConstructor
public enum XportThreadPoolDefines {


    /**
     * 导入文件解析任务
     */
    IMPORT_PARSER_TASK(new XportThreadPoolConfig(10, DEFAULT_KEEPALIVE, 100, THREAD_NAME_PREFIX + "import-parser", null)),

    /**
     * 导入附件上传任务
     */
    IMPORT_PARSER_ATTACHMENT_UPLOAD(new XportThreadPoolConfig(2, DEFAULT_KEEPALIVE, 10000, THREAD_NAME_PREFIX + "import-attachment-upload", null)),

    /**
     * 导入事件消费任务,最少需要支持excel最大值的容量 1040000/500
     */
    IMPORT_EVENT_CONSUMER_TASK(new XportThreadPoolConfig(10, DEFAULT_KEEPALIVE, 2100, THREAD_NAME_PREFIX + "import-event-consumer", null)),

    /**
     * 导入翻译数据的字段并发异步线程
     */
    IMPORT_TRANSLATE_FIELD_QUERY_TASK(new XportThreadPoolConfig(32, DEFAULT_KEEPALIVE, 2000, THREAD_NAME_PREFIX + "import-translate-query-field", null, null)),

    /**
     * 导入数据异步并发保存的线程池
     */
    IMPORT_SAVE_DATA(new XportThreadPoolConfig(10, DEFAULT_KEEPALIVE, 500, THREAD_NAME_PREFIX + "import-save-data", null)),

    /**
     * 导入进度上报任务
     */
    IMPORT_PROGRESS_REPORTER(new XportThreadPoolConfig(1, DEFAULT_KEEPALIVE, 100, THREAD_NAME_PREFIX + "import-progress-reporter", null)),

    /**
     * 导出任务，异步处理
     */
    EXPORT_TASK(new XportThreadPoolConfig(15, DEFAULT_KEEPALIVE, 1000, THREAD_NAME_PREFIX + "export-streaming", new ThreadPoolExecutor.AbortPolicy())),

    /**
     * 导出附件并发下载任务
     */
    EXPORT_FILE_DOWNLOAD(new XportThreadPoolConfig(15, DEFAULT_KEEPALIVE, 1000, THREAD_NAME_PREFIX + "export-file-download", null)),

    /**
     * 导出结果上报任务
     */
    EXPORT_RESULT_REPORTER(new XportThreadPoolConfig(1, DEFAULT_KEEPALIVE, 100, THREAD_NAME_PREFIX + "export-result-reporter", new ThreadPoolExecutor.DiscardOldestPolicy())),

    /**
     * 异常报警通知任务
     */
    WARNING_NOTIFY_CHANNEL(new XportThreadPoolConfig(1, DEFAULT_KEEPALIVE, 1000, THREAD_NAME_PREFIX + "warning-notify-channel", new ThreadPoolExecutor.AbortPolicy())),

    /**
     * 编辑态导入
     */
    EDIT_IMPORT_TASK(new XportThreadPoolConfig(10, DEFAULT_KEEPALIVE, 500, THREAD_NAME_PREFIX + "edit-import", null)),


    /**
     * 导入进度更新通知处理线程池
     */
    IMPORT_SERVER_PROGRESS_EVENT_DISPATCHER(new XportThreadPoolConfig(20, DEFAULT_KEEPALIVE, 1000, THREAD_NAME_PREFIX + "server-progress-event-dispatcher", null)),

    /**
     * 导入导出模板升级到RDB线程池
     */
    UPGRADE_TEMPLATE_TASK(new XportThreadPoolConfig(80, DEFAULT_KEEPALIVE, 5000, THREAD_NAME_PREFIX + "upgrade-template", null)),

    /**
     * 导入导出模板双写线程池
     */
    DOUBLE_WRITE_TASK(new XportThreadPoolConfig(10, DEFAULT_KEEPALIVE, 1000, THREAD_NAME_PREFIX + "double-write", null)),

    /**
     * 导入完成事件
     */
    IMPORT_COMPLETE_EVENT(new XportThreadPoolConfig(5, DEFAULT_KEEPALIVE, 100, THREAD_NAME_PREFIX + "import_complete_event", null)),


    /**
     * 测试线程池
     */
    TEST_THREAD(new XportThreadPoolConfig(10, DEFAULT_KEEPALIVE, 2100, THREAD_NAME_PREFIX + "test_thread", null, true)),
    ;

    private final XportThreadPoolConfig defaultConfig;

}
