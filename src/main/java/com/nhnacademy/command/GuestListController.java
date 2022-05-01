package com.nhnacademy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestListController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //매니저가 아니면 접속이 불가능하므로 세션을 통한 추가 작업 x

        return "/user/list.jsp";
    }
}
