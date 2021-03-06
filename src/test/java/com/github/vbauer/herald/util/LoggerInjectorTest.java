package com.github.vbauer.herald.util;

import com.github.vbauer.herald.ext.spring.bean.ClassLogBean;
import com.github.vbauer.herald.ext.spring.bean.IncorrectLogBean;
import com.github.vbauer.herald.ext.spring.bean.LogBean;
import com.github.vbauer.herald.ext.spring.bean.NamedLogBean;
import com.github.vbauer.herald.core.BasicTest;
import com.github.vbauer.herald.exception.MissedLogFactoryException;
import com.github.vbauer.herald.logger.ClassLogBeanTest;
import com.github.vbauer.herald.logger.LogBeanTest;
import com.github.vbauer.herald.logger.NamedLogBeanTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vadislav Bauer
 */

public class LoggerInjectorTest extends BasicTest {

    @Test
    public void testConstructorContract() throws Exception {
        checkUtilConstructorContract(LoggerInjector.class);
    }

    @Test(expected = MissedLogFactoryException.class)
    public void testIncorrectLogger() {
        Assert.fail(LoggerInjector.inject(new IncorrectLogBean()).toString());
    }

    @Test
    public void testSynthetic() {
        final IncorrectLogBean bean = new IncorrectLogBean();
        Assert.assertNotNull(LoggerInjector.inject(bean.new SyntheticTestClass()));
    }

    @Test
    public void testNoOneLogger() {
        Assert.assertNotNull(LoggerInjector.inject(new IncorrectLogBean.EmptyTestClass()));
    }

    @Test
    public void testFewBeans() {
        final ClassLogBean classLogBean = new ClassLogBean();
        final LogBean logBean = new LogBean();
        final NamedLogBean namedLogBean = new NamedLogBean();

        Assert.assertEquals(3, LoggerInjector.inject(classLogBean, logBean, namedLogBean).size());

        ClassLogBeanTest.check(classLogBean);
        LogBeanTest.check(logBean);
        NamedLogBeanTest.check(namedLogBean);
    }

    @Test
    public void testZeroBeans() {
        Assert.assertTrue(LoggerInjector.inject().isEmpty());
    }

}
