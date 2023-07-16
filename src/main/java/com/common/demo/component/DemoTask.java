package com.common.demo.component;

import com.common.core.util.DateUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * DemoTask
 */
@Slf4j
@Component
public class DemoTask {
    @Value("${async.enabled:false}")
    private boolean enabled;

    /**
     * job1
     * <p>
     * 按照标准时间来算，每隔 10s 执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        if (enabled) {
            log.info("【job1】开始执行：{}", DateUtil.formatDateTime(new Date()));
        }
    }

    /**
     * job2
     * <p>
     * 从启动时间开始，间隔 2s 执行
     * 固定间隔时间
     */
    @Scheduled(fixedRate = 2000)
    public void job2() {
        if (enabled) {
            log.info("【job2】开始执行：{}", DateUtil.formatDateTime(new Date()));
        }
    }

    /**
     * job3
     * <p>
     * 从启动时间开始，延迟 5s 后间隔 4s 执行
     * 固定等待时间
     */
    @Scheduled(fixedDelay = 4000, initialDelay = 5000)
    public void job3() {
        if (enabled) {
            log.info("【job3】开始执行：{}", DateUtil.formatDateTime(new Date()));
        }
    }
}
