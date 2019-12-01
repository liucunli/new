<template>
    <div>
        <HeadNav/>
        <div  style="background: white;margin: 30px" class="container-fluid">
            <div class="col-lg-9 col-sm-12 col-md-12 col-xs-12">
                <h4 class="question-title"><span>{{question.title}}</span></h4>
                <span class="text-desc">
                    作者：<span>{{question.userName}}</span> |
                    发布时间：<span>{{question.time}}</span> |
                    阅读数： <span>{{question.view}}</span>
                 </span>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 markdown-body editormd-html-preview" id="question-view">
                    <p>{{question.word}}</p>
                </div>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <!-- 标签 -->
                    <span v-for="(tag,index) in question.tags" :key="index" class="question-tag">
                        <router-link :to="'tag='+tag" class="tag">{{tag}}</router-link>
                    </span>

                    <!--<span class="question-tag">
                        <a href="/?page=1&amp;tag=php" class="tag">php</a>
                    </span><span class="question-tag">
                        <a href="/?page=1&amp;tag=javascript" class="tag">javascript</a>
                    </span>-->

                </div>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                <!--回复列表-->
                <h4>
                    <span>{{replys.length}}</span> 个回复
                </h4>
                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div>
                    <Reply v-for="(reply,index) in replys" :key="index" :reply="reply"></Reply>
                </div>

                <!--回复输入框-->
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h4>
                        提交回复
                    </h4>
                    <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12 comment-sp">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="comment_section">
                        <div class="media user-reply">
                            <div class="media-left">
                                <a href="#">
                                    <img class="media-object img-rounded" src="../static/img/img.jpg">
                                </a>
                            </div>
                            <div class="media-body">
                                <h5 class="media-heading">
                                    <span>{{user.username}}</span>
                                </h5>
                            </div>
                        </div>
                        <input type="hidden" id="question_id" value="516">
                        <textarea class="form-control comment" rows="6" id="comment_content"></textarea>
                        <button type="button" class="btn btn-success btn-comment">回复</button>
                    </div>
                </div>
            </div>

            <!-- 左列 -->
            <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h4>发起人</h4>
                    <div class="media">
                        <div class="media-left">
                            <a href="#">
                                <img class="media-object img-rounded" src="../static/img/img.jpg">
                            </a>
                        </div>
                        <div class="media-body">
                            <h5 class="media-heading">
                                <span>chaney</span>
                            </h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 side">
                    <h4>官方微信</h4>
                    <img class="img-thumbnail question-wechat" src="../static/img/wechat.png">
                </div>
            </div>
        </div>
        <Footer/>
    </div>
</template>

<script>
    import Reply from "@/components/Reply";
    import Footer from "@/components/Footer";
    import HeadNav from "@/components/HeadNav";
    import {getReply} from "../api/UserApi"

    export default {
        name: "showWord",
        components: {Footer, Reply, HeadNav},
        data:function () {
            return {

            }
        },
        computed:{
            question:{
               get() {
                   let questions = this.$store.state.questions;
                   let qid = this.$route.query.qid;
                   let question = questions.find(q => q.qid == qid);
                   // eslint-disable-next-line no-console
                   console.log(question);
                   return question;
               }
            },
            user:{
               get() {
                   return this.$store.state.userNow;
               }
            },
            replys:{
                get(){
                    let replys = this.$store.state.replys;
                    return replys;
                }
            }

        },
        created:function () {
            let qid = this.$route.query.qid;
            let qid1 = {
                qid: qid
            }
            //api
            getReply(qid1,(data) => {
                this.$store.commit('setReply',data);
                // eslint-disable-next-line no-console
                console.log('getReply',data);
            });
        }
    }

</script>

<style scoped>
    .media .media-left img{
        width: 38px;
        height: 38px;
    }
    .question-title{
        margin-top: 25px;
    }
    .text-desc {
        font-size: 12px;
        font-weight: normal;
        color: #999;
    }
    .tag{
        text-decoration-line: none;
        cursor: pointer;
        display: inline-block;
        height: 20px;
        line-height: 16px;
        padding: 2px 5px;
        background-color: #99cfff;
        font-size: 12px;
        color: #fff !important;
        border-radius: 4px;
        margin: 4px;
    }
    .question-tag{
        margin-right: 5px;
    }
    .btn{
        float: right;
    }
    .media-heading{
        margin-top: 8px;
    }
    .user-reply{
        margin-bottom: 10px;
    }
</style>