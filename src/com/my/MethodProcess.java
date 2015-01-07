package com.my;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@interface MethodProcess {
    boolean display() default true;
    
    //Value value();//这样定义的注解编译失败
}

class Value{
}