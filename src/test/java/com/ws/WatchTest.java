package com.ws;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

@SpringBootTest
@Slf4j
public class WatchTest {

    @Test
    public void TestRunTime() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Thread.sleep(3*1000);

        stopWatch.stop();
        log.info("程序执行时间 {}",stopWatch.getTotalTimeMillis());
    }
}
