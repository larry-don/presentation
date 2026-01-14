package com.example.presentation.gzip;

/**
 * @Description: 本类用于
 * @Author larry
 * @Date 2024/2/1 9:30
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 解压filter
 */
@Slf4j
@Component
public class GzipFilter implements Filter {

    private static final String CONTENT_ENCODING = "Content-Encoding";

    private static final String CONTENT_ENCODING_TYPE = "application/gzip";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init GzipFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String encodeType = httpServletRequest.getHeader(CONTENT_ENCODING);
        if ("gzip".equals(encodeType)) {
            log.info("请求:{} 需要解压", httpServletRequest.getRequestURI());
            UnZipRequestWrapper unZipRequest = new UnZipRequestWrapper(httpServletRequest);
            chain.doFilter(unZipRequest, response);
        } else {
            log.info("请求:{} 无需解压", httpServletRequest.getRequestURI());
            chain.doFilter(request, response);
        }
        log.info("耗时：{}ms", System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {
        log.info("destroy GzipFilter");
    }
}
