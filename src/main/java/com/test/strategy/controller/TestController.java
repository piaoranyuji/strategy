package com.test.strategy.controller;

import com.test.strategy.service.StrategyFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 策略模式测试类
 * @date 2019/12/19 14:41
 */
@RestController
@Slf4j
public class TestController {

    /**
     * if-else 方式实现的两个字符串的不同拼接方法
     *
     * @param a        字符串a
     * @param b        字符串b
     * @param operator 操作规则
     * @return 处理后的字符串
     */
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1(String a, String b, String operator) {
        log.info("test1接收参数：a={};b={};operator={}", a, b, operator);

        String result;

        if ("add".equals(operator)) {
            result = a + "+" + b;
        } else if ("subtract".equals(operator)) {
            result = a + "-" + b;
        } else if ("multiply".equals(operator)) {
            result = a + "*" + b;
        } else if ("divide".equals(operator)) {
            result = a + "/" + b;
        } else {
            result = "不合法的操作符";
        }
        return result;
    }

    /**
     * switch 语句实现的两个字符串的不同拼接方法
     *
     * @param a        字符串a
     * @param b        字符串b
     * @param operator 操作规则
     * @return 处理后的字符串
     */
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(String a, String b, String operator) {
        log.info("test2接收参数：a={};b={};operator={}", a, b, operator);

        String result;

        switch (operator) {
            case "add":
                result = a + "+" + b;
                break;
            case "subtract":
                result = a + "-" + b;
                break;
            case "multiply":
                result = a + "*" + b;
                break;
            case "divide":
                result = a + "/" + b;
                break;
            default:
                result = "不合法的操作符";
                break;
        }
        return result;
    }

    /**
     * 策略模式+工厂模式 实现的两个字符串的不同拼接方法
     *
     * @param a        字符串a
     * @param b        字符串b
     * @param operator 操作规则
     * @return 处理后的字符串
     */
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    public String test3(String a, String b, String operator) {
        log.info("test3接收参数：a={};b={};operator={}", a, b, operator);

        return StrategyFacade.doOperate(a, b, operator);
    }
}
