package com.news.controller;

import com.news.model.Question;
import com.news.model.req.Search;
import com.news.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/search")
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    public List<Question> getQuestions(@RequestBody Search search){
        return searchService.getQuestion(search);
    }

    @PostMapping("/new")
    public List<Question> getNewQuestions(){
        return searchService.getNewQuestion();
    }

    @PostMapping("/hot")
    public List<Question> getHotQuestions(){
        return searchService.getHotQuestion();
    }

    @PostMapping("/hot7")
    public List<Question> getHot7Questions(){
        return searchService.getHot7Question();
    }

    @PostMapping("/hot30")
    @CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    public List<Question> getHot30Questions(){
        return searchService.getHot30Question();
    }
}
