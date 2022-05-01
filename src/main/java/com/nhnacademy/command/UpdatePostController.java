package com.nhnacademy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePostController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/board/changePost.jsp?id=" + request.getParameter("id");
    }
}
