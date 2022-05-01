package com.nhnacademy.filter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.nhnacademy.domain.Counter;
import com.nhnacademy.util.WhiteListUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "counterFilter", urlPatterns = "*.do", initParams = {
        @WebInitParam(name = "whitelist", value = "/foods.do\n/cart.do")
})
public class CounterFilter implements Filter {
    private List<String> whitelists;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whitelists = WhiteListUtils.toList(filterConfig.getInitParameter("whitelist"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (whitelists.contains(((HttpServletRequest) request).getRequestURI())) {
            synchronized (request.getServletContext()) {
                increaseCounter(request.getServletContext());
            }
        }

        chain.doFilter(request, response);
    }

    private void increaseCounter(ServletContext servletContext) {
        Integer counter = Optional.ofNullable(servletContext.getAttribute(Counter.COUNTER))
                .map(Integer.class::cast)
                .orElse(0);

        log.info("counter={}", ++counter);

        servletContext.setAttribute(Counter.COUNTER, counter);
    }

}
