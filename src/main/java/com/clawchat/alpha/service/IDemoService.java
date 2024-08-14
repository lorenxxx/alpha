package com.clawchat.alpha.service;

import com.clawchat.alpha.entity.Demo;

import java.util.List;

public interface IDemoService {

    Integer createDemo(Demo demo);

    Integer deleteDemoById(Integer id);

    Integer updateDemo(Demo demo);

    Demo getDemoById(Integer id);

    List<Demo> queryDemoByIds(List<Integer> ids);
}
