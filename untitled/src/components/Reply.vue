<template>
    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 comments">
        <div class="media">
            <div class="media-left">
                <a href="#">
                    <img class="media-object img-rounded" src="../static/img/img.jpg">
                </a>
            </div>
            <div class="media-body" id="comment-body-1633">
                <h5 class="media-heading">
                    <span>{{reply.userName}}</span>
                </h5>
                <div>{{reply.word}}</div>
                <div class="menu">
                    <span class="glyphicon glyphicon-thumbs-up icon">{{reply.ok}}</span>
                    <span class="comment-icon">
                                    <span class="glyphicon glyphicon-comment"></span>
                                    <span>{{reply.replys.length}}</span>
                                </span>
                    <span class="pull-right">{{reply.time}}</span>
                </div>
                <!--二级评论-->
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 collapse sub-comments" id="comment-1633">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <input type="text" class="form-control" placeholder="评论一下……" id="input-1633">
                        <button type="button" class="btn btn-success pull-right" onclick="comment(this)" data-id="1633">评论
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
    </div>
</template>

<script>
    export default {
        name: "Reply",
        props:['reply'],

    }
</script>

<style scoped>
    .media .media-left img{
        width: 40px;
        height: 40px;
    }
    .menu .icon {
        margin-right: 6px;
        font-size: 15px;
        cursor: pointer;
    }
</style>