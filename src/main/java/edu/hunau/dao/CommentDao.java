package edu.hunau.dao;

import edu.hunau.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    /**
     * 添加一条评论
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 给一条评论点赞
     * (comment_like++)
     * @param commentId
     */
    void addCommentLike(Integer commentId);

    /**
     * 取消给这个评论点赞
     * @param commentId
     */
    void cancelCommentLike(Integer commentId);

    /**
     * 删除一条评论
     * @param commentId
     */
    void deleteComment(Integer commentId);

    /**
     * 获取单条评论
     * @param commentId
     * @return
     */
    Comment getComment(Integer commentId);

    /**
     * 根据answer_id获取所有评论
     * @param answerId
     * @return
     */
    List<Comment> getCommentsByAnswer(Integer answerId);

    /**
     * 根据answer_id获取该评论的点赞总数
     * @param answerId
     * @return
     */
    Integer getLikesNum(Integer answerId);
}
