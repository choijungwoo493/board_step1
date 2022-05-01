package com.nhnacademy.command;

import com.nhnacademy.user.Guest;
import com.nhnacademy.user.User;
import org.apache.commons.collections4.CollectionUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CheckGuestInfoChangeController implements Command{
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
            arrayList.add(new Guest(id,pwd,name));
            servletContext.setAttribute("memberList",arrayList);
            return "/message/changeInfoSuccess.jsp";
        }
        return "/message/changeInfoFail.jsp";
    }
}
