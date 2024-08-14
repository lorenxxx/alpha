package com.clawchat.alpha.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 CREATE TABLE `t_demo` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(200) COMMENT '姓名',
    `age` tinyint COMMENT '年龄',
    `phone` varchar(20) COMMENT '电话',
    PRIMARY KEY (`id`),
    UNIQUE KEY uidx_name(`name`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='demo表';
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Demo {

    private Integer id;

    private String name;

    private Integer age;

    private String phone;

}
