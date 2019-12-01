package com.news.service.impl;

import com.news.conf.CodeList;
import com.news.dao.ReplyDao;
import com.news.dao.ReplyMapper;
import com.news.model.Reply;
import com.news.model.req.Qid;
import com.news.model.res.RespCode;
import com.news.model.res.RespReplyNum;
import com.news.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Autowired
    private ReplyDao replyDao;

    @Override
    public RespCode setReply(Reply reply){
        RespCode respCode = new RespCode();

        if(reply != null && reply instanceof Reply){
            if(reply.getWord() != null){
                replyMapper.save(reply);
                respCode.setCode(CodeList.SUCCESS);
            } else {
                respCode.setCode(CodeList.FAILED);
            }
        } else {
            respCode.setCode(CodeList.UNKNOWN_FAILED);
        }
        replyMapper.save(reply);

        return respCode;
    }

    @Override
    public RespReplyNum getCountByQid(Qid qid) {
        RespReplyNum respReplyNum = new RespReplyNum();

        Integer num;
        num = replyDao.countAllByQid(qid.getQid());
        if(num != null){
            respReplyNum.setNum(num);
        }
        return respReplyNum;
    }

    @Override
    public List<Reply> getReply(Qid qid) {
        List<Reply> replyList = replyDao.getAllByQid(qid.getQid());
        return replyList;
    }
}
