package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//声明该注解作用在方法上
@Retention(RetentionPolicy.RUNTIME)//声明有效的时长
public @interface LoginRequired {

}
