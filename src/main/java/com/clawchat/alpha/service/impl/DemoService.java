package com.clawchat.alpha.service.impl;

import com.clawchat.alpha.entity.Demo;
import com.clawchat.alpha.mapper.IDemoMapper;
import com.clawchat.alpha.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {

    @Autowired
    private IDemoMapper demoMapper;

    @Override
    public Demo getDemoByID(Integer id) {
        return demoMapper.getByID(id);
    }

}
