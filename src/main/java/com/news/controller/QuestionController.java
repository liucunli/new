package com.news.controller;

import com.news.model.Question;
import com.news.model.res.RespCode;
import com.news.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController{

    @Autowired
    private QuestionService questionService;

    @PostMapping("/question")
    public RespCode setQuestion(@RequestBody Question question){
        return questionService.setQuestion(question);
    }

    @PostMapping("/getAllQuestion")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

}
