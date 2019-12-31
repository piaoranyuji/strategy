package com.test.strategy.service;

import com.test.strategy.bean.OperatorEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * @description 创建工厂方法，创建具体策略类
 * @date 2019/12/19 20:14
 */
@Slf4j
public class StrategyFacade {

    /**
     * 根据 operator 生成实际的操作策略，执行对应的方法
     *
     * @param a        字符串a
     * @param b        字符串b
     * @param operator 操作规则
     * @return 处理后的字符串
     */
    public static String doOperate(String a, String b, String operator) {
        Strategy strategy;

        try {
            strategy = (Strategy) Class.forName(getStrategyType(operator).getvalue()).newInstance();

            return strategy.operateStr(a, b);
        } catch (Exception e) {
            log.error("生成操作策略出现异常", e);

            return "不合法的操作符";
        }
    }

    /**
     * 根据不同 operator 值生成不同的策略（策略场景变化时需要修改）
     *
     * @param operator 操作规则
     * @return OperatorEnum 枚举对象
     */
    private static OperatorEnum getStrategyType(String operator) {
        if ("add".equals(operator)) {
            return OperatorEnum.ADD;
        } else if ("subtract".equals(operator)) {
            return OperatorEnum.SUBTRACT;
        } else if ("multiply".equals(operator)) {
            return OperatorEnum.MULTIPLY;
        } else if ("divide".equals(operator)) {
            return OperatorEnum.DIVIDE;
        } else {
            return null;
        }
    }
}
