package com.test.spring.cloud.filter;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

/**
 * 同一处理异常信息
 * @author pkpm
 *
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> result = super.getErrorAttributes(requestAttributes, includeStackTrace);
        result.put("status", 500);
        result.put("error", "error");
        result.put("exception", "exception");
        result.put("message", "do it later!!");
        return result;
    }
}