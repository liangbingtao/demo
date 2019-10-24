package com.liangbingtao.demo.controller;

import com.liangbingtao.demo.dto.CommentDTO;
import com.liangbingtao.demo.dto.ResultDTO;
import com.liangbingtao.demo.exception.CustomizeErrorCode;
import com.liangbingtao.demo.mapper.CommentMapper;
import com.liangbingtao.demo.model.Comment;
import com.liangbingtao.demo.model.User;
import com.liangbingtao.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value="/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){

       User user= (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
