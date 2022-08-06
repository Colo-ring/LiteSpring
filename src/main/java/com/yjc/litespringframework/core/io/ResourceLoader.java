package com.yjc.litespringframework.core.io;

/**
 * @author IntelliYJC
 * @create 2022/8/4 17:16
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
