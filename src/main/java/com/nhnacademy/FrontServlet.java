package com.nhnacademy;

import com.nhnacademy.command.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command  = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);
            log.error(req.getRequestURI());

            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                resp.sendRedirect(view);
            }
        } catch (Exception ex) {
            log.error("", ex);

            req.setAttribute("exception", ex);

            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;
        log.error(servletPath);

        if ("/index.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new IndexController();
        } else if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginFormController();
        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginProcessingController("manager", "12345");
        } else if ("/logout.do".equals(servletPath)) {
            command = new LogoutController();
        } else if ("/change-lang.do".equals(servletPath)) {
            command = new LangController();
        } else if ("/manager_home.do".equals(servletPath)){
            command = new ManagerHomeController();
        } else if ("/guest_list.do".equals(servletPath)){
            command = new GuestListController();
        } else if ("/add_user.do".equals(servletPath)){
            command = new GuestRegisterController();
        } else if ("/delete_user_info.do".equals(servletPath)){
            command = new GuestInfoDeleteController();
        } else if ("/modify_user_info.do".equals(servletPath)){
            command = new GuestInfoChangeController();
        }  else if ("/add_user_info_check.do".equals(servletPath)){
            command = new CheckGuestInfoController();
        } else if (servletPath.startsWith("/view_user_info") && "GET".equalsIgnoreCase(method)){
            command = new GuestInfoController();
        }  else if ("/change_user_info_check.do".equals(servletPath)){
            command = new CheckGuestInfoChangeController();
        }  else if ("/member_home.do".equals(servletPath)){
            command = new MemberHomeController();
        }else if ("/write.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new WriteController();
        }else if ("/write.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
            command = new WriteRegisterController();
        } else if ("/view_post.do".equals(servletPath)){
            command = new ViewPostController();
        } else if ("/update_post.do".equals(servletPath)){
            command = new UpdatePostController();
        } else if ("/delete_post.do".equals(servletPath)){
            command = new DeletePostController();
        } else if ("/change_post.do".equals(servletPath)){
            command = new ChangePostController();
        } else if ("/view_user_post_list.do".equals(servletPath)){
            log.error("d여기에 걸리나요?");
            command = new GuestInfoController();
        }



        return command;
    }

}
