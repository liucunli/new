package com.news.controller;

import com.news.model.Reply;
import com.news.model.req.Qid;
import com.news.model.res.RespCode;
import com.news.model.res.RespReplyNum;
import com.news.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/reply")
    public RespCode setReply(@RequestBody Reply reply){
        return replyService.setReply(reply);
    }

    @PostMapping("/getCountByQid")
    public RespReplyNum getCountByQid(@RequestBody Qid qid){
        return replyService.getCountByQid(qid);
    }

    @PostMapping("/getReplyByQid")
    public List<Reply> getReply(@RequestBody Qid qid){
        return replyService.getReply(qid);
    }
}
