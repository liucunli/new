
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        questions:[],
        replys:[],
        userNow:{
            uid:'',
            username:"My",
            avatar:"img.jpg",
            password:"",
            type:"user"
        },
        users:[],
        num:""
    },
    mutations: {
        setUserNow: (state,user) => {
            state.userNow = user;
        },
        setNum: (state, payload) => {
            state.num = payload;
        },
        setQuestion:((state, payload) => {
            state.questions = payload;
        }),
        setReply:((state, payload) => {
            state.replys = payload;
        })

    },
    getters: {
        getQuestionById: (state) => (qid) => {
            return state.questions.find(question => question.qid == qid)
        }
    }
})

export default store;