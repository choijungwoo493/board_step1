package com.nhnacademy.command;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MemberHomeController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        log.error("여기는 된다");
        return "/home/board.jsp";
    }
}
