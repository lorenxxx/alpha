package com.clawchat.alpha.mapper;

import com.clawchat.alpha.entity.Demo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IDemoMapper {

    Demo getByID(Integer id);

}
