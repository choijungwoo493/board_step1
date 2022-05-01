package com.nhnacademy.initializer;

import com.nhnacademy.post.Post;
import com.nhnacademy.post.PostRepository;
import com.nhnacademy.post.Repository;
import com.nhnacademy.user.User;

import java.util.ArrayList;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
        javax.servlet.Servlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ctx.setInitParameter("counterFile", "counter.dat");
        ctx.setAttribute("lang", "ko");
        ctx.setAttribute("memberList", new ArrayList<User>());
        ctx.setAttribute("repository", new Repository());

    }

}
