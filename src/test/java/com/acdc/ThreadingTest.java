package com.acdc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreadHandler implements Runnable {

    @Override
    public void run() {
        try {
            log.info("First step");
            Thread.sleep(4000);
            log.info("Second step");
            Thread.sleep(4000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

@Slf4j
public class ThreadingTest {

    @Test
    void testSimpleThreading() throws InterruptedException{

        Thread thread = new Thread(new ThreadHandler());
        thread.start();
        log.info("Third step");
        Thread.sleep(1000);
        log.info("Fourth step");
        Thread.sleep(1000);




//        thread.join();
    }
}
