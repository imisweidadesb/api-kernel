package com.zj.api.kernel.common.util.test;

import com.zj.api.kernel.common.util.pinyin.Pinyin4jUtil;
import org.junit.Test;

/**
 * Created by js on 2017/1/18.
 */
public class Pinyin4jUtilTest {

    @Test
    public void testSimpleName() {
        System.out.println(Pinyin4jUtil.converterToFirstSpell("比亚迪"));
    }
}
