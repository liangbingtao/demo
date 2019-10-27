package com.liangbingtao.demo.mapper;

import com.liangbingtao.demo.model.Comment;
import com.liangbingtao.demo.model.CommentExample;
import com.liangbingtao.demo.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}