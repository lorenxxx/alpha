package com.clawchat.alpha.mapper;

import com.clawchat.alpha.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDemoMapper {

    void insert(Demo demo);

    Integer deleteById(Integer id);

    Integer update(Demo demo);

    Demo getById(Integer id);

    Demo getByName(String name);

}
