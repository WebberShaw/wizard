package edu.hunau.service.impl;

import edu.hunau.model.Comment;
import edu.hunau.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void addCommentLike(Integer commentId) {

    }

    @Override
    public void cancelCommentLike(Integer commentId) {

    }

    @Override
    public void deleteComment(Integer commentId) {

    }

    @Override
    public Comment getComment(Integer commentId) {
        return null;
    }

    @Override
    public List<Comment> getCommentsByAnswer(Integer answerId) {
        return null;
    }

    @Override
    public Integer getLikesNum(Integer answerId) {
        return null;
    }
}
