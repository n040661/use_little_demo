package com.aohuan.demo.annotation_test.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dodo in Administrator on 2015/9/7.
 * qq  2390183798
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AhView1 {
    int intR();
}