import axios from 'axios'

const URL_INDEX = 'http://localhost:9090/index';
const URL_LOGIN = 'http://localhost:9090/login';
const URL_REGISTER = 'http://localhost:9090/register';
const URL_QUESTION = 'http://localhost:9090/question';
const URL_GETALLQUESTION = 'http://localhost:9090/getAllQuestion';
const URL_REPLYCOUNTBYQID = 'http://localhost:9090/getCountByQid';
const URL_REPLY = 'http://localhost:9090/getReplyByQid';
const URL_SEARCH = 'http://localhost:9090/search';

//register
export function setUser(admin,cb){
    sendAxios(URL_REGISTER,admin,cb);
}

//login
export function getIdByUserAndPsw(admin,cb) {
    sendAxios(URL_LOGIN,admin,cb);
}

//index
export function getUserById(user,cb) {
    sendAxios(URL_INDEX,user,cb);
}

//question
export function setQuestion(question,cb) {
    sendAxios(URL_QUESTION,question,cb);
}

//getAllQuestion
export function getAllQuestion(cb) {
    sendAxios(URL_GETALLQUESTION,null,cb);
}

//Reply
export function getReply(qid,cb) {
    sendAxios(URL_REPLY,qid,cb);
}

//Reply count
export function getReplyCountByQid(qid,cb) {
    sendAxios(URL_REPLYCOUNTBYQID,qid,cb);
}

//Search
export function getQuestionByStr(str,cb) {
    sendAxios(URL_SEARCH,str,cb);
}

function sendAxios(url,data,cb) {
    axios({
        method:'post',
        url:url,
        headers:{
            'Content-Type': 'application/json;charset=UTF-8'
        },
        data:JSON.stringify(data)
    }).then(res => {
        cb(res.data);
    })
}
