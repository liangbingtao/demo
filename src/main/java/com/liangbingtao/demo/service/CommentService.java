package com.liangbingtao.demo.service;

import com.liangbingtao.demo.enums.CommentTypeEnum;
import com.liangbingtao.demo.exception.CustomizeErrorCode;
import com.liangbingtao.demo.exception.CustomizeException;
import com.liangbingtao.demo.mapper.CommentMapper;
import com.liangbingtao.demo.mapper.QuestionMapper;
import com.liangbingtao.demo.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public void insert(Comment comment) {
        if(comment.getParentId() == null || comment.getParentId() == 0){
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if(comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())){
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if(comment.getType() == CommentTypeEnum.COMMENT.getType()){
            //回复评论
            Comment dbcomment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbcomment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        }else{
            questionMapper.selectByPrimaryKey(comment.getParentId());
            //回复问题
        }
    }
}
