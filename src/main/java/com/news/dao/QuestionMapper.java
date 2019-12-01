package com.news.dao;

import com.news.model.Question;
import com.news.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface QuestionMapper  extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question>, Serializable {
}
