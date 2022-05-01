package com.nhnacademy.command;

import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


public class LangController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Optional.ofNullable(request.getParameter("lang"))
                .ifPresent(lang -> request.getServletContext().setAttribute("lang", lang));
        if (!ObjectUtils.isEmpty(request.getParameter("jsp"))){
            return "redirect:"+request.getParameter("jsp");
        }
        return "redirect:/";
    }
}
