package com.test.strategy.service;

/**
 * @description 编写具体策略类，具体策略中实现接口的方法，返回 add 操作结果
 * @date 2019/12/19 16:05
 */
public class AddStrategy implements Strategy {

    @Override
    public String operateStr(String a, String b) {
        return a + "+" + b;
    }
}
