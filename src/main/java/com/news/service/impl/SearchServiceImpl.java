package com.news.service.impl;

import com.news.dao.QuestionDao;
import com.news.model.Question;
import com.news.model.req.Search;
import com.news.service.QuestionService;
import com.news.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Question> getQuestion(Search search) {
        List<Question> questionList;
        questionList = questionDao.getAllByTitleContaining(search.getStr());
        return questionList;
    }

    @Override
    public List<Question> getNewQuestion() {
        List<Question> questionList = new ArrayList<>();
        return questionList;
    }

    @Override
    public List<Question> getHotQuestion() {
        List<Question> questionList = new ArrayList<>();
        return questionList;
    }

    @Override
    public List<Question> getHot7Question() {
        List<Question> questionList = new ArrayList<>();
        return questionList;
    }

    @Override
    public List<Question> getHot30Question() {
        List<Question> questionList = new ArrayList<>();
        return questionList;
    }
}
