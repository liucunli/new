package com.news.service;

import com.news.model.Question;
import com.news.model.req.Search;

import java.util.List;

public interface SearchService {
    public List<Question> getQuestion(Search search);
    List<Question> getNewQuestion();
    List<Question> getHotQuestion();
    List<Question> getHot7Question();
    List<Question> getHot30Question();
}
