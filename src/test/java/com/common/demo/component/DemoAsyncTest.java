package com.common.demo.component;

import com.common.demo.DemoApplicationTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 * DemoAsyncTest
 *
 * @author Wenzhou
 * @since 2023/7/14 14:10
 */
@Slf4j
@Component
public class DemoAsyncTest extends DemoApplicationTest {
    /**
     * task
     */
    @Autowired
    private DemoAsync task;

    @Autowired
    @Qualifier("AsyncExecutor")
    private Executor executor;

    @Before
    public void before() {
        ThreadPoolTaskExecutor pool = (ThreadPoolTaskExecutor) executor;
        log.info("core-pool-size:{}, max-pool-size:{}.", pool.getCorePoolSize(), pool.getMaxPoolSize());

    }

    /**
     * asyncTaskTest
     * 测试异步任务
     */
    @Test
    public void asyncTaskTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<Boolean> asyncTask1 = task.asyncTask1();
        Future<Boolean> asyncTask2 = task.asyncTask2();
        Future<Boolean> asyncTask3 = task.asyncTask3();

        // 调用 get() 阻塞主线程
        //asyncTask1.get();
        //asyncTask2.get();
        //asyncTask3.get();
        long end = System.currentTimeMillis();

        log.info("异步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }

    /**
     * taskTest
     * 测试同步任务
     */
    @Test
    public void taskTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        task.task1();
        task.task2();
        task.task3();
        long end = System.currentTimeMillis();

        log.info("同步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }
}
