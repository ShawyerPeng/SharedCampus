package service.impl;

import mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Comment;
import service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int insertComment(Integer taskId, Integer fromUid, Integer toUid, String content) {
        Comment comment = new Comment(taskId, fromUid, toUid, content);
        return commentMapper.insert(comment);
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentMapper.deleteByPrimaryKey(commentId);
    }

    @Override
    public List<Comment> getAllComments(Integer fromUid) {
        return commentMapper.selectByFromUid(fromUid);
    }

    @Override
    public List<Comment> getTaskComments(Integer taskId) {
        return commentMapper.selectByTaskId(taskId);
    }

}
