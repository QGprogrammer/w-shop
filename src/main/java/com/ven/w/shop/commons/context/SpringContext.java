package com.ven.w.shop.commons.context;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring 上下文
 * @author wangwenwen
 * @date 2020/2/20 16:08
 * @version v1.0.0
 */
public final class SpringContext implements ApplicationContextAware, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static ApplicationContext applicationContext;

    /**
     * 根据beanid获取bean
     * @param beanId
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanId) {
        assertContextInjected();
        return (T) applicationContext.getBean(beanId);
    }

    /**
     * 根据Class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    @Override
    public void destroy() throws Exception {
        logger.debug("清空ApplicationContext");
        SpringContext.applicationContext = null;
    }

    /**
     * 断言context是否空
     */
    private static void assertContextInjected() {
        boolean a = applicationContext == null;
        Validate.validState(applicationContext != null, "未在spring-context.xml中配置SpringContext对象");
    }
}
