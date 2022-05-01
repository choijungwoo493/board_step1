package com.nhnacademy.command;

import com.nhnacademy.post.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewPostController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        PostRepository postRepository = (PostRepository) request.getServletContext().getAttribute("repository");
        for (int i = 0; i < postRepository.getPosts().size(); i++) {
            if(postRepository.getPosts().get(i).getId() == (Integer.parseInt(request.getParameter("id")))){
                postRepository.getPosts().get(i).increaseViewCount();
            }
        }
        request.getServletContext().setAttribute("repository",postRepository);
        return "/board/post.jsp?"+request.getQueryString();
    }
}
