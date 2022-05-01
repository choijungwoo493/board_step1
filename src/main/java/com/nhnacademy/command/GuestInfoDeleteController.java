package com.nhnacademy.command;

import com.nhnacademy.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GuestInfoDeleteController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<User> arrayList = (ArrayList<User>)request.getServletContext().getAttribute("memberList");

        String name = request.getParameter("name");
        String pwd =  request.getParameter("pwd");
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getName().equals(name) && arrayList.get(i).getPassword().equals(pwd)){
                arrayList.remove(i);
            }
        }
        request.getServletContext().setAttribute("memberList",arrayList);
        return "/user/list.jsp";
    }
}
