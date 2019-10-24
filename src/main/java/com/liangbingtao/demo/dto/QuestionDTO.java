package com.liangbingtao.demo.dto;

import com.liangbingtao.demo.model.User;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private User user;
}
