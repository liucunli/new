<template>
    <div class="center">
        <div class="login-box col-center-block">
            <div class="avatar">
                <img src="../static/img/img.jpg"/>
            </div>
            <div class="alert alert-success text-center successAlert" role="alert">success</div>
            <div class="alert alert-danger text-center failAlert" role="alert">{{str}}</div>
            <hr/>
            <div class="input-group">
                <div>Username</div>
                <input id="user" v-model="user" type="text" class="form-control" placeholder="Username" autocomplete="off" style="width: 310px">
            </div>
            <div class="input-group">
                <div>Password</div>
                <input id="psw" v-model="psw" type="Password" class="form-control" placeholder="Password" autocomplete="off" style="width: 310px">
            </div>
            <div class="input-group">
                <div>Confirm Password</div>
                <input id="psw1" v-model="psw1" type="Password" class="form-control" placeholder="Confirm Password" autocomplete="off" style="width: 310px">
            </div>

            <router-link to="/login"><button id="login_bt" class="bt text-a">Login</button></router-link>
            <button id="reg_bt" @click="register" class="bt text-a">Register</button>
        </div>

    </div>
</template>

<script>
    import 'bootstrap/dist/css/bootstrap.min.css'
    import 'bootstrap/dist/js/bootstrap.min.js'
    import $ from 'jquery'
    import "../static/css/login.css"
    import {setUser} from '../api/UserApi'
    export default {
        name: "Register",
        data:function(){
            return{
                user:'',
                psw:'',
                psw1:'',
                str:''
            }
        },
        methods:{
            register: function () {
                if (this.user === '') {
                    this.str = 'user is null';
                    showFail();
                } else if (this.psw === '' || this.psw1 === '') {
                    this.str = 'password is null';
                    showFail();
                } else if (this.psw !== this.psw1) {
                    this.str = 'two password is not equal';
                    showFail();
                } else if (this.psw.length > 16) {
                    this.str = 'password too long';
                    showFail();
                } else {
                    let admin = {
                        username: this.user,
                        password: this.psw
                    }

                    //调用api
                    setUser(admin,(data) => {
                        if (data.code === 1) {
                            showSuccess();
                            const userId = data.credential;
                            if (window.localStorage) {
                                const storage = window.localStorage;
                                storage.setItem("userId", userId);
                                this.$router.push({
                                    name: "Index"
                                })
                            }
                        } else if (data.code === 0) {
                            showFail();
                        } else {
                            showFail();
                        }
                    });

                }

                function showFail() {
                    $(".failAlert").fadeIn();
                    setTimeout(function () {
                        $(".failAlert").fadeOut();
                    }, 2000)
                }

                function showSuccess() {
                    $(".successAlert").fadeIn();
                    setTimeout(function () {
                        $(".successAlert").fadeOut();
                    }, 2000)
                }
            },
        }
    }
</script>

<style scoped>
    .successAlert,.failAlert{
        position: absolute;
        top: 165px;
        width: 200px;
        left: 50%;
        margin-left: -100px;
        display: none;
    }
</style>