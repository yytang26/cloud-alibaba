package com.tyy.sentinel.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:tyy
 * @date:2022/5/6
 */
@Service
public class SentinelManager {

    @Autowired
    private SentinelService sentinelService;

    public void test() {
        Entry entry = null;
        try {
            entry = SphU.entry("resource");
            sentinelService.hello();
        } catch (BlockException ne) {
        } finally {
            if (null != entry) {
                entry.exit();
            }
        }
    }


    @SentinelResource(value = "world",blockHandler = "exceptionHandler")
    public void world() {
        sentinelService.hello();
    }

    public String exceptionHandler(BlockException exception) {
        exception.printStackTrace();
        return "A O";
    }


}
