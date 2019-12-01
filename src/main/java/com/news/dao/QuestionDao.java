package com.news.dao;

import com.news.model.Question;
import com.news.model.req.Search;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface QuestionDao extends Repository<Question,String> {
   List<Question> getAllByTitleContaining(String str);
}
