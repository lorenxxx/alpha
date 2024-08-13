package com.clawchat.alpha.service.impl;

import com.clawchat.alpha.entity.Demo;
import com.clawchat.alpha.mapper.IDemoMapper;
import com.clawchat.alpha.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {

    @Autowired
    private IDemoMapper demoMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Demo getDemoByID(Integer id) {
        String key = "loren";
        redisTemplate.opsForValue().set(key, "fun");

        String value = redisTemplate.opsForValue().get(key);
        System.out.printf("value: %s\n", value);

        return demoMapper.getByID(id);
    }

}
