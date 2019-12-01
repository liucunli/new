package com.news.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TwoReply {
    @Id
    private Integer tid;
    private String word;
    private Date time;
    private Integer rid;
    private Integer uid;

    public TwoReply() {}
    public TwoReply(int tid, String word, Date time, int rid, int uid) {
        this.tid = tid;
        this.word = word;
        this.time = time;
        this.rid = rid;
        this.uid = uid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
