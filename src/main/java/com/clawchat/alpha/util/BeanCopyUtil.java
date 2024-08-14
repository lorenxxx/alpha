package com.clawchat.alpha.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class BeanCopyUtil {

    /**
     * 复制对象
     *
     * @param source      源对象
     * @param targetClazz 目标对象Class类型
     * @return 目标对象
     */
    public static <S, T> T copy(S source, Class<T> targetClazz) {
        if (source == null) {
            return null;
        }

        T target;
        try {
            target = targetClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        BeanUtils.copyProperties(source, target);

        return target;
    }

    /**
     * 复制对象集合
     *
     * @param sources     源对象集合
     * @param targetClazz 目标对象Class类型
     * @return 目标对象集合
     */
    public static <S, T> List<T> copy(List<S> sources, Class<T> targetClazz) {
        if (CollectionUtils.isEmpty(sources)) {
            return Lists.newArrayList();
        }

        List<T> targets = Lists.newArrayList();
        sources.forEach((source) -> {
            T target = copy(source, targetClazz);
            if (target != null) {
                targets.add(target);
            }

        });
        return targets;
    }


}
