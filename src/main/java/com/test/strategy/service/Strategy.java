package com.test.strategy.service;

/**
 * @description 定义策略接口，后面所有策略要实现它
 * @date 2019/12/19 16:00
 */
public interface Strategy {

    String operateStr(String a, String b);
}
