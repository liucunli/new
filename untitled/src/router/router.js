//router.js
import Vue from 'vue'
import Router from 'vue-router'
import Publish from "@/components/Publish";
import Index from "@/components/Index";
import ShowList from "@/components/ShowList";
import Login from "@/components/Login";
import ShowWord from "@/components/ShowWord";
import Register from "@/components/Register";
Vue.use(Router) //这句别忘记了
export default new Router({
    mode:'history',  //使用history防止url中出现#
    routes: [
        {
            path: '/',
            redirect:'/index'
        },
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/Register',
            component: Register
        },
        {
            path: '/public',
            name: 'Public',
            component: Publish
        },
        {
            path: '/word',
            name: 'Word',
            component: ShowWord
        },
        {
            path: '/index',
            name: 'Index',
            component: Index,
            redirect: '/index/new',
            children:[
                {
                    path: '/index/hot',
                    component: ShowList
                }
                , {
                    path: '/index/hot7',
                    component: ShowList
                }
                , {
                    path: '/index/hot30',
                    component: ShowList
                }
                ,{
                    path: '/index/new',
                    component: ShowList
                }
            ]
        }
    ]
})