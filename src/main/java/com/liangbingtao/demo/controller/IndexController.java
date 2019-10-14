package com.liangbingtao.demo.controller;

import com.liangbingtao.demo.dto.PaginationDTO;
import com.liangbingtao.demo.dto.QuestionDTO;
import com.liangbingtao.demo.mapper.QuestionMapper;
import com.liangbingtao.demo.mapper.UserMapper;
import com.liangbingtao.demo.model.Question;
import com.liangbingtao.demo.model.User;
import com.liangbingtao.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) { //size为页面中展示的问题的数量
        PaginationDTO pagination = questionService.list(page, size);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
