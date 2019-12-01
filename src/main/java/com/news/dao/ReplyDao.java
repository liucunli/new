package com.news.dao;

import com.news.model.Reply;
import com.news.model.req.Qid;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ReplyDao extends Repository<Reply,String> {
    List<Reply> getAllByQid(Integer qid);
    Integer countAllByQid(Integer qid);
}
