package com.news.service.impl;

import com.news.conf.CodeList;
import com.news.dao.QuestionMapper;
import com.news.model.Question;
import com.news.model.res.RespCode;
import com.news.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getAllQuestion() {
        List<Question> questionList;
        questionList = questionMapper.findAll();
        return questionList;
    }

    @Override
    public RespCode setQuestion(Question question) {
        RespCode respCode = new RespCode();

        if(question != null && question instanceof Question){
            if(question.getTitle() != null && question.getUid() != null){
                questionMapper.save(question);
                respCode.setCode(CodeList.SUCCESS);
            } else {
                respCode.setCode(CodeList.FAILED);
            }

        } else {
            respCode.setCode(CodeList.UNKNOWN_FAILED);
        }
        return respCode;
    }
}
