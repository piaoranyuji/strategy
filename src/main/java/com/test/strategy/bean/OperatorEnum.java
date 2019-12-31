package com.test.strategy.bean;

/**
 * @description 定义枚举类，枚举不同的操作规则
 * @date 2019/12/19 19:37
 */
public enum OperatorEnum {

    ADD("com.test.strategy.service.AddStrategy"),
    SUBTRACT("com.test.strategy.service.AddStrategy"),
    MULTIPLY("com.test.strategy.service.AddStrategy"),
    DIVIDE("com.test.strategy.service.DivideStrategy");

    String value;

    OperatorEnum(String value) {
        this.value = value;
    }

    public String getvalue() {
        return this.value;
    }
}
