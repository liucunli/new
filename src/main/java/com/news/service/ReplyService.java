package com.news.service;

import com.news.model.Reply;
import com.news.model.req.Qid;
import com.news.model.res.RespCode;
import com.news.model.res.RespReplyNum;

import java.util.List;

public interface ReplyService {
    public RespCode setReply(Reply reply);
    public RespReplyNum getCountByQid(Qid qid);
    public List<Reply> getReply(Qid qid);
}
