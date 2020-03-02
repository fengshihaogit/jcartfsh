package com.fsh.jcartadministrationback.filter;

import com.fsh.jcartadministrationback.constant.ClientExceptionConstant;
import com.fsh.jcartadministrationback.exception.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/**
 * @author Mr.Blake
 * @create 2020-03-02 23:39
 */
@Order(1)
@Component
public class StaticResourceFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${static.resource.extensions}")
    private Set<String> extensions;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String method = request.getMethod();
        final String requestURI = request.getRequestURI();
        logger.info("method request uri: {} {}", method, requestURI);

        final String[] strings = requestURI.split("\\.");
        String ext = strings[strings.length - 1];
        ext = ext.toLowerCase();
        if (extensions.contains(ext)){
            throw new ClientException(ClientExceptionConstant.NOT_SUPPORT_STATIC_RESOURCE_ERRCODE,ClientExceptionConstant.NOT_SUPPORT_STATIC_RESOURCE_ERRMSG);
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }
}
