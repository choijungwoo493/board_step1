package com.nhnacademy.command;

import com.nhnacademy.user.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Slf4j
public class GuestInfoController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<User> arrayList = (ArrayList<User>)request.getServletContext().getAttribute("memberList");

        String name = request.getParameter("name");
        if(!ObjectUtils.isEmpty(arrayList)) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getName().equals(name)) {
                    return "user/userInfo.jsp?" + request.getQueryString();
                }
            }
        }
        return "home/board.jsp";
    }
}
