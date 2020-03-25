package com.fsh.jcartsupportback.consumer;

import com.alibaba.fastjson.JSON;
import com.fsh.jcartsupportback.mq.HotProductDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Blake
 * @create 2020-03-25 16:40
 */
@Component
public class HotProductConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "hotproduct",groupId = "hot-product-group01")
    public void hotproduct(String productIdstr){
        logger.info("handle productId: {}",productIdstr);
        HotProductDTO hotProductDTO = JSON.parseObject(productIdstr, HotProductDTO.class);
    }
}
