package com.clawchat.alpha.service;

import com.clawchat.alpha.entity.Demo;

public interface IDemoService {

    Integer createDemo(Demo demo);

    Integer deleteDemoById(Integer id);

    Integer updateDemo(Demo demo);

    Demo getDemoById(Integer id);

    Demo getDemoByName(String name);

}
