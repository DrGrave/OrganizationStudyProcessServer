<template lang="pug">
.form-inline.my-2.my-lg-0
    input.form-control.mr-sm-2(v-model='login', type='text', placeholder='Логин')
    input.form-control.mr-sm-2(v-model='password', type='password', placeholder='Пароль')
    button.btn.btn-outline.my-2.my-sm-0(v-on:click='signIn') Войти
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
    		getToken(this);
            this.$root.user='load';
    	}
    }
}

function getUser(self){
    console.log("GET USER");
    var myHeaders = new Headers();
    myHeaders.append("Authorization", localStorage.getItem("Auth"));
    myHeaders.append("Content-Type", "application/json");
    fetch('/GetUser', {
      method: "POST",
      headers: myHeaders,
      body: JSON.stringify({userLogin:self.login})
    }).then(function(r){
      console.log(r);
      return r.json();
    }).then(function(user){
        console.log(user);
        self.$root.user = user;
        localStorage.setItem('user', JSON.stringify(user));
    }).catch(function(err){
        alert("Произошла ошибка");
        console.error(err);
    });
}

function getToken(self){
    if(self.login&&self.password){
        fetch('/login',{
            method: "POST",
            body: JSON.stringify({userLogin:self.login, userPassword:self.password})
        })
        .then(function(res){
            console.log(res);
            if(res.status==200){
                localStorage.setItem('Auth', res.headers.get("Authorization"));
            }
            if(res.status==401){
                alert("Неправильный логин или пароль");
            }
            getUser(self);
        }).catch(function(err){
            alert("Произошла ошибка");
            console.error(res);
        });
    }
    else{
        alert("Не заполненое поле!")
    }
}

</script>