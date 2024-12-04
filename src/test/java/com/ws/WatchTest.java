package com.ws;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
@Slf4j
public class WatchTest {

    @Test
    public void TestRunTime() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Thread.sleep(3 * 1000);

        stopWatch.stop();
        log.info("程序执行时间 {}", stopWatch.getTotalTimeMillis());
    }

    @Test
    public void TestUUID() {
        String uuid = UUID.randomUUID().toString();
        String res = uuid.replace("-", "");
        log.info("UUID:{},length:{},replace:{},new length{}", uuid, uuid.length(), res, res.length());
        System.out.println(UUID.randomUUID().toString().length());
    }
}
