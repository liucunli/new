<template>
    <div>
        <HeadNav/>
        <div  style="background: white;margin: 30px" class="container-fluid">
            <div class="col-lg-9 col-sm-12 col-md-12 col-xs-12">
                <h3 v-on:click="ts"><span class="glyphicon glyphicon-list" aria-hidden="true"></span> 发现</h3>
                <ul id="indexnav" class="nav nav-tabs">
                    <li v-for="(item,index) in list " :key="index" v-bind:class="{active:index==current}" v-on:click="showNav(index,$event)">
                        <!--<a :href="'/?sort='+item.keyword">{{item.title}}</a>-->
                        <router-link :to="'/index/'+item.keyword">{{item.title}}</router-link>
                    </li>
                </ul>
                <router-view></router-view>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li class="active">
                            <a href="/?page=1&amp;search=&amp;tag=&amp;sort=no">1</a>
                        </li>

                        <li>
                            <a href="/?page=2&amp;search=&amp;tag=&amp;sort=no">2</a>
                        </li>

                        <li>
                            <a href="/?page=3&amp;search=&amp;tag=&amp;sort=no">3</a>
                        </li>

                        <li>
                            <a href="/?page=4&amp;search=&amp;tag=&amp;sort=no">4</a>
                        </li>

                        <li>
                            <a href="/?page=2&amp;search=&amp;tag=&amp;sort=no" aria-label="Previous">
                                <span aria-hidden="true">&gt;</span>
                            </a>
                        </li>
                        <li>
                            <a href="/?page=11&amp;search=&amp;tag=&amp;sort=no" aria-label="Previous">
                                <span aria-hidden="true">&gt;&gt;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 col-md-12 col-sm-12 col-xs-12">

                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 side">
                    <h4>官方微信</h4>
                    <img class="img-thumbnail question-wechat" src="../static/img/wechat.png">
                </div>


                <hr class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <h4>热门标签</h4>
                    <a href="/?page=1&amp;search=&amp;tag=java&amp;sort=no" class="tag">java</a>
                    <a href="/?page=1&amp;search=&amp;tag=javascript&amp;sort=no" class="tag">javascript</a>
                    <a href="/?page=1&amp;search=&amp;tag=spring&amp;sort=no" class="tag">spring</a>
                    <a href="/?page=1&amp;search=&amp;tag=html&amp;sort=no" class="tag">html</a>
                    <a href="/?page=1&amp;search=&amp;tag=mysql&amp;sort=no" class="tag">mysql</a>
                    <a href="/?page=1&amp;search=&amp;tag=html5&amp;sort=no" class="tag">html5</a>
                    <a href="/?page=1&amp;search=&amp;tag=php&amp;sort=no" class="tag">php</a>
                    <a href="/?page=1&amp;search=&amp;tag=css&amp;sort=no" class="tag">css</a>
                    <a href="/?page=1&amp;search=&amp;tag=github&amp;sort=no" class="tag">github</a>
                    <a href="/?page=1&amp;search=&amp;tag=linux&amp;sort=no" class="tag">linux</a>
                </div>
            </div>
        </div>

        <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12">
            <Footer/>
        </div>

    </div>
</template>

<script>

    import "../js/indexNav.js"
  //  import MyList from "@/components/MyList";
    import HeadNav from "@/components/HeadNav";
    import Footer from "@/components/Footer";
    import {getUserById,getAllQuestion} from '../api/UserApi';


    export default {
        name: "index",
        data:function(){
            return {
                list:[
                    {title:"最新",keyword:"new"},
                    {title:"最热",keyword:"hot"},
                    {title:"7天最热",keyword:"hot7"},
                    {title:"30天最热",keyword:"hot30"},
                ],
                current: 0
            }
        },
        created:function () {
            if(window.localStorage){
                const storage = window.localStorage;
                const uid = storage.getItem("userId");
                // eslint-disable-next-line no-console
                console.log(uid);
                if(uid !== '' && uid !== null){
                    let user = {
                        uid:uid
                    }

                    //Api接口获取用户数据
                    getUserById(user,(data) => {
                        // eslint-disable-next-line no-console
                        console.log('getUserById:',data);
                        this.$store.commit('setUserNow',data);
                        // eslint-disable-next-line no-console
                        console.log("have uid",this.$store.state.userNow);
                    });

                    //Api获取questions数据
                    getAllQuestion((data) => {
                        // eslint-disable-next-line no-console
                        console.log('getAllQuestion:',data);
                        this.$store.commit('setQuestion',data);
                    })
                }
            }
        },
        components: {HeadNav, Footer},
        methods:{
            ts(){
                // eslint-disable-next-line no-console
                console.log("dss")
            },
            showNav(index,event){
                this.current = index;
                let el = event.currentTarget;
                // eslint-disable-next-line no-console
                console.log("当前对象的内容："+el);
            }
        }
    }


</script>

<style scoped>
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
.index-body{
    margin: 30px;
    background-color: white;
}
</style>