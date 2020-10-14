package com.Jaziel.anno;

import org.springframework.stereotype.Component;

/**
 * @author 王杰
 * @time 2020/9/29 14:58
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running...");
    }
}
