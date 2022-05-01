package com.nhnacademy.post;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class Repository implements PostRepository{
    ArrayList<Post> arrayList = new ArrayList<>();
    long postId = 0;
    @Override
    public long register(Post post) {
        if (!ObjectUtils.isEmpty(post.getId())){
            postId++;
            post.setId(postId);
            arrayList.add(post);
        }
        return postId;
    }

    @Override
    public void modify(Post post) {
    }

    @Override
    public Post remove(long id) {
        return null;
    }

    @Override
    public Post getPost(long id) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getId() == id){
                return arrayList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return arrayList;
    }
}
