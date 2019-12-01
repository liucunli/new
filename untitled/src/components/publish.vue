<template>

    <div>
        <HeadNav/>
        <div>
            <div style="background: white;margin: 30px" class="container-fluid">
                <div class="col-lg-9 col-sm-12 col-md-12 col-xs-12">
                    <h2><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>发起</h2>
                    <hr/>
                    <div class="form-group">
                        <label for="title">问题标题（简单扼要）:</label>
                        <input type="text" class="form-control" v-model="title" id="title" name="title" placeholder="问题标题……" autocomplete="off">
                    </div>
                    <div class="form-group editormd editormd-vertical" id="question-editor" style="width: 100%; height: 350px;">
                        <label for="description">问题补充 (必填):</label>
                        <textarea name="description" v-model="word" id="description" style="" class="form-control editor-markdown-textarea"
                                  cols="30" rows="10" placeholder="请输入问题描述">

                    </textarea>
                    </div>
                    <div class="form-group">
                        <label for="tag">添加标签:</label>
                        <input type="text" class="form-control" v-model="tags" id="tag" name="tag" autocomplete="off"
                               placeholder="输入标签，以，号分隔">
                    </div>
                    <div class="container-fluid main ">
                        <div class="row">
                            <div class="col-lg-10 col-md-12 col-sm-12 col-xs-12">

                            </div>
                            <div class="col-lg-2 col-md-12 col-sm-12 col-xs-12">
                                <button type="button" @click="setQ" class="btn btn-success btn-publish ">
                                    发布
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">
                    <h3>问题发起指南</h3>
                    • 问题标题: 请用精简的语言描述您发布的问题，不超过25字 <br>
                    • 问题补充: 详细补充您的问题内容，并确保问题描述清晰直观, 并提供一些相关的资料<br>
                    • 选择标签: 选择一个或者多个合适的标签，用逗号隔开，每个标签不超过10个字<br>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    import 'bootstrap/dist/css/bootstrap.min.css'
    import 'bootstrap/dist/js/bootstrap.min.js'
    import HeadNav from "@/components/HeadNav";
    import {setQuestion} from  "../api/UserApi.js"

    export default {
        name: "Publish",
        components: {HeadNav},
        data:function () {
            return {
                title: '',
                word: '',
                tags: ''
            }
        },
        methods:{
            //set question to serve
            setQ(){
                //组装数据
                let uid;
                if(window.localStorage){
                    uid = window.localStorage.getItem("userId");

                    // eslint-disable-next-line no-console
                    console.log(uid);
                }
                if(uid){
                    let question = {
                        qid: 0,
                        uid: uid,
                        //avatar:"img.jpg",
                        title: this.title,
                        word: this.word,
                        //replyNum: 0,
                        view: 0,
                        time: Date.now(),
                        tags: this.tags,
                    }

                    //api set question
                    setQuestion(question,(data) => {
                        if(data.code == 1){
                            this.$router.push({
                                name:"Index"
                            })
                        }
                    })
                } else {
                    // eslint-disable-next-line no-console
                    console.log("public:no uid");

                    this.$router.push({
                        name:'Login'
                    })
                }

            }
        }
    }
</script>

<style scoped>

</style>