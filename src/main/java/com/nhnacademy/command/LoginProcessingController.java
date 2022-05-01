package com.nhnacademy.command;

import com.nhnacademy.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Slf4j
public class LoginProcessingController implements Command {
    private final String idInitParam;
    private final String pwdInitParam;

    public LoginProcessingController(String idInitParam, String pwdInitParam) {
        this.idInitParam = idInitParam;
        this.pwdInitParam = pwdInitParam;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        if (id != null && pwd != null && id.equals(idInitParam) && pwd.equals(pwdInitParam)) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            session.setAttribute("position", "manager");

            return "redirect:/login.do";

        } else if (id != null && pwd != null) {
            HttpSession session = request.getSession();
            ArrayList<User> arrayList = (ArrayList<User>)request.getServletContext().getAttribute("memberList");
            if (!CollectionUtils.isEmpty(arrayList)) {
                // 서블릿 컨텍스트의 멤버어레이 리스트를 돌아서 아이디와 비밀번호가 일치하는게 있으면 세션 추가 후 리다이렉션
                for (User user : arrayList) {
                    if (user.getId().equals(id) && user.getPassword().equals(pwd)) {

                        session.setAttribute("id", id);
                        session.setAttribute("position", "guest");
                        return "redirect:/login.do";
                    }
                }

            }
            return "login/loginForm.jsp";

        } else {

            return "login/loginForm.jsp";
        }
    }
}
