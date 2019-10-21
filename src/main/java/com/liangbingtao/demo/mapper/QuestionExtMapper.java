package com.liangbingtao.demo.mapper;

import com.liangbingtao.demo.model.Question;
import com.liangbingtao.demo.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
}