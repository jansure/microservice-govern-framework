package com.test.spring.cloud.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;

/**
 * 动态加载过滤器
 * @author pkpm
 *
 */
@Component
public class GroovyLoadLineRunner implements CommandLineRunner {
private Logger logger = LoggerFactory.getLogger(getClass());
 
    @Value("${zuul.groovy.path}")
    private String groovyPath;
    
    @Value("${zuul.groovy.interval}")
    private int interval;
 
    @Override
    public void run(String... args) throws Exception {
        MonitoringHelper.initMocks();
        FilterLoader.getInstance().setCompiler(new GroovyCompiler());
        try {
            FilterFileManager.setFilenameFilter(new GroovyFileFilter());
            logger.info(groovyPath);
            FilterFileManager.init(interval, groovyPath + "pre", groovyPath + "post");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
