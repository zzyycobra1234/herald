package com.github.vbauer.herald.logger;

import com.github.vbauer.herald.ext.spring.bean.NamedLogBean;
import com.github.vbauer.herald.ext.spring.core.BasicSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Vladislav Bauer
 */

public class NamedLogBeanTest extends BasicSpringTest {

    @Autowired
    private NamedLogBean namedLogBean;


    @Test
    public void testNamedLogBean() {
        check(namedLogBean);
    }


    public static void check(final NamedLogBean bean) {
        Assert.notNull(NamedLogBean.getStaticJavaUtilLogger());
        Assert.notNull(bean.getJavaUtilLogger());
        Assert.notNull(bean.getCommonsLoggingLogger());
        Assert.notNull(bean.getLogbackLogger());
        Assert.notNull(bean.getSlf4jLogger());
        Assert.notNull(bean.getSlf4jExtLogger());
        Assert.notNull(bean.getLog4jLogger());
        Assert.notNull(bean.getLog4j2Logger());
        Assert.notNull(bean.getJBossLogger());
        Assert.notNull(bean.getSyslog4jLogger());
        Assert.notNull(bean.getSyslog4jGraylogLogger());
        Assert.notNull(bean.getFluentLogger());
    }

}
