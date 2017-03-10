package com.fj.robot;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by linyu on 2016/8/5.
 */
public class RobotTest {
    @Test
    public void test(){
        String result = Robot.xiaodoubi("笑话");
        Assert.assertNotNull(result);
    }
}
