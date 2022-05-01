package com.nhnacademy.filter;

import com.nhnacademy.util.WhiteListUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "*.do", initParams = {
        @WebInitParam(name = "whitelist", value = "/login.do")
})
public class LoginCheckFilter implements Filter {
    private List<String> whitelists;
    private static final String DEFAULT_LOGIN_PAGE="/login.do";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        whitelists = WhiteListUtils.toList(filterConfig.getInitParameter("whitelist"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(whitelists.contains(req.getRequestURI())){
            chain.doFilter(request,response);
        }else{
            HttpSession session = req.getSession(false);
            if(session == null){
                res.sendRedirect(DEFAULT_LOGIN_PAGE);
            }else{
                String id = (String) session.getAttribute("id");
                if(StringUtils.isEmpty(id)){
                    res.sendRedirect(DEFAULT_LOGIN_PAGE);
                }else{
                    chain.doFilter(request,response);
                }
            }
        }
        /*
        if (whitelists.contains(req.getRequestURI()) || req.getRequestURI().equals("/")) {
            HttpSession session = req.getSession(false);
            if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
               // RequestDispatcher rd = request.getRequestDispatcher("/login.do");
               // rd.forward(request, response);
                res.sendRedirect("/login.do");
            }
            if (Objects.nonNull(session) && Objects.nonNull(session.getAttribute("id"))) {
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
                chain.doFilter(request, response);
            }

        }*/

    }
}
