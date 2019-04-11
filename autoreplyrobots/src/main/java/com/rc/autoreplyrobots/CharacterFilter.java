package com.rc.autoreplyrobots;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName CharacterFilter
 * @Description TODO
 * @Author liux
 * @Date 19-4-11 上午9:55
 * @Version 1.0
 */
public class CharacterFilter implements Filter {

    private String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
