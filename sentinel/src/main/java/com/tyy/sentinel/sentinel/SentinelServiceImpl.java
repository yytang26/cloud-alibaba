package com.tyy.sentinel.sentinel;

import org.springframework.stereotype.Service;

/**
 * @author:tyy
 * @date:2022/5/6
 */
@Service
public class SentinelServiceImpl implements SentinelService {


    @Override
    public String hello() {
        return "Hello World";
    }
}
