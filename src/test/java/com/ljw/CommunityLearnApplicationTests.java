package com.ljw;

import com.ljw.dao.AlphaDao;
import com.ljw.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

// 自动创建spring ioc容器，扫描包，装配bean
@SpringBootTest
@ContextConfiguration(classes = CommunityLearnApplication.class)
class CommunityLearnApplicationTests implements ApplicationContextAware {

    private ApplicationContext context; // 记录容器

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Test
    void contextLoads() {
        System.out.println(context);
        AlphaDao bean = context.getBean(AlphaDao.class);
        System.out.println(bean.select());

        bean = context.getBean("alphaHibernates", AlphaDao.class);
        System.out.println(bean.select());
    }

    @Test
    public void testBeanManagement() {
        AlphaService alphaService = context.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = context.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat bean = context.getBean(SimpleDateFormat.class);
        System.out.println(bean.format(new Date()));
    }


    // 依赖注入，不必获取context，可以直接autowired自动装配
    @Autowired
    @Qualifier("alphaHibernates") // 装配指定名字的bean
    private AlphaDao alphaDao;

    @Autowired
    private SimpleDateFormat sdf;

    @Autowired
    private AlphaService alphaService;

    @Test
    public void testDI() {
        System.out.println(alphaDao);
        System.out.println(sdf);
        System.out.println(alphaService);
    }
}
