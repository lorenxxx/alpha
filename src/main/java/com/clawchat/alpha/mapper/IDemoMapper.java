package com.clawchat.alpha.mapper;

import com.clawchat.alpha.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IDemoMapper {

    void insert(Demo demo);

    Integer deleteById(Integer id);

    Integer update(Demo demo);

    Demo getById(Integer id);

    List<Demo> queryByIds(List<Integer> ids);

}
