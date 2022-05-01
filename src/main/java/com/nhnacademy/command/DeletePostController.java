package com.nhnacademy.command;

import com.nhnacademy.post.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePostController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String postId = request.getParameter("id");
        PostRepository postRepository = (PostRepository) request.getServletContext().getAttribute("repository");
        for (int i = 0; i < postRepository.getPosts().size(); i++) {
            if( (int) postRepository.getPosts().get(i).getId() == Integer.parseInt(postId)){
                postRepository.getPosts().remove(i);
            }
        }
        request.getServletContext().setAttribute("repository",postRepository);
        return "/home/board.jsp";
    }
}
