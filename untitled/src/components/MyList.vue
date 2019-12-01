<template>
    <div class="media">
        <div class="media-left media-middle">
            <a href="#">
                <img class="media-object img-rounded" src="../static/img/img.jpg" alt="头像">
            </a>
        </div>
        <div class="media-body">
            <h4 class="media-heading" @click="showWord"><!--<router-link :to="'/word?qid='+question.qid">-->{{question.title}}<!--</router-link>--></h4>
            <h6>{{ReplyNum}}个回复 • {{question.viewNum}} 次浏览 • {{question.time}}</h6>
        </div>
    </div>
</template>

<script>
    export default {
        name: "MyList",
        props:['question'],
        methods:{
            showWord(){
                this.$router.push({
                    name:"Word",
                    query:{
                        qid:this.question.qid
                    }
                })
            }
        },
        computed:{
            ReplyNum:{
                // eslint-disable-next-line vue/no-async-in-computed-properties
                get(){
                    let num = 0;
                    return num;
                }
            }
        }
    }
</script>

<style scoped>
    .media{
        margin: 20px 0;
    }
    .media .media-left img{
        width: 40px;
        height: 40px;
    }
    .media .media-body h6{
        font-size: 12px;
        font-weight: normal;
        color: #999;
    }
</style>