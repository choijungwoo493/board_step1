package com.nhnacademy.command;

import com.nhnacademy.post.ConcretePost;
import com.nhnacademy.post.Post;
import com.nhnacademy.post.PostRepository;
import com.nhnacademy.post.Repository;
import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class ChangePostController implements Command{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        LocalDateTime localDateTime = LocalDateTime.now();
        PostRepository repository = (Repository) request.getServletContext().getAttribute("repository");
        Post post = new ConcretePost(title,content,userId,localDateTime,0);

        if (ObjectUtils.isEmpty(repository)){
            repository = new Repository();
        }
        repository.register(post);
        request.getServletContext().setAttribute("repository",repository);

        return "/home/board.jsp";
    }
}
