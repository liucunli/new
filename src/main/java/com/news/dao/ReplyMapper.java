package com.news.dao;

import com.news.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface ReplyMapper   extends JpaRepository<Reply, Integer>, JpaSpecificationExecutor<Reply>, Serializable {

}
