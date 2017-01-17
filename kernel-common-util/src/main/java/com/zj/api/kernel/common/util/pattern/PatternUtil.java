package com.zj.api.kernel.common.util.pattern;

import com.zj.api.kernel.common.util.pattern.constant.PatternConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by js on 2017/1/17.
 */
public class PatternUtil {

    public static boolean checkStr(String context) {
        Pattern pattern = Pattern.compile(PatternConstant.stockCodes);
        Matcher matcher = pattern.matcher(context);
        return matcher.matches();
    }
}
