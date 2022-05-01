package com.nhnacademy.command;

import com.nhnacademy.user.Guest;
import com.nhnacademy.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Slf4j
public class CheckGuestInfoController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        if (!request.getParameter("userId").isEmpty() && !request.getParameter("userPwd").isEmpty() && !request.getParameter("userName").isEmpty()){
            String id = request.getParameter("userId");
            String pwd = request.getParameter("userPwd");
            String name = request.getParameter("userName");
            ArrayList<User> arrayList = (ArrayList<User>) servletContext.getAttribute("memberList");
            if (CollectionUtils.isEmpty(arrayList)){
                arrayList = new ArrayList<User>();
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i).getId().equals(id)){
                    return "/message/registerFail.jsp?message=duplicatedId";
                }
            }
            arrayList.add(new Guest(id,pwd,name));
            servletContext.setAttribute("memberList",arrayList);
            return "/message/registerSuccess.jsp";
        }
        return "/message/registerFail.jsp";
    }
}
