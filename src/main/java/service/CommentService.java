package service;

import po.Comment;

import java.util.List;

public interface CommentService {
    int insertComment(Integer taskId, Integer fromUid, Integer ToUid, String content);

    int deleteComment(Integer commentId);

    List<Comment> getAllComments(Integer fromUid);

    List<Comment> getTaskComments(Integer taskId);
}
