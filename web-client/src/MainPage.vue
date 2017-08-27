<template>
    <div>
        <navigation></navigation>
        <slot></slot>
    </div>
</template>

<script>
import Navigation from './forms/Navigation.vue'

export default {
    data(){
        return {
            title: 'Главная',
            message: 'Здароу пользователь',
            login: '',
            password: ''
        }
    },
    components: {
        Navigation
    }
}

</script>

<style>
    .starter-template {
        padding: 5rem 2rem;
    }
</style>