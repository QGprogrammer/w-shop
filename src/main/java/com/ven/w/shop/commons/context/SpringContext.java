package com.ven.w.shop.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 上下文
 * @author wangwenwen
 * @date 2020/2/20 16:08
 * @version v1.0.0
 */
public final class SpringContext {
    public static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

}
