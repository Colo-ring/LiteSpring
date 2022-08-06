package com.yjc.litespringframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author IntelliYJC
 * @create 2022/8/4 16:36
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
