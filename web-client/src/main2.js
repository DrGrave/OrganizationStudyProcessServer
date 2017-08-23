import Vue from 'vue'

import Homepage from './components/home.vue'

Vue.component('pagebody', {
  	render (h) {
      return h(Homepage)
    },
   	props: ['title', 'message'],
  	methods: {
  		singIn: function () {
              	fetch('localhost:8080/login',{
              		method: "POST",
              		body: JSON.stringify( {userLogin:this.login, userPassword:this.password} )
              	}).then(function(response) {
              	  return response;
             	 }).then(function(res){
              	  console.log("-----");
             	  console.log(res);
             	  if(res.status==200){
                  localStorage.setItem('Auth', res.headers.get("Authorization"));
                  getUser(app.login);
             	  }
             	 }).catch(function(err){
              		console.log(err);
              	});
  	}
  }
})

new Vue({
  el: '#app',
  data: {
      title: 'Главная',
      message: 'Здароу пользователь',
      login: '',
      password: '',
      user: null,
      currentRoute: window.location.pathname
  }/*,
  methods: {
        singIn: function () {
              	fetch('localhost:8080/login',{
              		method: "POST",
              		body: JSON.stringify( {userLogin:this.login, userPassword:this.password} )
              	}).then(function(response) {
              	  return response;
             	 }).then(function(res){
              	  console.log("-----");
             	  console.log(res);
             	  if(res.status==200){
                  localStorage.setItem('Auth', res.headers.get("Authorization"));
                  getUser(app.login);
             	  }
             	 }).catch(function(err){
              		console.log(err);
              	});
        }
    },
    render (h) {
      return h(Homepage)
    },
    template: '<Homepage/>'*/
});

function getUser(userLogin){
    var myHeaders = new Headers();
    myHeaders.append("Authorization", localStorage.getItem("Auth"));
    myHeaders.append("Content-Type", "application/json");
    fetch('localhost:8080/GetUser', {
      method: "POST",
      headers: myHeaders,
      body: JSON.stringify({userLogin:userLogin})
    }).then(function(r){
      localStorage.setItem('userLogin', app.login);
      app.user = r.json();
      console.log(app.user);
    }).catch(function(err){
        console.log(err);
    });
}