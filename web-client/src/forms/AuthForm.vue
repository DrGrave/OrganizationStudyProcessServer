<template>
	<div class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" v-model="login" type="text" placeholder="Логин" />
            <input class="form-control mr-sm-2" v-model="password" type="password" placeholder="Пароль" />
            <button class="btn btn-outline my-2 my-sm-0" v-on:click="signIn">Войти</button>
    </div>
</template>

<script>
module.exports = {
    data(){
        return {
            login: '',
            password: ''
        }
    },
    methods:{
    	signIn(){
    		console.log("Login: "+this.login+" Password: "+this.password);
    	}
    }
}
</script>