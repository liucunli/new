package com.news.service;

import com.news.model.Question;
import com.news.model.res.RespCode;

import java.util.List;

public interface QuestionService {
    public List<Question> getAllQuestion();
    public RespCode setQuestion(Question question);
}
