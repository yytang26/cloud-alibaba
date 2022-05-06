package com.tyy.sentinel.sentinel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:tyy
 * @date:2022/5/6
 */
@RestController
public class SentinelController {

    @Autowired
    private SentinelManager sentinelManager;

    @GetMapping("/test")
    public void test() {
        for (int i = 0; i < 20; i++) {
            sentinelManager.test();
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/world")
    public void world() {
        for (int i = 0; i < 20; i++) {
           sentinelManager.world();
        }
    }
}
