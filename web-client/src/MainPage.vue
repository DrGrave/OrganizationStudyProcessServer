<template>
    <div>
        <navigation></navigation>
        <page></page>
    </div>
</template>

<script>
import routes from './routes'
import Navigation from './forms/Navigation.vue'

let currentRoute = window.location.pathname
const matchingView = routes[currentRoute]
console.log(matchingView);
let Page = require('./pages/404.vue')
if(matchingView){
    Page = require('./pages/'+ matchingView +'.vue')
}

window.addEventListener('popstate', () => {
  currentRoute = window.location.pathname
})

module.exports = {
    data(){
        return {
            title: 'Главная',
            message: 'Здароу пользователь',
            login: '',
            password: ''
        }
    },
    components: {
        Navigation,
        Page
    }
}

</script>

<style>
    .starter-template {
        padding: 5rem 2rem;
    }
</style>